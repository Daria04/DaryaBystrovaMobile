package scenarios;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.PageObject;
import pageObjects.WebPageObject;
import service.Utils;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Go to a Google search page and make a search using keyword ‘EPAM’")
    public void simpleWebTest() throws InterruptedException {
        getDriver().get(Utils.getURL()); // open Google search

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        WebPageObject webPageObject = (WebPageObject) ((PageObject) getPo()).getSomePageObject();
        webPageObject.googleSearch.click();
        webPageObject.googleSearch.sendKeys(Utils.getKEYWORD());

        getDriver().getKeyboard().sendKeys(Keys.ENTER);
        getDriver().hideKeyboard();

        assertThat(webPageObject.areSearchResultsDisplayed())
            .as("There aren't relevant results on the Search page")
            .isTrue();

        // Log that test finished
        System.out.println("Site opening done");
    }
}
