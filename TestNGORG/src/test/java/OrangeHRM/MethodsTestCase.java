package OrangeHRM;

import PageObjectModel.*;
import Utils.ConfigReaderUtils;
import org.testng.annotations.*;


/*@Listeners({CustomeListeners.TestListeners.class})
public class MethodsTestCase extends Hooks {

    @Test(enabled = false, priority = 2, dataProviderClass = TestData.class,
            dataProvider = "vaildData")
    public void LoginCredentialsValid(String username, String password) throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        Thread.sleep(1000);
        login.enterusername(username);
        login.enterpassword(password);
        login.clickLoginButton();
    }
    @Test(enabled = false)
    @Parameters({"userName" , "password"})
    private void LoginPropertieFile(String un , String pwd) {
        ConfigReaderUtils config = new ConfigReaderUtils();
        LoginPage login = new LoginPage(driver);

       String ProuserName = config.getProperty("userName");
       String PropassWord = config.getProperty("password");
        login.enterusername(un);
        login.enterpassword(pwd);
        login.clickLoginButton();
    }
    @Test(priority = 2, dataProviderClass = TestData.class, dataProvider = "ExcelvalidData")
    public void LoginExcelFile(String[] data){
        LoginPage login = new LoginPage(driver);

        login.enterusername(data[0]);
        login.enterpassword(data[1]);
        login.clickLoginButton();

    }

    @Test(priority = 1, description = "invalid login data", dataProviderClass = TestData.class, dataProvider = "invalidData")
    public void LoginCredentialsInValid(String username, String password) {
        LoginPage login = new LoginPage(driver);

        login.enterusername(username);
        login.enterpassword(password);
        login.clickLoginButton();
        login.errortext();

    }



    @Test(enabled = true, priority = 4, description = "leave details", dataProviderClass = TestData.class, dataProvider = "employeLeaveDetails")
    public void assignLeave(String empName, String commands) throws InterruptedException {
        AssignLeavePage leave = new AssignLeavePage(driver);
        Thread.sleep(2000);
        leave.IsinLeavepage();
        leave.clickApplyleave();
        leave.enterEmployeName(empName);
        leave.setLeaveType();
        leave.selectFromDate();
        leave.selectToDate();
        leave.commants(commands);
        leave.clickAssignLeavebtn();
        leave.isAlertPresent(driver);


    }


}*/