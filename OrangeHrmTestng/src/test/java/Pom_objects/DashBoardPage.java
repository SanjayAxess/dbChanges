package Pom_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;
import java.util.List;


public class DashBoardPage {
    public WebDriverWait wait;

    public WebDriver driver;
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));


    public DashBoardPage(WebDriver driver) {
        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    @FindAll({
         //   @FindBy(xpath = "//p6[text()='Dashboard']"),
            @FindBy(xpath = "//span[text()='Dashboard']")
    })
    WebElement dashboardpage;

    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']")
    List<WebElement> dashboard_widget;

    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-quick-launch-card']")
    List<WebElement> QuickLaunchOptions;

    @FindBy(xpath = "//p[text()='Quick Launch']")
    WebElement quickLaunchGrid;


    public void IsindashBoardpage() {

        Assert.assertEquals(dashboardpage.getText(), "Dashboard");
        System.out.println(dashboardpage.getText() + "is present and visible");

    }

    public List<WebElement> totalWidgetinDashBoardPage() {

        List<WebElement> widgetCount = dashboard_widget;
        Assert.assertEquals(widgetCount.size(), 7, "Should have 7 dashboard widget");
        return dashboard_widget;
    }

    public List<WebElement> getQuickLaunchOptions() {

        List<WebElement> optionCount = QuickLaunchOptions;
        Assert.assertEquals(optionCount.size(), 6, "Should have 6 menu items");
        return QuickLaunchOptions;
    }


    public void quickLaunchGrid() {

        Assert.assertEquals(quickLaunchGrid.getText(), "Quick Launch");
        System.out.println(quickLaunchGrid.getText() + "grid is present and visible");


    }

}
