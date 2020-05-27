package pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.MapData;

public class LogInPO {

	/**
	 * Navigates to Home URL
	 * 
	 * @param driver
	 * @throws IOException
	 */
	public static void navigateToLogInPage(WebDriver driver) throws IOException {
		driver.manage().window().maximize();
		driver.get(MapData.getKeyValue("home_url"));
	}

	public static WebElement getUsername(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("LOG_IN_USERNAME")));
	}

	public static WebElement getPassword(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("LOG_IN_password")));
	}

	public static WebElement getLogInButton(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(MapData.getKeyValue("LOG_IN_button")));
	}

	public static void setUserName(WebDriver driver, String username) throws IOException {
		getUsername(driver).sendKeys(username);
	}

	public static void setPassword(WebDriver driver, String password) throws IOException {
		getPassword(driver).sendKeys(password);
	}

	public static void clickLogInButton(WebDriver driver) throws IOException {
		getLogInButton(driver).click();
	}

	/**
	 * Log in to website with username and password and automatically clicks on sign
	 * in button.
	 * 
	 * @param driver
	 * @param username
	 * @param password
	 * @throws IOException
	 */
	public static void logIn(WebDriver driver, String username, String password) throws IOException {
		navigateToLogInPage(driver);
		setUserName(driver, username);
		setPassword(driver, password);
		clickLogInButton(driver);

	}

}
