package Tests;

import Base.AllureTestListener;
import Base.TestBase;
import Pages.AccountPage;
import Pages.AuthenticationPage;
import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LogOutTest extends TestBase {
    private WebDriver driver;
    HomePage home_page;
    AuthenticationPage authentication_page;
    AccountPage account_page;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
        home_page = PageFactory.initElements(driver, HomePage.class);
        authentication_page = PageFactory.initElements(driver, AuthenticationPage.class);
        account_page = PageFactory.initElements(driver, AccountPage.class);
    }

    @Test(description = "Testcase: User can successfully log out by click on the Sign out button")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check if user can successfully log out from their account on by click on the Sign out button")
    public void log_out_ui() {

        String error = "Log out wasn't successfull";

        home_page.clickLogIn();
        authentication_page.logInSuccess();
        account_page.clickLogOut();

        if (authentication_page.checkAuthenticationPageURL()) {
            Assert.assertTrue(true);
        } else {
            AllureTestListener.saveTextLog(error);
            Assert.fail();
        }
    }


    @Test(description = "Testcase: User can successfully log out by calling http://automationpractice.com/index.php?mylogout=")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Check if user can successfully log out from their account by calling http://automationpractice.com/index.php?mylogout=")

    public void log_out_url() {

        String error = "Log out wasn't successfull";

        home_page.clickLogIn();
        authentication_page.logInSuccess();

        driver.get("http://automationpractice.com/index.php?mylogout="); //Calling to this URL logs out the user


        if (home_page.checkHomePageURL()) {
            Assert.assertTrue(true);
        } else {
            AllureTestListener.saveTextLog(error);
            Assert.fail();
        }
    }
}
