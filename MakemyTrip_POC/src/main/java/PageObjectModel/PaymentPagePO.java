package PageObjectModel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPagePO {
    public WebDriver driver;

    public PaymentPagePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='Payment Options']")
    WebElement paymentOption;

    public void isPaymentPageReached() {

        String text = paymentOption.getText();
        System.out.println(text);
    }

}
