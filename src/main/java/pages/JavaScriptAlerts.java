package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptAlerts {

	private WebDriver driver;
	private By jsAlertButton = By.xpath("//div[@id='content']//ul//button[.='Click for JS Alert']");
	private By jsConfirmButton = By.xpath("//div[@id='content']//ul//button[.='Click for JS Confirm']");
	private By jsPromptButton = By.xpath("//div[@id='content']//ul//button[.='Click for JS Prompt']");
	private By resultText = By.xpath("/html//p[@id='result']");

	public JavaScriptAlerts(WebDriver driver) {
		this.driver = driver;
	}

	public boolean clickJSAlert() {
		driver.findElement(jsAlertButton).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return driver.findElement(resultText).getText().contains("You successfully clicked an alert");
	}

	public boolean clickJSConfirmOk() {
		driver.findElement(jsConfirmButton).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return driver.findElement(resultText).getText().contains("You clicked: Ok");
	}

	public boolean clickJSConfirmCancel() {
		driver.findElement(jsConfirmButton).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		return driver.findElement(resultText).getText().contains("You clicked: Cancel");
	}

	public boolean clickJSPromptButton() {
		driver.findElement(jsPromptButton).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Test string");
		alert.accept();
		return driver.findElement(resultText).getText().contains("You entered: Test string");
	}
}
