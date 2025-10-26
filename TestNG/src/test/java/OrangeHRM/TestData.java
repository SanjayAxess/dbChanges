package OrangeHRM;

import Utils.ExcelUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class TestData {
    @DataProvider(name = "vaildData")
    public Object[][] vaildData() {
        Object[][] obj = {{"Admin", "admin123"}};
        return obj;
    }

    @DataProvider(name = "ExcelvalidData",parallel = true)
    public String[][] ExcelvalidData() throws IOException {


        String[][] excelData = ExcelUtils.getExcelData1();
        return excelData;

    }

    @DataProvider(name = "invalidData")
    public Object[][] invalidData() {

        Object[][] obj = {

                {"Root", "Admin123"},

        };
        return obj;
    }

    @DataProvider
    public Object[][] employeLeaveDetails() {

        Object[][] obj = {{"john", "Medical appointment scheduled for tomorrow morning. Will be available from afternoon"}};
        return obj;
    }
    @DataProvider
    public Object[] dashboardData() {
        Object[] obj = {
                "6"};
        return obj;
    }
}
