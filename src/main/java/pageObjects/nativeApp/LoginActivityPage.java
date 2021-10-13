package pageObjects.nativeApp;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.BasePage;

public class LoginActivityPage extends BasePage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    WebElement loginEmailBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    WebElement loginPasswordBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Sign In']")
    WebElement signInBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Register new account']")
    WebElement registerBtn;

    public LoginActivityPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public RegistrationActivityPage registrationNewAccount() {
        driverWait.until(visibilityOf(registerBtn)).click();
        return new RegistrationActivityPage(appiumDriver);
    }

    public BudgetActivityPage loginValidation(String email, String password) {
        fieldData(loginEmailBtn, email);
        fieldData(loginPasswordBtn, password);
        clickBtn(signInBtn);
        return new BudgetActivityPage(appiumDriver);
    }
}
