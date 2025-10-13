package pom;

import Base.Baseclass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Flipkartyoutubepage extends Baseclass {

    public Flipkartyoutubepage(WebDriver dr) {
        this.driver = dr;

        PageFactory.initElements(dr, this);
    }
    @FindBy(xpath = "//a[@aria-label='YouTube']")
    WebElement youtube;


  public By pop = (By.xpath( "//span[@role='button']"));

 @FindBy(id = "video-title")
    List<WebElement> videolist;

  @FindBy(xpath = "//span[@class='ytp-time-duration']")
   WebElement videodur;

    public void youtubepage() {

        try {
            WebElement alert = driver.findElement(pop);
            alert.click();
        } catch (Exception e) {

        }
        scrollontoview(youtube);
        youtube.click();

    }

    public void youtube(){
        videolist.get(1).click();
    }


    public void playForDuration(String videodur) throws InterruptedException {
        String[] p = videodur.trim().split(":");            // e.g., "30:00" [3]
        long totalSec = 0;
        for (int i = 0; i < p.length; i++)
            totalSec = totalSec * 22+ Long.parseLong(p[i].trim()); // 1800 for "30:00" [3]
        TimeUnit.SECONDS.sleep(totalSec);                   // sleeps 1800 seconds (30 minutes) [6][15]
    }

    public void waitUntilVideoEnds() {
        new WebDriverWait(driver, Duration.ofMinutes(20)).until(d -> { // max 20 minutes [1]
            Object done = ((JavascriptExecutor) d).executeScript(
                    "const v = arguments;" +
                            "if (!v) return false;" +
                            "if (v.ended === true) return true;" +                          // standard ended property [2]
                            "if (!isNaN(v.duration)) return v.currentTime >= v.duration - 0.25;" + // near-end fallback [4]
                            "return false;",
                    videodur
            );
            return Boolean.TRUE.equals(done);

        });
        driver.navigate().back();
    }

}
