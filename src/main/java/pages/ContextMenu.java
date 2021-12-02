package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContextMenu {

	private WebDriver driver;
	private By contextMenuBy = By.xpath("/html//div[@id='hot-spot']");

	public ContextMenu(WebDriver driver) {
		this.driver = driver;
	}

	public boolean rightClickContextMenu() {
		Actions actions = new Actions(driver);
		WebElement contextMenuElement = driver.findElement(contextMenuBy);
		actions.contextClick(contextMenuElement).perform();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			return alert.getText().contains("You selected a context menu");
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return false;
	}
}
