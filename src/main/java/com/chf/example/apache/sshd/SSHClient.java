package com.chf.example.apache.sshd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.sshd.ClientChannel;
import org.apache.sshd.ClientSession;
import org.apache.sshd.SshClient;
import org.apache.sshd.client.UserInteraction;

import com.sun.xml.internal.ws.util.NoCloseInputStream;
import com.sun.xml.internal.ws.util.NoCloseOutputStream;

public class SSHClient {
	public static final int port = 22;

	public static void main(String[] args) throws Exception {
		SshClient client = SshClient.setUpDefaultClient();
		client.start();
		client.setUserInteraction(new UserInteraction() {
			public void welcome(String banner) {
				System.out.println(banner);
			}

			public String[] interactive(String destination, String name,
					String instruction, String[] prompt, boolean[] echo) {
				String[] answers = new String[prompt.length];
				try {
					for (int i = 0; i < prompt.length; i++) {
						BufferedReader r = new BufferedReader(
								new InputStreamReader(System.in));
						System.out.print(prompt[i] + " ");
						answers[i] = r.readLine();
					}
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
				return answers;
			}
		});

		ClientSession session = client.connect("root", "10.137.151.253", 22)
				.await().getSession();
		session.addPasswordIdentity("huawei");

		session.auth();

		ClientChannel channel = session.createShellChannel();
		channel.setOut(new NoCloseOutputStream(System.out));
		channel.setErr(new NoCloseOutputStream(System.err));
		channel.setIn(new NoCloseInputStream(System.in));
		channel.open().await();

		channel.waitFor(ClientChannel.CLOSED, 0);
		// channel.close(false);
		session.close(false);
		client.stop();
		System.out.println("finish...");
	}
}
