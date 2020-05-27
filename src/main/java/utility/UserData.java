package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class UserData {

	public static String DATA_FILE = "G:\\Bojan Java\\maven-itbootcamp\\src\\main\\resources\\userData.xls";

	public static final int USERNAME = 0;
	public static final int EMAIL = 1;
	public static final int PASSWORD = 2;
	public static final int CONFIRM_PASSWORD = 3;

	/**
	 * Returns int value for number of rows in data xls file
	 * 
	 * @return int
	 */
	public static int getNumberOfRows() {
		try (FileInputStream userData = new FileInputStream(DATA_FILE); HSSFWorkbook wb = new HSSFWorkbook(userData)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			return sheet.getLastRowNum() + 1;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Reads xls file and returns Username value.
	 * 
	 * @param index row number
	 * @return String
	 */
	public static String getUsername(int index) {

		try (FileInputStream userData = new FileInputStream(DATA_FILE); HSSFWorkbook wb = new HSSFWorkbook(userData)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			Row user = sheet.getRow(index);
			Cell UserField = user.getCell(USERNAME);
			return UserField.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Returns Email value form xls file
	 * 
	 * @param index
	 * @return String
	 */
	public static String getEmail(int index) {

		try (FileInputStream userData = new FileInputStream(DATA_FILE); HSSFWorkbook wb = new HSSFWorkbook(userData)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			Row user = sheet.getRow(index);
			Cell UserField = user.getCell(EMAIL);
			return UserField.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reads xls file and returns Email value.
	 * 
	 * @param index
	 * @return String
	 */
	public static String getPassword(int index) {

		try (FileInputStream userData = new FileInputStream(DATA_FILE); HSSFWorkbook wb = new HSSFWorkbook(userData)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			Row user = sheet.getRow(index);
			Cell UserField = user.getCell(PASSWORD);
			return UserField.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reads xls file and returns ConfirmPassword value.
	 * 
	 * @param index
	 * @return String
	 */
	public static String getConfirmPassword(int index) {

		try (FileInputStream userData = new FileInputStream(DATA_FILE); HSSFWorkbook wb = new HSSFWorkbook(userData)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			Row user = sheet.getRow(index);
			Cell UserField = user.getCell(CONFIRM_PASSWORD);
			return UserField.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
