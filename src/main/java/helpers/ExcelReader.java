package helpers;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * @author Prabhat
 * Description: This is Excel Reader class to handle different operation on Excel workbook/sheet
 * Created Date: 03/06/2021
 */
/**
 * @author prakumar62
 *
 */
/**
 * @author prakumar62
 *
 */
/**
 * @author prakumar62
 *
 */
/**
 * @author prakumar62
 *
 */
/**
 * @author prakumar62
 *
 */
/**
 * @author prakumar62
 *
 */
/**
 * @author prakumar62
 *
 */
public class ExcelReader {
	
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	public ExcelReader(String path) {

		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Prabhat
	 * @param sheetName
	 * @param colNum
	 * @param rowNum
	 * @return int> total rows number present in that sheet'
	 */

	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}

	}
	
	
	/**
	 * @author Prabhat
	 * @param sheetName
	 * @return false or true if sheet exixts
	 */

		public boolean isSheetExist(String sheetName) {
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1) {
				index = workbook.getSheetIndex(sheetName.toUpperCase());
				if (index == -1)
					return false;
				else
					return true;
			} else
				return true;
		}

}
