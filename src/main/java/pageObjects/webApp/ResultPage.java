package pageObjects.webApp;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class ResultPage extends BasePage {

    @FindBy(xpath = "//*[@class='g']")
    List<WebElement> searchResults;

    public ResultPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public List<String> actualSearchResults() {
        return searchResults
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }
}
