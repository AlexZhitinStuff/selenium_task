package Base;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class AllureTestListener implements ITestListener {


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }


    public void onStart(ITestContext context) {
        System.out.println(context.getName() + " started ***");
    }

    public void onFinish(ITestContext context) {

        System.out.println((context.getName() + " ending ***"));
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("*** Executed " + result.getMethod().getMethodName() + " test method successfully...");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("*** Execution of a test method" + result.getMethod().getMethodName() + " of a test class " + result.getMethod().getRealClass().getName() + " failed...");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((TestBase) testClass).getDriver();

        System.out.println("Screenshot captured for test case:" + (result.getMethod().getMethodName()));
        saveScreenshotPNG(webDriver);
        saveTextLog(result.getMethod().getMethodName() + " failed and screenshot taken!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("*** Tests " + result.getMethod().getMethodName() + " skipped...");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("*** Tests failed but within percentage % " + result.getMethod().getMethodName());
    }
}