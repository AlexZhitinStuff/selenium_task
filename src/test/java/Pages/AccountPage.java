package Pages;

import Helper.Utils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {


    protected WebDriver driver;

    @FindBy(xpath = "//a[@class='logout']")
    WebElement buttonLogOut;

    public AccountPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Click Log Out button on the Account page")
    public void clickLogOut() {
        Utils.clickElement(buttonLogOut, 5, driver);
    }
}
