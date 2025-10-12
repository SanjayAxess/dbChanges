package PageObjectModel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePagePO {

    public WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public HomePagePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='menu_Buses']")
    WebElement clickOnBus;
    @FindBy(id = "fromCity")
    WebElement fromCityInput;
    @FindBy(id = "toCity")
    WebElement toCityInput;
    @FindBy(xpath = "//input[@placeholder='From']")
    WebElement fromCitySearch;
    @FindBy(xpath = "//input[@placeholder='To']")
    WebElement toCitySearch;
    @FindBy(id = "travelDate")
    WebElement travelDate;
    @FindBy(xpath = "(//div[@class='DayPicker-Day'])[3]")
    WebElement chooseDate;
    @FindBy(id = "search_button")
    WebElement searchButton;

    public void busBooking() {
        clickOnBus.click();
    }

    public void fromCity(String fromCity) throws InterruptedException {

        WebElement fromElement = wait.until(ExpectedConditions.elementToBeClickable(fromCityInput));
        fromElement.click();
        Thread.sleep(1000);

        // Enter city name in search box
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(fromCitySearch));
        searchInput.clear();
        searchInput.sendKeys(fromCity);
        Thread.sleep(1000);
        searchInput.sendKeys(Keys.DOWN);
        searchInput.sendKeys(Keys.ENTER);
    }

    public void toCity(String toCity) throws InterruptedException {
        WebElement toElement = wait.until(ExpectedConditions.elementToBeClickable(toCityInput));
        toElement.click();
        Thread.sleep(1000);

        // Enter city name in search box
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(toCitySearch));
        searchInput.clear();
        searchInput.sendKeys(toCity);
        Thread.sleep(1000);
        searchInput.sendKeys(Keys.DOWN);
        searchInput.sendKeys(Keys.ENTER);
    }

    public void FromCity_ToCity(String depature, String Arrival) throws InterruptedException {
        toCity(Arrival);
        fromCity(depature);
    }

    public void TravelDate() {
        travelDate.click();
        chooseDate.click();
    }

    public void SearchBus() {
        searchButton.click();
    }
}
