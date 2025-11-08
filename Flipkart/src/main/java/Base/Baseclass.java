package Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Baseclass {
    public static JavascriptExecutor js;
    public static WebDriver driver;

    public static void web(){
       driver = new ChromeDriver();
    }

    public static void launchbrowser(String urlname ){

        driver.get(urlname);
    }
    public static void maximize() {

        driver.manage().window().maximize();
    }

    public static void impwait(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public static void Switchtomain(WebDriver driver) {

        String mainWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
            }
        }

    }
   public void scrollontoview(WebElement wl){
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView()", wl);

   }
   public  static void Back(){
        driver.navigate().back();
   }



}
