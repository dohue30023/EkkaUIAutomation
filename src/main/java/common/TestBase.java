package common;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	public WebDriver webDriver;

	public void openWeb(String browser, String url) {

		if (browser.equalsIgnoreCase("chrome")) {
			// Selenium Manager (built into Selenium 4.6+) auto-downloads the matching ChromeDriver
			webDriver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
		}

		// open website => hiển thị homepage

		webDriver.get(url);
		webDriver.manage().window().maximize();
	}

	public boolean isDisplayed(By locator, int timeToSecond) {
		boolean result = false;
		int waitSeconds = timeToSecond > 0 ? timeToSecond : 5;
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(waitSeconds));
		WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		if (webElement.isDisplayed()) {
			result = true;
		}
		return result;
	}

	public void inputText(By locator, CharSequence... keysToSend) {
		if (isDisplayed(locator, 0)) {
			webDriver.findElement(locator).sendKeys(keysToSend);
		}
	}
	
	public void clickOnElement(By locator) {
		if (isDisplayed(locator, 0)) {
			webDriver.findElement(locator).click();
		}
	}
	
	public void selectDropDownByVisibleText(By locator, String text) {
		WebElement dropDownElement = webDriver.findElement(locator);
		if(isDisplayed(locator, 0)) {
			Select selectElement = new Select(dropDownElement);
			selectElement.selectByVisibleText(text);
		}
	}
	
	public String getAlertMessage() {
		String result = "";
		Alert alert = webDriver.switchTo().alert();
		result = alert.getText();
		return result;
		

	}

}
