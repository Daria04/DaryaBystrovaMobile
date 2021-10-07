package scenarios;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;
import pageObjects.nativeApp.BudgetActivityPage;
import pageObjects.nativeApp.LoginActivityPage;
import pageObjects.PageObject;
import service.Constants;
import service.UserData;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "Registration and click on the Sign In button")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        LoginActivityPage loginActivityPage = (LoginActivityPage) ((PageObject) getPo()).getSomePageObject();
        BudgetActivityPage budgetActivityPage = loginActivityPage
            .registrationNewAccount()
            .registerNewAccount(UserData.getEmail(), UserData.getUsername(), UserData.getPassword())
            .loginValidation(UserData.getEmail(), UserData.getPassword());

        assertThat(budgetActivityPage.getBudgetTitle()).isEqualTo(Constants.EXPECTED_TITLE);
        System.out.println("Simplest Android native test done");
    }
}
