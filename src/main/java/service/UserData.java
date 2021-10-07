package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserData {

    private static String email;
    private static String password;
    private static String username;

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUsername() {
        return username;
    }

    static {

        readCreds();
    }

    public static void readCreds() {
        try (InputStream input = new FileInputStream("src/test/resources/properties/userData.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            email = prop.getProperty("email");
            password = prop.getProperty("password");
            username = prop.getProperty("username");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
