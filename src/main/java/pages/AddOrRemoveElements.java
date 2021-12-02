package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddOrRemoveElements {

	private WebDriver driver;
	private By addElement = By.xpath("//div[@id='content']//button[.='Add Element']");
	private By element = By.xpath("//div[@id='elements']/button");

	public AddOrRemoveElements(WebDriver driver) {
		this.driver = driver;
	}

	public boolean addElement(int poz) {
		driver.findElement(addElement).click();
		String xpathElem = "//div[@id='elements']/button[" + poz + "]";
		return driver.findElement(By.xpath(xpathElem)).isDisplayed();
	}

	public boolean removeElement(int poz) {
		String xpathElem = "//div[@id='elements']/button[" + poz + "]";
		driver.findElement(By.xpath(xpathElem)).click();
		try {
			return !driver.findElement(By.xpath(xpathElem)).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean removeElements() {
		List<WebElement> listOfElements = driver.findElements(element);
		for (WebElement elementOfList : listOfElements) {
			elementOfList.click();
		}
		try {
			return !driver.findElement(element).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}