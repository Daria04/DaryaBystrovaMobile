package pageObjects;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebPageObject {

    @FindBy(xpath = "//input[@name='q']")
    public WebElement googleSearch;

    @FindBy(xpath = "//*[@class='g']")
    public List<WebElement> searchResults;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }

    public boolean areSearchResultsDisplayed() {
        for(WebElement actualSearchResults : searchResults) {
            if(!actualSearchResults.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
}
