package task_OrangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	
	@FindBy (xpath="//img[@alt='client brand banner']")
	private WebElement OrangeHRMLogo;
	
	
	WebDriver driver;
	public  DashBoardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
		}

	public boolean LogoDB() {
		
		if(OrangeHRMLogo.getAttribute("alt")=="client brand banner")
		return true;
		
		else
			return false;
	}

	}

