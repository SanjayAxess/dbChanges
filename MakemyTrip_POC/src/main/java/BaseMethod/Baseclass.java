package BaseMethod;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Baseclass {
public static WebDriver driver;



    public static void initializeBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void WebPageurl (String url){
        driver.get(url);
    }

    public static void dismissAlert() {
        try {
            WebElement loginPopup = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
            loginPopup.click();
            WebElement add = driver.findElement(By.xpath("//span[@data-testid='travel-card-close']"));
            add.click();

            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
        }
    }
    public static void teardown(){
        driver.quit();
    }
}
