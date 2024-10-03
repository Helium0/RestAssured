package api.utilities;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {

    private FileInputStream fileInput;
    private FileOutputStream fileOutput;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;
    private String path;

    public ExcelUtility (String path) {
        this.path = path;
    }


    public int getRowsNumber(String excelSheet) throws IOException {
        fileInput = new FileInputStream(path);
        workbook = new XSSFWorkbook(fileInput);
        sheet = workbook.getSheet(excelSheet);
        int rows = sheet.getLastRowNum();
        workbook.close();
        fileInput.close();

        return rows;

    }

    public int getCellsNumber(String excelSheet, int rowNumber) throws IOException {
        fileInput = new FileInputStream(path);
        workbook = new XSSFWorkbook(fileInput);
        sheet = workbook.getSheet(excelSheet);
        int cells = sheet.getRow(rowNumber).getLastCellNum();
        workbook.close();
        fileInput.close();

        return cells;
    }

    public String getCellData(String excelSheet, int rowNumber, int cellNumber) throws IOException {
        fileInput = new FileInputStream(path);
        workbook = new XSSFWorkbook(fileInput);
        sheet = workbook.getSheet(excelSheet);
        row = sheet.getRow(rowNumber);
        cell = row.getCell(cellNumber);

        String data;

        try {

            DataFormatter dataFormatter = new DataFormatter();
            data = dataFormatter.formatCellValue(cell);

        } catch (NullPointerException e) {

            data = " ";
        }

        workbook.close();
        fileInput.close();
        return data;
    }

    public void setCellData(String excelFile, String excelSheet, int rowNumber, int cellNumber, String data) throws IOException {
        fileInput = new FileInputStream(excelFile);
        workbook = new XSSFWorkbook(fileInput);
        sheet = workbook.getSheet(excelSheet);
        row = sheet.getRow(rowNumber);
        cell = row.createCell(cellNumber);
        cell.setCellValue(data);

        fileOutput = new FileOutputStream(excelFile);
        workbook.write(fileOutput);
        workbook.close();
        fileInput.close();
        fileOutput.close();
    }
}
