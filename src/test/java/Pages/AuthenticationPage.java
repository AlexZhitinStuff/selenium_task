package Pages;

import Helper.Utils;
import Helper.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AuthenticationPage {

    protected WebDriver driver;

    @FindBy(xpath = "//input[@id='email']")
    WebElement fieldEmail;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement fieldPassword;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement buttonSignIn;

    String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    String email = "aszhitinstuff@gmail.com";
    String password = "12345";
    

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Click Sign In button on the authentication page")
    public void clickSignIn() {
        Utils.clickElement(buttonSignIn, 5, driver);
    }

    @Step("Put in valid credentials and click the Sign in button")
    public void logInSuccess() {
        Utils.input(fieldEmail, 5, driver, email);
        Utils.input(fieldPassword, 5, driver, password);
        Utils.clickElement(buttonSignIn, 5, driver);
    }

    @Step("Check by URL if the page opened is Authentication page")
    public boolean checkAuthenticationPageURL() {
        return Waiters.waitURL(url, 10, driver);
    }
}
