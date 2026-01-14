package Pom_objects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AssignLeavePage {
    public WebDriverWait wait;

    public WebDriver driver;
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public AssignLeavePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // @FindAll({})
    //@FindBy(xpath = "//p6[text()='Leave']"),
    @FindBy(xpath = "//span[text()='Leave']")

    WebElement leavePage;
    @FindBy(xpath = "(//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-quick-launch-card'])[1]")
    WebElement applyLeave;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeName;

    @FindBy(xpath = "//label[text()='Leave Type']/following::div[contains(@class,'oxd-select-text')][1]")
    WebElement leaveType;


    @FindBy(xpath = "//span[contains(text(),'Personal')]")
    WebElement personaleave;

    @FindBy(xpath = "//label[text()='From Date']/following::input[1]")
    WebElement fromDateField;

    @FindBy(xpath = "//label[text()='To Date']/following::input[1]")
    WebElement toDateField;

    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
    WebElement DurationDropdown;

    @FindBy(xpath = "//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
    WebElement reasonForLeave;

    @FindBy(xpath = "//button[text()=' Assign ']")
    WebElement assignLeaveButton;

//    @FindBy(xpath = "//button[@class='oxd-icon-button oxd-main-menu-button']")
    WebElement okbtn;


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
        fromDateField.sendKeys(Keys.CONTROL + "a");Thread.sleep(1000);
        fromDateField.sendKeys(Keys.DELETE);
        String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        fromDateField.sendKeys(todayDate);
        fromDateField.sendKeys(Keys.ENTER);
    }
    //LocalDate tomorrow = LocalDate.now().plusDays(1);
    //            String tomorrowDate = tomorrow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    public void selectToDate() {
        toDateField.sendKeys(Keys.CONTROL + "a");
        toDateField.sendKeys(Keys.DELETE);
        String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        toDateField.sendKeys(todayDate);
        toDateField.sendKeys(Keys.ENTER);

    }

    public void PartialDays() {
        DurationDropdown.click();
        WebElement halfDayMorning = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Half Day - Morning')]")));
        halfDayMorning.click();
    }

    public void commants(String commants) {
        reasonForLeave.sendKeys(commants);
    }

    public void clickAssignLeavebtn(){

        assignLeaveButton.click();

    }
//    public void confirmPopUp(){



//        Alert confirmAlert = driver.switchTo().alert();
//        String text = confirmAlert.getText(); // e.g., "Are you sure?"
//        confirmAlert.dismiss();
    }



