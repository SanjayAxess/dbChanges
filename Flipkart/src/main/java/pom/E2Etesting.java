package pom;

import Base.Baseclass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class E2Etesting extends Baseclass {

    public E2Etesting(WebDriver dr) {
        this.driver = dr;

        PageFactory.initElements(dr, this);
    }
    @FindBy(name = "q")
    WebElement search;

    @FindBy(xpath = "//div[@title='Apple']")
    WebElement checkbox;

    @FindBy(xpath = "//div[@class='tUxRFH']")
    List<WebElement> apple;

    @FindBy(xpath = "//button[text()='Buy Now']")
    WebElement buybutton;

    @FindBy(className = "F9+fd2")
    WebElement home;


    public void enterproduct() throws InterruptedException {
        Thread.sleep(2000);
        search.sendKeys("mobiles");
        search.sendKeys(Keys.ENTER);
    }

    public void clickbox(){
        checkbox.click();
    }
    public void Applephone() throws InterruptedException {
        Thread.sleep(2000);
        apple.get(0).click();

    }

    public void buynow() throws InterruptedException {
        Thread.sleep(3000);
        scrollontoview(buybutton);
        buybutton.click();
    }

    public void homepage(){
        home.click();
    }

}
