package OrangeHRM;


import PageObjectModel.LoginPage;
import Utils.ConfigReaderUtils;
import groovy.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;




public class Hooks {
    ConfigReaderUtils config;
    public WebDriver driver;
    @BeforeClass
    public void launchDrier(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void driverUrl(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public void QuitBrowser() {
        if (driver != null) {
          driver.quit();
        }
    }
    public void defaultLogin(){
        LoginPage login = new LoginPage(driver);
         config = new ConfigReaderUtils();
        String  userName = config.getProperty("USERNAME");
        String  password = config.getProperty("PASSWORD");
        login.login(userName,password);
    }

}
