package pageObjects.nativeApp;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractBasePage {

    protected AppiumDriver appiumDriver;
    protected WebDriverWait driverWait;

    public AbstractBasePage (AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        driverWait = new WebDriverWait(appiumDriver, 10L);
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void fieldData(WebElement element, String data) {
        driverWait.until(visibilityOf(element)).sendKeys(data);
    }

    public void clickBtn(WebElement element) {
        driverWait.until(visibilityOf(element)).click();
    }
}
