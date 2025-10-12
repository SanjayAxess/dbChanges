package PageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserDetailsPO {
    public WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public UserDetailsPO(WebDriver driver){
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(@class, 'Complete booking')]")
    WebElement CompleteBooking;
    @FindBy(id = "fname")
    WebElement Entername;
        @FindBy(id = "age")
    WebElement Enterage;
        @FindBy(xpath = "//div[text()='Male']")
    WebElement gender;
        @FindBy(id = "contactEmail")
    WebElement email;
        @FindBy(id = "mobileNumber")
    WebElement mobilenumber;
        @FindBy(id = "dt_state_gst_info")
    WebElement selectStage;
        @FindBy(xpath = "//li[text()='Tamil Nadu']")
    WebElement SelectStageTamildu;
        @FindBy(xpath = "//p[text()='Confirm and save billing details to your profile']")
        WebElement confirmforBilling;

        @FindBy(xpath = "(//span[@class='sc-lhVmIH gLODGR'])[2]")
        WebElement TripAssured;
       @FindBy(xpath = "//div[contains(@class,'travelInsuranceWrapper ')]//input[@type='checkbox']")
        WebElement travelInsurance;
        @FindBy(xpath = "//span[text()='Continue']")
    WebElement continueForpayment;
        private void setEntername(){

            Entername.sendKeys("Gokul");
        }private void setGender(){

            gender.click();
        }
    private void setEnterage(){
            Enterage.sendKeys("24");
        }
    private void setEnteremail(){
            email.sendKeys("gokul@gmail.com");
        }
    private void setMobilenumber(){
            mobilenumber.sendKeys("6789912345");
        }
    private void SelectState() throws InterruptedException {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            selectStage.click();
            Thread.sleep(1000);
            SelectStageTamildu.click();
        }
    private void setConfirmforBilling(){
            confirmforBilling.click();
        }
    private void Secureyourtrip (){
        try {
            if(!TripAssured.isSelected()){
                wait.until(ExpectedConditions.elementToBeClickable(TripAssured));
                TripAssured.click();
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred in Secure your trip: " + e.getMessage());
        }

    }

        public void Contectdetails(){
            setEntername();
            setEnterage();
            setGender();
            setEnteremail();
            setMobilenumber();
        }
        public void mandatoryfields() throws InterruptedException {
            SelectState();
            setConfirmforBilling();
            Secureyourtrip();
        }
        public void paymentPage(){
            continueForpayment.click();
        }

}
