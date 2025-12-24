package PageObjectModel;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AssignLeavePage {

    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public AssignLeavePage(WebDriver dr) {
        this.driver = dr;
        //System.out.println("In Assign leave Page Driver is "+ dr);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Leave']")
    private WebElement leavePage;

    @FindBy(xpath = "(//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-quick-launch-card'])[1]")
    WebElement applyLeave;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeName;

    @FindBy(xpath = "//label[text()='Leave Type']/following::div[contains(@class,'oxd-select-text')][1]")
    WebElement leaveType;


    @FindBy(xpath = "//span[contains(text(),'Personal')]")
    private WebElement personaleave;

    @FindBy(xpath = "//label[text()='From Date']/following::input[1]")
    private WebElement fromDateField;

    @FindBy(xpath = "//label[text()='To Date']/following::input[1]")
    private WebElement toDateField;

    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
    private WebElement DurationDropdown;

    @FindBy(xpath = "//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
    private WebElement reasonForLeave;

    @FindBy(xpath = "//button[text()=' Assign ']")
    private WebElement assignLeaveButton;

    @FindBy(xpath = "//button[text()=' Ok ']")
    private WebElement isAlertPresent;


    public void clickApplyleave() {
        applyLeave.click();
    }

    public void IsinLeavepage() {

       Assert.assertEquals(leavePage.getText(), "Leave");
        System.out.println(leavePage.getText() + " is present and visible");

    }

    public void enterEmployeName(String empName) throws InterruptedException {
        employeName.click();
        employeName.sendKeys(empName);
        Thread.sleep(2000);
        employeName.sendKeys(Keys.ARROW_DOWN);
        employeName.sendKeys(Keys.ENTER);
    }

    public void setLeaveType() {
        leaveType.click();
        personaleave.click();
    }

    public void selectFromDate() throws InterruptedException {

       /* fromDateField.click();
        WebElement fromToady = driver.findElement(By.xpath("//div[text()='Today']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) fromToady)).click();*/
       fromDateField.sendKeys(Keys.CONTROL + "a");
        Thread.sleep(1000);
        fromDateField.sendKeys(Keys.DELETE);
        String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        fromDateField.sendKeys(todayDate);
        fromDateField.sendKeys(Keys.ENTER);
    }


    public void selectToDate() {
        /*toDateField.click();
        WebElement toTODAY = driver.findElement(By.xpath("//div[text()='Today']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) toTODAY)).click();*/
        toDateField.sendKeys(Keys.CONTROL + "a");
        toDateField.sendKeys(Keys.DELETE);
        String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        toDateField.sendKeys(todayDate);
        toDateField.sendKeys(Keys.ENTER);

    }

    public void PartialDays() {
        DurationDropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement halfDayMorning = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Half Day - Morning')]")));
        halfDayMorning.click();
    }

    public void commants(String commants) {
        reasonForLeave.sendKeys(commants);
    }

    public void clickAssignLeavebtn() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Click Assign button
        WebElement assignButton = driver.findElement(By
                .xpath("//button[@type='submit' and text()=' Assign ']"));
        js.executeScript("arguments[0].click();", assignButton);

        // Wait for confirmation popup and click OK
        WebElement confirmButton = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[contains(@class,'oxd-button--label-orange')]")));
        confirmButton.click();

        // Wait for success message or redirect
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//p[contains(@class,'oxd-text-toast-message')]")));
    }

   /* public void isAlertPresent(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.oxd-dialog-container-default")));


        WebElement okBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Ok']")));



    }*/

}


