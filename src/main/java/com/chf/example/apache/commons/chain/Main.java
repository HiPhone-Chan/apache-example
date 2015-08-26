package com.chf.example.apache.commons.chain;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ChainBase;
import org.apache.commons.chain.impl.ContextBase;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("-------no cfg----------");
        Command process = new ChainBase() {
            {
                addCommand(new Command1());
            }
        };

        Map<String, String> map = new HashMap<>();
        map.put("Command1", "asd");
        map.put("Command2", "qw");
        Context ctx = new ContextBase(map);

        process.execute(ctx);

        System.out.println("-------cfg chain----------");

        Command cmd = CatalogLoader.getCommand("CommandChain");

        cmd.execute(ctx);

        System.out.println("-------cfg command----------");
        cmd = CatalogLoader.getCommand("command2");
        cmd.execute(ctx);
    }
}
