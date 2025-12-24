package PageObjectModel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DashBoardPage {

    public WebDriver driver;

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
        //System.out.println("In DashBoard Page Driver is: " + driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[text()='Dashboard']")

    private WebElement dashboardpage;

    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']")
    private List<WebElement> dashboard_widget;

    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-quick-launch-card']")
    private List<WebElement> QuickLaunchOptions;

    @FindBy(xpath = "//p[text()='Quick Launch']")
    private WebElement QuickLaunchGridd;


    public void IsindashBoardpage() {

        Assert.assertEquals(dashboardpage.getText(), "Dashboard");
        System.out.println(dashboardpage.getText() + "is present and visible");

    }

    public void totalWidgetinDashBoardPage() {

        List<WebElement> widgetCount = dashboard_widget;
        Assert.assertEquals(widgetCount.size(), 7, "Should have 7 dashboard widget");
    }

    public void getQuickLaunchOptions() {

        List<WebElement> optionCount = QuickLaunchOptions;
        Assert.assertEquals(optionCount.size(), 6, "Should have 6 menu items");
    }

    public void quickLaunchGrid() {

        Assert.assertEquals(QuickLaunchGridd.getText(), "Quick Launch");
        System.out.println(QuickLaunchGridd.getText() + "grid is present and visible");

    }

}