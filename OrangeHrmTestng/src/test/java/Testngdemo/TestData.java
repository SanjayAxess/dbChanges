package Testngdemo;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider
    public Object[][] validData() {
        Object[][] obj = {{"Admin", "admin123"}};
        return obj;

    }

    @DataProvider
    public Object[][] invalidData() {

        Object[][] obj = {{"admin", "Admin123"}};
        return obj;

    }

    @DataProvider
    public Object[][] employeLeaveDetails() {

        Object[][] obj = {{"OCDZjrUVyX p user", "Medical appointment scheduled for tomorrow morning. Will be available from afternoon"}};
        return obj;
    }

    @DataProvider
    public Object[] dashboardData() {
        Object[] obj = {
                "6"};
        return obj;

    }
}
