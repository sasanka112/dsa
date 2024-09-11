package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExcelOperation {

	public static JSONObject getExcelDataAsJsonObject(String excelFilePath) {

		JSONObject sheetsJsonObject = new JSONObject();
		Workbook workbook = null;

		try {
//			String excelFilePath = "D://Selenium Training//ExcelSearch//Configurations.xlsx";

			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

			workbook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			System.out.println(
					"ExcelUtils -> getExcelDataAsJsonObject() :: Exception thrown constructing XSSFWorkbook from provided excel file.  InvalidFormatException | IOException => ");
		}

		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {

			JSONArray sheetArray = new JSONArray();
			ArrayList<String> columnNames = new ArrayList<String>();
			Sheet sheet = workbook.getSheetAt(i);
			Iterator<Row> sheetIterator = sheet.iterator();

			while (sheetIterator.hasNext()) {

				Row currentRow = sheetIterator.next();
				JSONObject jsonObject = new JSONObject();

				if (currentRow.getRowNum() != 0) {

					for (int j = 0; j < columnNames.size(); j++) {

						if (currentRow.getCell(j) != null) {
							if (currentRow.getCell(j).getCellType() == Cell.CELL_TYPE_STRING) {
								jsonObject.put(columnNames.get(j), currentRow.getCell(j).getStringCellValue());
							} else if (currentRow.getCell(j).getCellType() == Cell.CELL_TYPE_NUMERIC) {
								jsonObject.put(columnNames.get(j), currentRow.getCell(j).getNumericCellValue());
							} else if (currentRow.getCell(j).getCellType() == Cell.CELL_TYPE_BOOLEAN) {
								jsonObject.put(columnNames.get(j), currentRow.getCell(j).getBooleanCellValue());
							} else if (currentRow.getCell(j).getCellType() == Cell.CELL_TYPE_BLANK) {
								jsonObject.put(columnNames.get(j), "");
							}
						} else {
							jsonObject.put(columnNames.get(j), "");
						}

					}

					sheetArray.put(jsonObject);

				} else {
					// store column names
					for (int k = 0; k < currentRow.getPhysicalNumberOfCells(); k++) {
						columnNames.add(currentRow.getCell(k).getStringCellValue());
					}
				}

			}

			sheetsJsonObject.put(workbook.getSheetName(i), sheetArray);

		}

		return sheetsJsonObject;

	}

}
