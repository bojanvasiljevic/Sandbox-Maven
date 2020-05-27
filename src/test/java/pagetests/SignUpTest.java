package pagetests;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjects.HomePO;
import pageobjects.SignUpPO;
import utility.MapData;
import utility.UserData;

public class SignUpTest {

	public static WebDriver driver;
	public static HashMap<String, String> dataMap;

	@BeforeClass
	public static void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"G:\\Bojan Java\\maven-itbootcamp\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		dataMap = MapData.setDataMap();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void signUpOneUserManually() throws IOException {

		SignUpPO.signUpUser(driver, "testic7654", "testic7654@gmail.com", "Testic7654", "Testic7654");

		String expected = "https://sandbox.2checkout.com/sandbox/home/dashboard";
		Assert.assertEquals(driver.getCurrentUrl(), expected);
	}

	/**
	 * Test to check sign up process for multy users, by taking data form xls file.
	 * 
	 * @throws IOException
	 */
	@Test
	public void signUpMultyUser() throws IOException {

		SoftAssert signUp = new SoftAssert();
		String expected = "https://sandbox.2checkout.com/sandbox/home/dashboard";

		for (int i = 2; i < UserData.getNumberOfRows(); i++) {
			SignUpPO.navigateToSignUp(driver);
			SignUpPO.clearEmailField(driver);

			SignUpPO.signUpUser(driver, UserData.getUsername(i), UserData.getEmail(i), UserData.getPassword(i),
					UserData.getConfirmPassword(i));

			signUp.assertEquals(driver.getCurrentUrl(), expected);

			HomePO.clickUserAvatar(driver);
			HomePO.clickLogOut(driver);

		}
		signUp.assertAll();

	}

	@Test
	public void signUpWithoutUsername() throws IOException {

		SignUpPO.signUpUser(driver, "", "testic7654@gmail.com", "Testic7654", "Testic7654");

		WebElement findErrorMessage = driver.findElement(By.xpath("//div[@id='username_message']//p"));
		String errorMessage = findErrorMessage.getText();
		Assert.assertEquals(errorMessage, "You must enter a valid username");
	}

	@Test
	public void signWithoutEmail() throws IOException {

		SignUpPO.signUpUser(driver, "testic7654", "", "Testic7654", "Testic7654");

		WebElement findErrorMessage = driver.findElement(By.xpath("//div[@id='email_message']//p"));
		String errorMessage = findErrorMessage.getText();
		Assert.assertEquals(errorMessage, "You must enter a valid email address.");

	}

	@Test
	public void signUPWithoutPassword() throws IOException {

		SignUpPO.signUpUser(driver, "testic7654", "testic7654@gmail.com", "", "Testic7654");

		WebElement findErrorMessage = driver.findElement(By.xpath("//div[@id='password_message']//p"));
		String errorMessage = findErrorMessage.getText();
		Assert.assertEquals(errorMessage, "Your password is required.");
	}

	@Test
	public void signWithoutConfirmPassword() throws IOException {

		SignUpPO.signUpUser(driver, "testic7654", "testic7654@gmail.com", "Testic7654", "");

		WebElement findErrorMessage = driver.findElement(By.xpath("//div[@id='confirm_message']//p"));
		String errorMessage = findErrorMessage.getText();
		Assert.assertEquals(errorMessage, "You must confirm your password.");

	}

	@Test
	public void signWithoutAboutYourself() throws IOException {

		SignUpPO.navigateToSignUp(driver);
		SignUpPO.setUsername(driver, "testic7654");
		SignUpPO.setEmail(driver, "testic7654@gmail.com");
		SignUpPO.setPassword(driver, "Testic7654");
		SignUpPO.setConfirmPassword(driver, "Testic7654");
		SignUpPO.clickSignUpButton(driver);

		WebElement findErrorMessage = driver.findElement(By.xpath("//div[@id='aboutyou_message']//p"));
		String errorMessage = findErrorMessage.getText();
		Assert.assertEquals(errorMessage, "Telling us about yourself is required.");

	}

	@AfterClass
	public static void end() {
		driver.close();
	}
}
