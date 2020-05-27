package pagetests;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjects.HomePO;
import pageobjects.LogInPO;
import pageobjects.ProductPO;
import utility.MapData;

public class ProductTest {

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

	@BeforeMethod
	public static void logIn() throws IOException {
		LogInPO.logIn(driver, "testiranje12345", "Test1234");
		HomePO.clickProductsButton(driver);
		ProductPO.clickEdit(driver);
	}

	/**
	 * Increase prices of alredy created products, test.
	 * 
	 * @throws IOException
	 */
	@Test
	public void increasePriceTest() throws IOException {
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(ProductPO.increasePrice(ProductPO.getPrices(driver)));
		sa.assertTrue(ProductPO.editValidationCheck(driver));
		sa.assertAll();
	}

	@AfterClass
	public static void end() {
		driver.close();
	
	}
}
