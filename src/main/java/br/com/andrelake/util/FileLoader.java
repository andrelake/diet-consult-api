package br.com.andrelake.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import br.com.andrelake.domain.model.Food;

@Component
public class FileLoader {

	public static List<Food> excelLoader() {
		
		List<Food> foods = new ArrayList<>();
		
		try {
			String filePath = "E:\\Programação\\SpringToolsSuite4\\WorkspaceSpring\\diet-consult-api\\src\\main\\resources\\taco_exemplo.xlsx";
			FileInputStream file;

			file = new FileInputStream(new File(filePath));

			Workbook wb = new XSSFWorkbook(file);
			Sheet sheet = wb.getSheet("Sheet1");

			Iterator<Row> rows = sheet.iterator();

			int rowNumber = 0;
			while (rows.hasNext()) {

				Row currentRow = rows.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				Food food = new Food();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {
					case 0:
						food.setId((long) currentCell.getNumericCellValue());
						break;

					case 1:
						food.setNome(currentCell.getStringCellValue());
						break;

					case 2:
						food.setCalorias((int) currentCell.getNumericCellValue());
						break;

					case 3:
						food.setProteina(currentCell.getNumericCellValue());
						break;

					case 4:
						currentCell.setCellType(CellType.NUMERIC);
						food.setGordura(currentCell.getNumericCellValue());
						break;

					case 5:
						food.setCarbo(currentCell.getNumericCellValue());
						break;

					case 6:
						food.setFibra(currentCell.getNumericCellValue());
						break;

					default:
						break;
					}

					cellIdx++;
				}

				foods.add(food);
			}
			
			wb.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return foods;
	}
}
