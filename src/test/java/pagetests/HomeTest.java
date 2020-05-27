package pagetests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjects.HomePO;
import pageobjects.LogInPO;
import utility.MapData;
import utility.ProductData;
import utility.UserData;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.DataValidationEvaluator.ValidationEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class HomeTest {
	public static WebDriver driver;
	public static HashMap<String, String> dataMap;

	@BeforeClass
	public static void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"G:\\Bojan Java\\maven-itbootcamp\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		dataMap = MapData.setDataMap();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	/**
	 * Adding multy products, by reading data form xls file and testig if process
	 * was successful
	 * 
	 * @throws IOException
	 */
	@Test
	public void addingProduct() throws IOException {

		SoftAssert sa = new SoftAssert();
		LogInPO.logIn(driver, "testiranje12345", "Test1234");

		for (int i = 1; i < 6; i++) {

			HomePO.addNewProduct(driver, ProductData.getEntity(i));
			sa.assertTrue(HomePO.validationCheck(driver));
		}
		sa.assertAll();
	}

	@AfterClass
	public void end() {
		driver.close();
	}

}
