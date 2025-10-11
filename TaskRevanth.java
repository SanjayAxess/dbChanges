package selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskRevanth {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// enter in the search box
		driver.findElement(By.name("q")).sendKeys("mobiles", Keys.ENTER);

		// click on first item
		driver.findElement(By.xpath("(//div[@class='XqNaEv'])")).click();
		Thread.sleep(2000);

		// click on first item in the result
		int itemindex=1;
		String itemxpath=String.format(("(//div[@class='col col-7-12'])[%d]"), itemindex);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(itemxpath)));
		element.click();

		String mainwindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);

		for (int i = 0; i <= windows.size() - 1; i++) {
			driver.switchTo().window(windows.get(i));
		}

		WebElement buyNow = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='QqFHMw vslbG+ _3Yl67G _7Pd1Fp']")));
		buyNow.click();

		// enter the mobile number and click the continue button
		driver.findElement(By.xpath("//input[@class='r4vIwl Jr-g+f']")).sendKeys("9790946098");
		driver.findElement(By.xpath("//button[@type='submit']")).click();


//		close the current window
		driver.close();

		driver.switchTo().window(mainwindow);

		WebElement youTubeLink = driver.findElement(By.xpath("//img[contains(@src,'Youtube')]"));

		// click on youtube link
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", youTubeLink);
		youTubeLink.click();


		// click on first video
//		WebElement video1 = driver.findElement(By.xpath("(//ytd-grid-video-renderer[@class='style-scope yt-horizontal-list-renderer'])[2]"));

		int videoindex = 2;

		String videoxpath = String
				.format("(//ytd-grid-video-renderer[@class='style-scope yt-horizontal-list-renderer'])[%d]", videoindex);

		WebElement video1 = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath(videoxpath)));
		video1.click();

		WebElement durationElement = driver.findElement(By.cssSelector(".ytp-time-duration"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ytp-time-duration")));

		// After opening the video
		// ✅ Keep checking until video.duration is > 0
		Long totalSeconds = null;
		for (int i = 0; i < 10; i++) { // retry max 10 times
			totalSeconds = (Long) js.executeScript("return Math.floor(document.querySelector('video').duration);");
			if (totalSeconds != null && totalSeconds > 0) {
				break;
			}
			Thread.sleep(1000);
		}

		if (totalSeconds == null || totalSeconds == 0) {
			System.out.println("Could not fetch video duration");
			driver.quit();
			return;
		}

		System.out.println("Video duration in seconds: " + totalSeconds);

		// ✅ Wait for full video length
		Thread.sleep((totalSeconds + 2) * 1000);

		driver.close();

	}

}
