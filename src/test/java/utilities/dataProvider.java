package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class dataProvider {
	@DataProvider(name="loginData")
	public String[][] getData() throws Exception {
		
		File excelFile = new File("./src/test/resources/TestOneData.xlsx");

		System.out.println(excelFile.exists());
		FileInputStream fis = new FileInputStream(excelFile);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Rows = " + noOfRows);
		System.out.println("Columns = " + noOfColumns);

		String[][] data = new String[noOfRows - 1][noOfColumns];
		for (int i = 0; i < noOfRows - 1; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				DataFormatter df = new DataFormatter();

				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
				 System.out.print(data[i][j] + " | ");

			}
			System.out.println();
		}

		workbook.close();
		fis.close();
		return data;

	}
}
