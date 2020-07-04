package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {


    public static WebElement waitVisibilityOfElement(WebElement element, int time, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        System.out.println("Element: " + element.getText() + " " + element.getTagName());
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean waitURL (String url, int time, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.urlToBe(url));
    }
}
