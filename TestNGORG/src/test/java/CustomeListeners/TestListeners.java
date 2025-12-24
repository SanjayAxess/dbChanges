package CustomeListeners;


import OrangeHRM.Hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.*;


public class TestListeners implements ITestListener {
    private static final String SCREENSHOT_DIR = "src/test/ScreenShots/failer.png";

    public WebDriver driver;


    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("Starting test: " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
        try {
            TakeScreenshot(result, "PASSES");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        try {
            TakeScreenshot(result, "FAILED");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("Test skipped: " + result.getName());
    }

    public void TakeScreenshot(ITestResult result, String status) throws IOException {
        Object testInstance = result.getInstance();
        WebDriver driver = ((Hooks) testInstance).driver;
        System.out.println("on screenshot method.");
        if (driver != null) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(SCREENSHOT_DIR);
        FileUtils.copyFile(src, destination);
        } else {
            System.out.println("Driver is null, cannot take screenshot.");
        }
    }
}