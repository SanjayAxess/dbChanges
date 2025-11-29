package fkPageObjectModelFolder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	
	@FindBy(xpath = ".//div[text()='Brand']")
	private WebElement clickBrannd;
	
	@FindBy(xpath = ".//div[text()='Apple']")
	private WebElement clickApple;
	
	@FindBy(xpath = ".//div[text()='Brand']")
	private WebElement click2Brannd;

	
	@FindBy(xpath = ".//div[@class='e+xvXX KvHRYS']//span[text()='19 MORE']")
	private WebElement clickMore;
	
	
	@FindBy(xpath = ".//div[text()='Samsung']")
	private WebElement clickSamsung;
	
	@FindBy(xpath = ".//div[text()='Price -- Low to High']")
	private WebElement clickPriceLowToHigh;
	
	@FindBy(xpath = ".//div[@class='tUxRFH']") 
	private WebElement clickfirstProduct;
	
	
	public ProductPage(WebDriver driver ) {
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnBrand() {
	 clickBrannd.click();
	}
	
	public void clickOnApple() {
		 clickApple.click();
		}
	
	public void clickOn2Brand() {
		 click2Brannd.click();
		}
		
	
	public void clickOnMore() {
		 clickMore.click();
		}
		
	
	public void clickOnSamsung() {
		 clickSamsung.click();
		}
	
	public void clickOnLowToHighprice() {
		 clickPriceLowToHigh.click();
		}
	

	public void clickOnFirstProduct() {
		 clickfirstProduct.click();
		}
	
}
