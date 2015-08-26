package com.chf.example.apache.commons.chain;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;

public class MyFilter implements Filter {

    @Override
    public boolean execute(Context context) throws Exception {
        System.out.println("do filter before.");
        return false;
    }

    @Override
    public boolean postprocess(Context context, Exception exception) {
        System.out.println("do filter after.");
        return false;
    }

}
