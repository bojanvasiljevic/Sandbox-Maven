package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;

import entities.ProductEntity;

public class ProductData {

	public static String DATA_FILE = "G:\\Bojan Java\\maven-itbootcamp\\src\\main\\resources\\ProducData.xls";

	public static final int NAME = 0;
	public static final int PRODUCT_ID = 1;
	public static final int SHORT_DESCRIPTION = 2;
	public static final int LONG_DESCRIPTION = 3;
	public static final int PRICE = 4;
	public static final int TANGIBLE = 5;
	public static final int RECURRING = 6;
	public static final int APPROVED_URL = 7;
	public static final int TANGIBLE_WEIGHT = 8;
	public static final int TANGIBLE_HANDLING = 9;
	public static final int SETUP_FEE = 10;
	public static final int BILL_AMMOUNT = 11;
	public static final int BILL_INTERVAL = 12;
	public static final int CONTINUE_BILLING_AMMOUNT = 13;
	public static final int CONTINUE_BILLING_TERM = 14;

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
	 * Loads one ProductEntity, which represents one row in xls file.
	 * 
	 * @param index
	 * @return ProductEntity
	 */
	public static ProductEntity getEntity(int index) {
		ProductEntity entity = new ProductEntity();
		try (FileInputStream userData = new FileInputStream(DATA_FILE); HSSFWorkbook wb = new HSSFWorkbook(userData)) {
			HSSFSheet sheet = wb.getSheetAt(0);
			Row product = sheet.getRow(index);
			entity.setName(product.getCell(NAME).toString());
			entity.setID(product.getCell(PRODUCT_ID).toString());
			entity.setShortDescription(product.getCell(SHORT_DESCRIPTION).toString());
			entity.setLongDescription(product.getCell(LONG_DESCRIPTION).toString());
			entity.setPrice(product.getCell(PRICE).toString());
			entity.setTangible(product.getCell(TANGIBLE).toString());
			if (product.getCell(TANGIBLE).toString().toLowerCase().contentEquals("yes")) {
				entity.setTangibleWeight(product.getCell(TANGIBLE_WEIGHT).toString());
				entity.setTangibleHandling(product.getCell(TANGIBLE_HANDLING).toString());
			}
			entity.setRecurring(product.getCell(RECURRING).toString());
			if (product.getCell(RECURRING).toString().toLowerCase().contentEquals("yes")) {
				entity.setStartupFee(product.getCell(SETUP_FEE).toString());
				entity.setBillingIntervalAmmount(product.getCell(BILL_AMMOUNT).toString());
				entity.setBillingInterval(product.getCell(BILL_INTERVAL).toString());
				entity.setContinueBillingAmmount(product.getCell(CONTINUE_BILLING_AMMOUNT).toString());
				entity.setContinueBillingInterval(product.getCell(CONTINUE_BILLING_TERM).toString());
			}

			entity.setApprovedURL(product.getCell(APPROVED_URL).toString());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}

}
