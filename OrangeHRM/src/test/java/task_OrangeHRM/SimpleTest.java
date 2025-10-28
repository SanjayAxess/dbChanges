package task_OrangeHRM;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;

public class SimpleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='oxd-grid-3 orangehrm-dashboard-grid']/div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']/div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white orangehrm-dashboard-widget']/div[@class='orangehrm-dashboard-widget-body']/div[@class='oxd-grid-3 orangehrm-quick-launch']/div[1]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]")).sendKeys("Meenakshi  Menon");
		
//	WebElement leaveTypeDropDown = driver.findElement(By.xpath("//div[@class='oxd-select-text oxd-select-text--active']"));
//		Select leaveTypeSelect=new Select(leaveTypeDropDown);
//		leaveTypeSelect.selectByVisibleText("CAN - Matternity");
		
		// Click to open the dropdown
		WebElement dropdown = driver.findElement(By.xpath("//div[@class='oxd-select-text oxd-select-text--active']"));
		dropdown.click();

		// Select an option (say "CAN - Matternity")
		WebElement option = driver.findElement(By.xpath("//div[@class='oxd-select-text-input']//div[text()='CAN - Matternity']"));
		option.click();

		
		 driver.findElement(By.xpath("//div[@class='oxd-select-text oxd-select-text--active']")).sendKeys("CAN - Matternity");
		driver.findElement(By.xpath("//input[@placeholder=\"yyyy-dd-mm\"]")).sendKeys("2025-30-09");
		driver.findElement(By.xpath("(//input[@placeholder=\"yyyy-dd-mm\"])[2]")).sendKeys("2025-30-10");
		
		
		
		WebElement partialDaysDropDown = driver.findElement(By.xpath("//div[@class='oxd-select-text oxd-select-text--focus']"));
		Select PartialDaysSelect = new Select(partialDaysDropDown);
		PartialDaysSelect.selectByVisibleText("All Days");
		
		WebElement durationDropDown = driver.findElement(By.xpath("(//div[@class=\"oxd-select-text oxd-select-text--active\"])[3]"));
		Select durationSelect = new Select(durationDropDown);
		durationSelect.selectByVisibleText("Half Day - Morning");
		
		
		WebElement comments = driver.findElement(By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']"));
		
		comments.sendKeys("dfhgfhgldfhgldbgkfg sklhflsdhflks");
		
		driver.findElement(By.xpath("//button[normalize-space()='Assign']")).click();
		
		
		
		
		
		
		
		
	}

}
