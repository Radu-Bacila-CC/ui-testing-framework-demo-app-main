package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownList {

	WebDriver driver;
	private By dropDownListBy = By.id("dropdown");

	public DropDownList(WebDriver driver) {
		this.driver = driver;
	}

	public boolean selectOption1() {
		Select dropDown = new Select(driver.findElement(dropDownListBy));
		dropDown.selectByValue("1");
		return dropDown.getFirstSelectedOption().getText().contains("Option 1");
	}

	public boolean selectOption2() {
		Select dropDown = new Select(driver.findElement(dropDownListBy));
		dropDown.selectByValue("2");
		return dropDown.getFirstSelectedOption().getText().contains("Option 2");
	}

}
