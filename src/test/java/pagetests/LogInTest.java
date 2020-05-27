package pagetests;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjects.HomePO;
import pageobjects.LogInPO;
import utility.MapData;
import utility.UserData;

public class LogInTest {
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

	@Test
	public void logInWithoutUserBeingCreated() throws IOException {
		LogInPO.logIn(driver, "testiranje12346", "Test1234");
		String expected = "https://sandbox.2checkout.com/sandbox/login";
		Assert.assertEquals(driver.getCurrentUrl(), expected);
	}

	@Test
	public void logInMultyUser() throws IOException {
		String expected = "https://sandbox.2checkout.com/sandbox/home/dashboard";
		SoftAssert logIn = new SoftAssert();
		for (int i = 2; i < 15; i++) {
			LogInPO.logIn(driver, UserData.getUsername(i), UserData.getPassword(i));
			logIn.assertEquals(driver.getCurrentUrl(), expected);
			HomePO.clickUserAvatar(driver);
			HomePO.clickLogOut(driver);
		}
		logIn.assertAll();
	}

	@AfterClass
	public static void end() {
		driver.close();
	}
}
