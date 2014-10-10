package com.chf.example.apache.commons.mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SimpleEmailMain {

	public static void main(String[] args) {
		String from = "chengzhikai@odc.huawei.com";

		// String sender = "chenhaifeng";
		String password = "1qaz!QAZ";

		String receiver = "chenhaifeng1@huawei.com";
		String hostName = "10.82.67.141";
		// String hostName = "email-cn04.huawei.com";
		String content = "~~~~~~~~hi";
		String subject = "title";

		Email emailSender = new SimpleEmail();
		try {
			emailSender.setFrom(from);
			emailSender.setAuthentication(from, password);
			emailSender.setCharset("UTF-8");
			emailSender.setHostName(hostName);
			emailSender.addTo(receiver);
			emailSender.setMsg(content);
			emailSender.setSubject(subject);
			emailSender.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
		System.out.println("ok");
	}

}
