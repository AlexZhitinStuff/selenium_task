package Helper;

import Base.AllureTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Utils {

    public static void clickElement(WebElement element, int time, WebDriver driver) {
        try {
            Waiters.waitVisibilityOfElement(element, time, driver);
            element.click();
        } catch (Throwable e) {
            AllureTestListener.saveTextLog(e.toString());
            System.out.println(e);
        }
    }

    public static void input (WebElement element, int time, WebDriver driver, String input) {
        try {
            Waiters.waitVisibilityOfElement(element, time, driver);
            element.sendKeys(input);
        } catch (Throwable e) {
            AllureTestListener.saveTextLog(e.toString());
            System.out.println(e);
        }
    }


}
