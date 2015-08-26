package com.chf.example.apache.commons.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ConfigUtil {

    private static Configuration config;

    static {
        try {
            config = new PropertiesConfiguration("config.properties");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static String getConfig(String key) {
        return config.getString(key, null);
    }

    public static void main(String[] args) {
        System.out.println(getConfig("asd"));
    }
}
