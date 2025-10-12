package OrangeHRM;

import PageObjectModel.LogoutPage;
import org.testng.annotations.*;

public class LogOutTest extends Hooks{

    @Test(enabled = true,priority = 5)
    public void logout() throws InterruptedException {
        defaultLogin();
        LogoutPage logout = new LogoutPage(driver);
        logout.clickLogout();
    }
}
