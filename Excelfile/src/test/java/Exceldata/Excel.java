package Exceldata;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Excel {


    public  void  exceldata() throws IOException {

        String path = "C:\\Users\\L E N O V O\\Desktop\\Book1.xlsx";

            FileInputStream fis = new FileInputStream(path);
            XSSFWorkbook workbook= new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(2);
            String un =sheet.getRow(0).getCell(0).getStringCellValue();
            System.out.println(un);
        }

    public static void main (String[] args) throws IOException {
        Excel ex = new Excel();
        ex.exceldata();

    }

}


