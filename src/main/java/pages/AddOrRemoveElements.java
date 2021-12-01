package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddOrRemoveElements {

	private WebDriver driver;
	private By addElement = By.xpath("//div[@id='content']//button[.='Add Element']");

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
}