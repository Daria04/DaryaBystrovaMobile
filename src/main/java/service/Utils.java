package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    private static String EMAIL;
    private static String PASSWORD;
    private static String USERNAME;
    private static String URL;
    private static String KEYWORD;

    public static String getEmail() {
        return EMAIL;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    public static String getUsername() {
        return USERNAME;
    }

    public static String getURL() {
        return URL;
    }

    public static String getKEYWORD() {
        return KEYWORD;
    }

    static {

        readCreds();
    }

    public static void readCreds() {
        try (InputStream input = new FileInputStream("src/test/resources/properties/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            EMAIL = prop.getProperty("email");
            PASSWORD = prop.getProperty("password");
            USERNAME = prop.getProperty("username");
            URL = prop.getProperty("url");
            KEYWORD = prop.getProperty("keyword");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
