package pageObjects.nativeApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.BasePage;

public class RegistrationActivityPage extends BasePage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    WebElement emailBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    WebElement usernameBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    WebElement passwordBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    WebElement confirmPasswordBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    WebElement registerNewAccountBtn;

    public RegistrationActivityPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public LoginActivityPage registerNewAccount(String email, String username, String password) {
        fieldData(emailBtn, email);
        fieldData(usernameBtn, username);
        fieldData(passwordBtn, password);
        fieldData(confirmPasswordBtn, password);
        clickBtn(registerNewAccountBtn);
        return new LoginActivityPage(appiumDriver);
    }
}
