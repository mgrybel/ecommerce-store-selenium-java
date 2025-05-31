package com.ecommerce.selenium.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
    private static ConfigUtils configUtils;
    private Properties prop;

    private ConfigUtils() {
        prop = readProp();
    }

    public static ConfigUtils getInstance() {
        if (configUtils == null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    private Properties readProp() {
        InputStream inputStream;
        try {
            String env = System.getProperty("env", "LOCAL");
            switch (env) {
                case "LOCAL" -> {
                    inputStream = new FileInputStream("src/test/resources/env/local.properties");
                }
                case "PRODUCTION" -> {
                    inputStream = new FileInputStream("src/test/resources/env/production.properties");
                }
                default -> {
                    throw new RuntimeException("Environment is not supported");
                }
            }
            prop = new Properties();
            prop.load(inputStream);
            System.out.println(prop.get("URL"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return prop;
    }

    public Object getBaseUrl() {
        return prop.get("URL");
    }
}
