package com.chf.example.apache.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Excel {
	public static void main(String[] args) {

		File excel = new File(ClassLoader.getSystemResource("poi/test.xls")
				.getFile());
		HSSFWorkbook wb = null;
		try (InputStream is = new FileInputStream(excel)) {
			wb = new HSSFWorkbook(is);
			HSSFSheet sheet = wb.getSheetAt(0);

			for (Row row : sheet) {
				for (Cell cell : row) {
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						System.out.println(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.println(cell.getNumericCellValue());
						break;
					default:
					}

				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {

			try {
				if (wb != null) {
					wb.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
