package OrangeHRM;

import PageObjectModel.DashBoardPage;
import PageObjectModel.LoginPage;
import Utils.ConfigReaderUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DashBoardPageTest extends Hooks{

    @Test(enabled = true, priority = 2, description = "Dash Board")
    public void dashBoard() {
        defaultLogin();
        DashBoardPage dashBoard = new DashBoardPage(driver);

        dashBoard.quickLaunchGrid();
        dashBoard.IsindashBoardpage();
        dashBoard.getQuickLaunchOptions();
        dashBoard.totalWidgetinDashBoardPage();
    }
}
