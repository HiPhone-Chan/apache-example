package com.chf.example.apache.commons.chain;

import java.net.URL;

import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.config.ConfigParser;
import org.apache.commons.chain.impl.CatalogFactoryBase;

public class CatalogLoader {

    public static final String CFG_FILE = "chain-cfg.xml";

    public static Catalog CATALOG;

    static {
        ConfigParser parser = new ConfigParser();

        URL url = ClassLoader.getSystemResource(CFG_FILE);
        try {
            parser.parse(url);
            CATALOG = CatalogFactoryBase.getInstance().getCatalog();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Command getCommand(String commandName) {
        return CATALOG.getCommand(commandName);
    }

}
