package Testngdemo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class hooks {

    public WebDriver driver;
    @BeforeClass
    public void launchDrier() throws InterruptedException {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
//        options.addArguments("--start-maximized");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }
    @AfterClass
    public void QuitBrowser() {
//

    }

}
