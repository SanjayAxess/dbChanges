package TestPackage;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import AssuredDemoPackage.DemoRA1HomeClass;

public class RAHomePage1TestClass {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize  browser;
    	
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/"); // change to your actual site
    }

    @Test
    public void productSearchBox() {
        DemoRA1HomeClass home = new DemoRA1HomeClass(driver);
        home.enterProductNameIntoSearchBar("iphone");
    }

   
    
    
    
    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(5000); // wait 5 seconds before closing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       
        driver.quit();
    }

}

