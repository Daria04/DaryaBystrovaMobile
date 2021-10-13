package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebData {

    private static String url;
    private static String keyword;

    public static String getURL() {
        return url;
    }

    public static String getKeyword() {
        return keyword;
    }

    static {

        readCredentials();
    }

    public static void readCredentials() {
        try (InputStream input = new FileInputStream("src/test/resources/properties/webData.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            url = prop.getProperty("url");
            keyword = prop.getProperty("keyword");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
