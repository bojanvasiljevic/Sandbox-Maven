package pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.grpc.Context.Key;
import net.bytebuddy.asm.Advice.Enter;
import utility.MapData;

public class ProductPO {

	public static int increase = 100;

	public static WebElement getEditProduct(WebDriver driver) throws IOException {
		return driver.findElement(By.linkText(MapData.getKeyValue("edit_product")));
	}

	public static WebElement getEditValidation(WebDriver driver) throws IOException {
		return driver.findElement(By.className(MapData.getKeyValue("edit_validation")));
	}

	/**
	 * Returns a list of all product price elements.
	 * 
	 * @param driver
	 * @return List<WebElement>
	 * @throws IOException
	 */
	public static List<WebElement> getPrices(WebDriver driver) throws IOException {
		return driver.findElements(By.xpath(MapData.getKeyValue("edit_price")));
	}

	public static void clickEdit(WebDriver driver) throws IOException {
		getEditProduct(driver).click();
	}

	/**
	 * Receives List of WebElements that represents current product price path taken
	 * form Products page and increase it by 100, and modifies it. Returns true if
	 * modification was successful.
	 * 
	 * @param oldPrice
	 */
	public static boolean increasePrice(List<WebElement> oldPrices) {
		boolean check = false;
		for (int i = 0; i < oldPrices.size(); i++) {
			float increasePrice = Float.parseFloat(oldPrices.get(i).getAttribute("value")) + increase;
			oldPrices.get(i).clear();
			oldPrices.get(i).sendKeys(Float.toString(increasePrice));
			if (increasePrice == Float.parseFloat(oldPrices.get(i).getAttribute("value"))) {
				check = true;
			} else {
				return check = false;
			}
			if (i == oldPrices.size() - 1) {
				oldPrices.get(i).sendKeys(Keys.ENTER);
			}
		}
		return check;
	}

	/**
	 * Returns true if "All updates succeeded" message is displayed after submitting
	 * increase price prices
	 * 
	 * @param driver
	 * @return boolean
	 * @throws IOException
	 */
	public static boolean editValidationCheck(WebDriver driver) throws IOException {
		try {
			getEditValidation(driver).getText();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
