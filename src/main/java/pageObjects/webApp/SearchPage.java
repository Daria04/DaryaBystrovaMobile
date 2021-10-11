package pageObjects.webApp;

import static org.openqa.selenium.Keys.ENTER;
import static service.WebData.getKeyword;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//input[@name='q']")
    WebElement googleSearch;

    public SearchPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public SearchPage inputField() {
        fieldData(googleSearch, getKeyword());
        return this;
    }

    public ResultPage submitSearchBtn() {
        googleSearch.sendKeys(ENTER);
        return new ResultPage(appiumDriver);
    }
}