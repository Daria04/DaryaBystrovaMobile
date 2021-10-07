package pageObjects.nativeApp;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.BasePage;

public class BudgetActivityPage extends BasePage {

    protected AppiumDriver appiumDriver;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout"
        + "/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]"
        + "/android.view.ViewGroup/android.widget.TextView")
    WebElement budgetTitle;

    public BudgetActivityPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
    }

    public String getBudgetTitle() {
        return driverWait.until(visibilityOf(budgetTitle)).getText();
    }
}
