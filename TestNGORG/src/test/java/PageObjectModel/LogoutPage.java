package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    public WebDriver driver;

    @FindBy(xpath = "//li[@class='oxd-userdropdown']")
    WebElement userdropdown;
    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutButton;

    public LogoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickLogout() throws InterruptedException {
        userdropdown.click();
        Thread.sleep(2000);
        logoutButton.click();
    }
}
