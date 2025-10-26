package OrangeHRM;

import PageObjectModel.AssignLeavePage;
import PageObjectModel.LoginPage;
import Utils.ConfigReaderUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class AssignLeavePageTest extends Hooks{

    @Test(priority = 3, description = "leave details", dataProviderClass = TestData.class, dataProvider = "employeLeaveDetails")
    public void assignLeave(String empName, String commands) throws InterruptedException {
        AssignLeavePage leave = new AssignLeavePage(driver);
        defaultLogin();
        Thread.sleep(2000);
        leave.IsinLeavepage();
        leave.clickApplyleave();
        leave.enterEmployeName(empName);
        leave.setLeaveType();
        leave.selectFromDate();
        leave.selectToDate();
        leave.commants(commands);



    }

}
