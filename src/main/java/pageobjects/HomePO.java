package pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import entities.ProductEntity;
import utility.MapData;

public class HomePO {

	public static WebElement getUserAvatar(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("home_user_avatar")));
	}

	public static WebElement getLogOutButton(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("home_log_out")));
	}

	public static void clickUserAvatar(WebDriver driver) throws IOException {
		getUserAvatar(driver).click();
	}

	public static void clickLogOut(WebDriver driver) throws IOException {
		getLogOutButton(driver).click();
	}

	public static WebElement getProducts(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("home_products")));
	}

	public static WebElement getAddNewProduct(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("add_new_product")));
	}

	public static WebElement getProductName(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("product_name")));
	}

	public static WebElement getProductId(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("product_id")));
	}

	public static WebElement getShortDescription(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("short_description")));
	}

	public static WebElement getLongDescription(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("long_description")));
	}

	public static WebElement getPrice(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("price")));
	}

	public static WebElement getTangibleYes(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("tangible_yes")));
	}

	public static WebElement getTangibleNo(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("tangible_no")));
	}

	public static WebElement getTangibleWeight(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("tangible_weight")));
	}

	public static WebElement getTangibleHandling(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("tangible_handling")));
	}

	public static WebElement getRecurringSetupFee(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("recurring_setup_fee")));
	}

	public static WebElement getRecurringBillEveryWeek(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("RECURRING_WEEK")));
	}

	public static WebElement getRecurringBillEveryMonth(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("RECURRING_MONTH")));
	}

	public static WebElement getRecurringBillEveryYear(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("RECURRING_YEAR")));
	}

	public static WebElement getRecurringBill(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("recurring_bill")));
	}

	public static WebElement getRecurringContinueBilling(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("RECURRING_CUNTINUE_BILLING")));
	}

	public static WebElement getRecurringContinueBillingWeek(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("RECURRING_BILLING_WEEK")));
	}

	public static WebElement getRecurringContinueBillingMonth(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("RECURRING_BILLING_month")));
	}

	public static WebElement getRecurringContinueBillingYear(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("RECURRING_BILLING_year")));
	}

	public static WebElement getRecurringContinueBillingForever(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("RECURRING_BILLING_forever")));
	}

	public static WebElement getRecurringYes(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("recurring_yes")));
	}

	public static WebElement getRecurringNo(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("recurring_no")));
	}

	public static WebElement getApprovedUrl(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("approved_url")));
	}

	public static WebElement getSubmitButton(WebDriver driver) throws IOException {
		return driver.findElement(By.name(MapData.getKeyValue("submit")));
	}

	public static WebElement getValidation(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("VALIDATION")));
	}

	public static void clickProductsButton(WebDriver driver) throws IOException {
		getProducts(driver).click();
	}

	public static void clickAddNewProduct(WebDriver driver) throws IOException {
		getAddNewProduct(driver).click();
	}

	public static void setProductName(WebDriver driver, ProductEntity entity) throws IOException {
		getProductName(driver).sendKeys(entity.getName());
	}

	public static void setProductId(WebDriver driver, ProductEntity entity) throws IOException {
		getProductId(driver).sendKeys(entity.getID());
	}

	public static void setShortDescription(WebDriver driver, ProductEntity entity) throws IOException {
		getShortDescription(driver).sendKeys(entity.getShortDescription());
	}

	public static void setLongDescription(WebDriver driver, ProductEntity entity) throws IOException {
		getLongDescription(driver).sendKeys(entity.getLongDescription());
	}

	public static void setPrice(WebDriver driver, ProductEntity entity) throws IOException {
		getPrice(driver).sendKeys(entity.getPrice());
	}

	public static void setTangible(WebDriver driver, ProductEntity entity) throws IOException {
		if (entity.getTangible().toUpperCase().equals("YES")) {
			getTangibleYes(driver).click();
			getTangibleWeight(driver).sendKeys(entity.getTangibleWeight());
			getTangibleHandling(driver).sendKeys(entity.getTangibleHandling());

		} else {
			getTangibleNo(driver).click();
		}
	}

	public static void setRecurring(WebDriver driver, ProductEntity entity) throws IOException {
		if (entity.getRecurring().toUpperCase().equals("YES")) {
			getRecurringYes(driver).click();
			getRecurringSetupFee(driver).sendKeys(entity.getStartupFee());
			getRecurringBill(driver).sendKeys(entity.getBillingIntervalAmmount().replace('.', '\0'));
			if (entity.getBillingInterval().toLowerCase().contentEquals("week")) {
				getRecurringBillEveryWeek(driver).click();
			}
			if (entity.getBillingInterval().toLowerCase().contentEquals("month")) {
				getRecurringBillEveryMonth(driver).click();
			}
			if (entity.getBillingInterval().toLowerCase().contentEquals("year")) {
				getRecurringBillEveryYear(driver).click();
			}
			getRecurringContinueBilling(driver).sendKeys(entity.getContinueBillingAmmount().replace('.', '\0'));

			if (entity.getContinueBillingInterval().toLowerCase().contentEquals("week")) {
				getRecurringContinueBillingWeek(driver).click();
			}
			if (entity.getContinueBillingInterval().toLowerCase().contentEquals("month")) {
				getRecurringContinueBillingMonth(driver).click();
			}
			if (entity.getContinueBillingInterval().toLowerCase().contentEquals("Year")) {
				getRecurringContinueBillingYear(driver).click();
			}
			if (entity.getContinueBillingInterval().toLowerCase().contentEquals("forever")) {
				getRecurringContinueBillingForever(driver).click();
			}

		} else {
			getRecurringNo(driver).click();
		}

	}

	public static void setApprovedURL(WebDriver driver, ProductEntity entity) throws IOException {
		getApprovedUrl(driver).sendKeys(entity.getApprovedURL());
	}

	public static void clickSubmit(WebDriver driver) throws IOException {
		getSubmitButton(driver).click();
	}

	/**
	 * Returns true if adding a new product was successful or false if it wasn't.
	 * 
	 * @param driver
	 * @return boolean
	 * @throws IOException
	 */
	public static boolean validationCheck(WebDriver driver) throws IOException {
		try {
			getValidation(driver).getText();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Adds new product by reading necessary data form xls file.
	 * 
	 * @param driver
	 * @param entity
	 * @throws IOException
	 */
	public static void addNewProduct(WebDriver driver, ProductEntity entity) throws IOException {
		clickProductsButton(driver);
		clickAddNewProduct(driver);
		setProductName(driver, entity);
		setProductId(driver, entity);
		setShortDescription(driver, entity);
		setLongDescription(driver, entity);
		setPrice(driver, entity);
		setTangible(driver, entity);
		setRecurring(driver, entity);
		setApprovedURL(driver, entity);
		clickSubmit(driver);

	}

}
