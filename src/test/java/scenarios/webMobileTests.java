package scenarios;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static service.WebData.getKeyword;
import static service.WebData.getURL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.PageObject;
import pageObjects.webApp.ResultPage;
import pageObjects.webApp.SearchPage;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Go to a Google search page and make a search using keyword ‘EPAM’")
    public void simpleWebTest() throws InterruptedException {
        getDriver().get(getURL()); // open Google search

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
            wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        SearchPage searchPage = (SearchPage) ((PageObject) getPo()).getPageObject();
        ResultPage resultPage = searchPage.inputField().submitSearchBtn();

        resultPage.actualSearchResults().forEach(result -> assertThat(result)
            .as("There aren't relevant results on the Search page")
            .contains(getKeyword()));

        // Log that test finished
        System.out.println("Site opening done");
    }
}
