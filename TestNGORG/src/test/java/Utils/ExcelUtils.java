package Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public  static String[][] getExcelData1() throws IOException {
        String path ="src/test/resources/Configuration/ReadExcel.xlsx";


        FileInputStream fileinput = new FileInputStream(path);

        XSSFWorkbook workbook = new XSSFWorkbook(fileinput);

        XSSFSheet sheet = workbook.getSheetAt(2);

        int lastRowNum = sheet.getLastRowNum(); // exclude the header tells how many rows

         sheet.getPhysicalNumberOfRows(); // tells how many headers row


        short getLastCellNum = sheet.getRow(0).getLastCellNum();
        String[][] data = new String[lastRowNum][getLastCellNum];
        for (int i = 1; i <=lastRowNum; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < getLastCellNum; j++) {
                XSSFCell cell = row.getCell(j);
                DataFormatter dataformater = new DataFormatter();
                String value = dataformater.formatCellValue(cell);
                data[i-1][j] = value;
            }
        }
        workbook.close();
        return data;
    }

}

