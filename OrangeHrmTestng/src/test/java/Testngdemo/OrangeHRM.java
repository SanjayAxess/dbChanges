package Testngdemo;


import Pom_objects.AssignLeavePage;
import Pom_objects.DashBoardPage;
import Pom_objects.loginPage;
import org.testng.annotations.Test;

public class OrangeHRM extends hooks {

    @Test(priority = 2,  description = "valid login data", dataProviderClass = TestData.class, dataProvider = "validData")
    public void LoginCredentialsValid(String username, String password) throws InterruptedException {

        loginPage login = new loginPage(driver);
        Thread.sleep(1000);
        login.enterusername(username);
        login.enterpassword(password);
        login.clickLoginButton();
    }

    @Test(priority = 1, description = "invalid login data", dataProviderClass = TestData.class, dataProvider = "invalidData")
    public void aLoginCredentialsinValid(String username, String password) {
        loginPage login = new loginPage(driver);

        login.enterusername(username);
        login.enterpassword(password);
        login.clickLoginButton();
        login.errortext();

    }

    @Test(priority = 3,description = "Dash Board")
    public void cdashBoard(){
        DashBoardPage dashBoard = new DashBoardPage(driver);
        dashBoard.quickLaunchGrid();
        dashBoard.IsindashBoardpage();
        dashBoard.getQuickLaunchOptions();
        dashBoard.totalWidgetinDashBoardPage();

    }
    @Test(priority = 4, description = "leave details", dataProviderClass = TestData.class, dataProvider = "employeLeaveDetails")
    public void dassignLeave(String empName, String commands) throws InterruptedException {
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
//        leave.confirmPopUp();

    }
}
