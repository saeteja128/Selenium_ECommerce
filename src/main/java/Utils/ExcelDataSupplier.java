package Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;


public class ExcelDataSupplier {

    public ExcelDataSupplier() throws IOException {
    }

    File loginExcelFile = new File("./src/main/resources/TestData/LoginCreds.xlsx");
    FileInputStream fis = new FileInputStream(loginExcelFile);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);

    @DataProvider
    public String[][] getLoginData() {

        XSSFSheet loginSheet = workbook.getSheet("Sheet1");
        int noOfRows = loginSheet.getPhysicalNumberOfRows();
        int noOfCols = loginSheet.getRow(0).getLastCellNum();

        String[][] data = new String[noOfRows - 1][noOfCols];
        for (int i = 0; i < noOfRows - 1; i++) {
            for (int j = 0; j < noOfCols; j++) {
                DataFormatter df = new DataFormatter();
                data[i][j] = df.formatCellValue(loginSheet.getRow(i + 1).getCell(j));
            }
        }
        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String[] dataArr : data) {
            System.out.println();
            System.out.println("Excel Data for Login Page: "+Arrays.toString(dataArr));
        }
        return data;
    }

    @DataProvider
    public String[][] getProductData() {
        XSSFSheet loginSheet = workbook.getSheet("Sheet2");
        int noOfRows = loginSheet.getPhysicalNumberOfRows();
        int noOfCols = loginSheet.getRow(0).getLastCellNum();

        String[][] data = new String[noOfRows - 1][noOfCols];
        for (int i = 0; i < noOfRows - 1; i++) {
            for (int j = 0; j < noOfCols; j++) {
                DataFormatter df = new DataFormatter();
                data[i][j] = df.formatCellValue(loginSheet.getRow(i + 1).getCell(j));
            }
        }
        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String[] dataArr : data) {
            System.out.println();
            System.out.println("Excel Data for Product Selection: " +Arrays.toString(dataArr));
        }
        return data;
    }

}



