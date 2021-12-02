package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxes {
	private WebDriver driver;
	private By checkBox1 = By.xpath("//form[@id='checkboxes']/input[1]");
	private By checkBox2 = By.xpath("//form[@id='checkboxes']/input[2]");

	public CheckBoxes(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkBox2IsDisabled() {
		driver.findElement(checkBox2).click();
		return !driver.findElement(checkBox2).isSelected();
	}

	public boolean checkBox2IsEnabled() {
		driver.findElement(checkBox2).click();
		return driver.findElement(checkBox2).isSelected();
	}

	public boolean checkBox1IsEnabled() {
		driver.findElement(checkBox1).click();
		return driver.findElement(checkBox1).isSelected();
	}

	public boolean checkBox1IsDiabled() {
		driver.findElement(checkBox1).click();
		return !driver.findElement(checkBox1).isSelected();
	}

	public boolean enableBoth() {
		driver.findElement(checkBox1).click();
		driver.findElement(checkBox2).click();
		return (driver.findElement(checkBox1).isSelected() && driver.findElement(checkBox2).isSelected());
	}

	public boolean disableBoth() {
		driver.findElement(checkBox1).click();
		driver.findElement(checkBox2).click();
		return !(driver.findElement(checkBox1).isSelected() && driver.findElement(checkBox2).isSelected());
	}
}
