package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicAuth {
	private WebDriver driver;
	private By successText = By.xpath("//div[@id='content']//p");

	public BasicAuth(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkSuccessText() {
		return driver.findElement(successText).getText()
				.contains("Congratulations! You must have the proper credentials.");
	}

}
