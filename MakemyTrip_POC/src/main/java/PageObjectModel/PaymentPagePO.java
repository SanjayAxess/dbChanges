package PageObjectModel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPagePO {
    public WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    public PaymentPagePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='Payment Options']")
    WebElement paymentOption;

    public void isPaymentPageReached() {
        System.out.println("-------------- Entering Payment page --------------");
        String currentUrl = driver.getCurrentUrl();
        wait.until(ExpectedConditions.titleIs(currentUrl));
        wait.until(ExpectedConditions.visibilityOf(paymentOption));
        String text = paymentOption.getText();
        System.out.println(text);
    }

}
