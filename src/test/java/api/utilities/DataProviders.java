package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "Data")
    public String [][] getAllData () throws IOException {
        String path = System.getProperty("user.dir") + "\\testData\\UsersFile.xlsx";
        ExcelUtility exUt = new ExcelUtility(path);

        int rowNum = exUt.getRowsNumber("Users");
        int colNum = exUt.getCellsNumber("Users", 1);

        String apiData[][] = new String[rowNum][colNum];

        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                apiData[i - 1][j] = exUt.getCellData("Users", i, j);
            }
        }
        return apiData;
    }

    @DataProvider(name = "UserNames")
    public String [] getAllUsername () throws IOException {
            String path = System.getProperty("user.dir")+"\\testData\\UsersFile.xlsx";
            ExcelUtility exUt = new ExcelUtility(path);
            int rowNum = exUt.getRowsNumber("Users");

            String apiData[] = new String[rowNum];

            for(int i=1; i<=rowNum; i++) {
                apiData[i-1] = exUt.getCellData("Users",i,1);
            }
            return apiData;
        }

    }
