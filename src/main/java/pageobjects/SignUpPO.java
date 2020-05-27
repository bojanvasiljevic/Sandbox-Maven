package pageobjects;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.MapData;

public class SignUpPO {

	public static void navigateToSignUp(WebDriver driver) throws IOException {
		driver.get(MapData.getKeyValue("sign_up_url"));
		driver.manage().window().maximize();
	}

	public static WebElement getUsername(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("sign_up_username")));
	}

	public static WebElement getPassword(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("sign_up_password")));
	}

	public static WebElement getConfirmPassword(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("sign_up_confirm_password")));
	}

	public static WebElement getEmail(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("sign_up_email")));
	}

	public static WebElement getAboutYourself(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("SIGN_UP_SELECT_OPTION")));
	}

	public static void setUsername(WebDriver driver, String username) throws IOException {
		getUsername(driver).sendKeys(username);
	}

	public static void setPassword(WebDriver driver, String password) throws IOException {
		getPassword(driver).sendKeys(password);
	}

	public static void setConfirmPassword(WebDriver driver, String confirmPassword) throws IOException {
		getConfirmPassword(driver).sendKeys(confirmPassword);
	}

	public static void setEmail(WebDriver driver, String email) throws IOException {
		getEmail(driver).sendKeys(email);
	}

	public static void setAboutYourSelf(WebDriver driver) throws IOException {
		getAboutYourself(driver).click();
	}

	public static WebElement getSignUpButton(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("sign_up_button")));
	}

	public static void clickSignUpButton(WebDriver driver) throws IOException {
		getSignUpButton(driver).click();
	}

	public static void clearEmailField(WebDriver driver) throws IOException {
		getEmail(driver).clear();

	}

	/**
	 * Signs up user by filling mandatory fields
	 * 
	 * @param driver
	 * @param username
	 * @param email
	 * @param password
	 * @param confirmPassword
	 * @throws IOException
	 */
	public static void signUpUser(WebDriver driver, String username, String email, String password,
			String confirmPassword) throws IOException {

		setUsername(driver, username);
		sacekaj();
		setEmail(driver, email);
		sacekaj();
		setPassword(driver, password);
		sacekaj();
		setConfirmPassword(driver, confirmPassword);
		sacekaj();
		setAboutYourSelf(driver);
		sacekaj();
		clickSignUpButton(driver);
	}

	public static void sacekaj() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
