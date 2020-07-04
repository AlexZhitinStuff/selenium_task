package Pages;

import Helper.Utils;
import Helper.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    protected WebDriver driver;

    @FindBy(xpath = "//a[@class='login']")
    WebElement buttonLogIn;

    String url = "http://automationpractice.com/index.php";


    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Click Log In button on the Home page")
    public void clickLogIn() {
        Utils.clickElement(buttonLogIn, 5, driver);
    }

    @Step("Check by URL if the page opened is Authentication page")
    public boolean checkHomePageURL() {
        return Waiters.waitURL(url, 10, driver);
    }
}
