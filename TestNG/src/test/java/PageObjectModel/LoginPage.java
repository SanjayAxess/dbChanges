package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //System.out.println("In login page Driver is: " + driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@alt='company-branding']")
    private WebElement checkLogo;

    @FindBy(xpath = ".//h5[text()='Login']")
    private WebElement checkLoginText;

    @FindBy(xpath = ".//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath = ".//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement LoginButton;

    @FindBy(xpath = ".//p[text()='Forgot your password? ']")
    private WebElement ForgotPassword;

    @FindBy(xpath = "//p[text()='Invalid credentials']")
    private WebElement errormassage;



    public boolean logocheck() {

        return checkLogo.getAttribute("alt") == "company-branding";
    }

    public boolean loginText() {

        return checkLoginText.getText() == "Login";
    }

    public void enterusername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterpassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        LoginButton.click();
    }

    public void forgetPassword() {
        ForgotPassword.click();
    }

    public void errortext() {
        System.err.println(errormassage.getText());
    }

    public void login(String username, String password) {

        enterusername(username);
        enterpassword(password);
        clickLoginButton();
    }

}
