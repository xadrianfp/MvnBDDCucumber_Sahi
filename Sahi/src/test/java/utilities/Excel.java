package utilities;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;



/*
 * 22/Agosto/2018
 * Creado por: Adri�n Felipe Puerta
 * Esta clase a trav�s del m�todo get tiene la capacidad de recibir un archivo excel
 * Leerlo y retornar un arreglo con la informaci�n
 * El archivo excel que lee es del formato xls, para leer un archivo xlsx se deben importar
 * las librer�as poi.xssf y utilizar los objetos XSSFCell,XSSFRow, XSSFSheet, XSSFWorkbook
 * Las librer�as utilizadas son poi.hssf y utilizar los objetos HSSFCell,HSSFRow, HSSFSheet, HSSFWorkbook
 * 
 * El archivo se empieza a leer desde la segunda fila asumiendo que el datadriven tiene t�tulos para cada columna
 */

public class Excel {

	
	// Dependencies: POI | HSSF Workbook/Sheet/Row/Cell
	// This method will read and return Excel data into a double array
	public static String[][] get(String filename) {
		String[][] dataTable = null;
		File file = new File(filename);
		try {
			// Create a file input stream to read Excel workbook and worksheet
			FileInputStream xlfile = new FileInputStream(file);
			
			HSSFWorkbook xlwb = new HSSFWorkbook(xlfile);
			HSSFSheet xlSheet = xlwb.getSheetAt(0);

			// Get the number of rows and columns
			int numRows = xlSheet.getLastRowNum();
			int numCols = xlSheet.getRow(0).getLastCellNum();

			// Create double array data table - rows x cols
			// We will return this data table
			dataTable = new String[numRows][numCols];

			// For each row, create a HSSFRow, then iterate through the "columns"
			// For each "column" create an HSSFCell to grab the value at the specified cell (i,j)
			for (int i = 0; i < numRows; i++) {
				HSSFRow xlRow = xlSheet.getRow(i+1);
				for (int j = 0; j < numCols; j++) {
					HSSFCell xlCell = xlRow.getCell(j);
					dataTable[i][j] = xlCell.toString();
				}
				xlwb.close();
				xlfile.close();
			}
		} catch (IOException e) {
			System.out.println("ERROR FILE HANDLING " + e.toString());
		}
		
		return dataTable;
	}
}
