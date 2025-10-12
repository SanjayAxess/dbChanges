package OrangeHRM;

import PageObjectModel.LoginPage;
import Utils.ConfigReaderUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import PageObjectModel.*;
import org.testng.annotations.*;

public class LoginPageTest extends Hooks{
    ConfigReaderUtils config;
    @Test(enabled = false, priority = 1, dataProviderClass = TestData.class, dataProvider = "vaildData")
    public void LoginExcelFile(String[] data){
        config = new ConfigReaderUtils();
        String URL = config.getProperty("URL");
        driver.get(URL);
        System.out.println("In Assign leave Page Driver is "+ driver);
        LoginPage login = new LoginPage(driver);

        login.enterusername(data[0]);
        login.enterpassword(data[1]);
        login.clickLoginButton();

    }
    @Test(enabled = true,  description = "invalid login data", dataProviderClass = TestData.class, dataProvider = "invalidData")
    public void LoginCredentialsInValid(String username, String password) {
        LoginPage login = new LoginPage(driver);

        login.enterusername(username);
        login.enterpassword(password);
        login.clickLoginButton();
        login.errortext();

    }

}
