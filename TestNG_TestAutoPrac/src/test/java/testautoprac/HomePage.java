package testautoprac;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	@FindBy(id = "name")
	private WebElement nameTextBox;

	@FindBy(id = "email")
	private WebElement emailTextBox;

	@FindBy(id = "phone")
	private WebElement phoneTextBox;

	@FindBy(id = "textarea")
	private WebElement addressTextBox;

	@FindBy(xpath = "//input[@class='form-check-input'][@type='radio']")
	private List<WebElement> genderRadioButtons;

	@FindBy(xpath = "//input[@class='form-check-input'][@type='checkbox']")
	private List<WebElement> daysCheckBoxes;

	@FindBy(id = "country")
	private WebElement countryDropDown;

	@FindBy(id = "colors")
	private WebElement colorsDropDown;

	@FindBy(id = "alertBtn")
	private WebElement simpleAlert;

	@FindBy(name = "BookTable")
	private WebElement staticWebTable;

	public WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterName(String Name) {
		nameTextBox.sendKeys(Name);
	}

	public void enterMail(String Mail) {
		emailTextBox.sendKeys(Mail);

	}

	public void enterPhone(String Mobile) {
		phoneTextBox.sendKeys(Mobile);
	}

	public void selectGender(String genderValue) {

		for (WebElement genderRadio : genderRadioButtons) {
			if (genderRadio.getAttribute("value").equalsIgnoreCase(genderValue)) {
				System.out.println(genderRadio.getAttribute("value").equalsIgnoreCase(genderValue));
				genderRadio.click();

			}
		}
	}

	public void selectDaysCheckBox(String... daysToSelect) {
		for (WebElement daysCheckBox : daysCheckBoxes) {
			String value = daysCheckBox.getAttribute("value");
			for (String day : daysToSelect) {
				if (value.equalsIgnoreCase(day) && (!daysCheckBox.isSelected())) {
					daysCheckBox.click();
				}

			}
		}
	}

	public void selectCountry(String countryValue) {
		Select countrySelection = new Select(countryDropDown);
		countrySelection.selectByValue(countryValue);
	}

	public void clickAlert() {

		simpleAlert.click();
		driver.switchTo().alert().accept();
	}

	public boolean verifyStaticTableDisplay() {
		if (staticWebTable.isDisplayed())
			return true;
		else
			return false;
	}
}
