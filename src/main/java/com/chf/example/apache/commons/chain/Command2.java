package com.chf.example.apache.commons.chain;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

public class Command2 implements Command {

    @Override
    public boolean execute(Context context) throws Exception {
        System.out.println("Command2 get :" + context.get("Command2"));
        return false;
    }

}
