package pageObjects.nativeApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.BasePage;

public class RegistrationActivityPage extends BasePage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    WebElement emailBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    WebElement usernameBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    WebElement passwordBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    WebElement confirmPasswordBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/"
        + "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/"
        + "android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/"
        + "android.widget.CheckedTextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@enabled='true']")
    WebElement enableCheckbox;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Register new account']")
    WebElement registerNewAccountBtn;

    public RegistrationActivityPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public LoginActivityPage registerNewAccount(String email, String username, String password) {
        fieldData(emailBtn, email);
        fieldData(usernameBtn, username);
        fieldData(passwordBtn, password);
        fieldData(confirmPasswordBtn, password);
        clickBtn(enableCheckbox);
        clickBtn(registerNewAccountBtn);
        return new LoginActivityPage(appiumDriver);
    }
}
