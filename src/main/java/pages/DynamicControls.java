package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControls {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private By checkBox=By.id("checkbox");
	private By removeButton=By.xpath("//form[@id='checkbox-example']/button[@type='button']");
	private By addButton=By.xpath("//form[@id='checkbox-example']/button[@type='button']");
	private By enableButton=By.xpath("//form[@id='input-example']/button[@type='button']");
	private By disableButton=By.xpath("//form[@id='input-example']/button[@type='button']");
	private By textBox=By.xpath("//form[@id='input-example']/input[@type='text']");
	private By message=By.xpath("/html//p[@id='message']");
	
	public DynamicControls (WebDriver driver){
        this.driver = driver;
    }
	
	public boolean removeButtonClick()
	{
		this.wait=new WebDriverWait(driver, 10);
		//Click the button
		driver.findElement(removeButton).click();
		//Wait until checkBox disappears
		return wait.until(ExpectedConditions.stalenessOf(driver.findElement(checkBox)));
	}
	
	public boolean addButtonClick()
	{
		this.wait=new WebDriverWait(driver, 10);
		//CLick the button
		driver.findElement(addButton).click();
		//Wait until checkBox appears
		WebElement checkBoxElement=wait.until(ExpectedConditions.visibilityOfElementLocated(checkBox));
		//Return true if checkBox is displayed
		return checkBoxElement.isDisplayed();
	}
	
	public boolean enableButtonClick()
	{
		this.wait=new WebDriverWait(driver, 10);
		//Click the enable button
		driver.findElement(enableButton).click();
		//Wait until textBox is enabled
		//WebElement textBoxElement=wait.until(ExpectedConditions.elementToBeClickable(textBox));
		wait.until(ExpectedConditions.elementToBeClickable(textBox));
		//Send text to textBox
		//textBoxElement.sendKeys("Input Text");
		
		//Send textBoxElement enabled status (true if enabled)
		//return textBoxElement.isEnabled();*/
		
		//Or check if the message appears and says "It's enabled!"
		return driver.findElement(message).getText().contains("It's enabled!");
	}
	
	public boolean disableButtonClick()
	{
		this.wait=new WebDriverWait(driver, 10);
		//Click the disable button
		driver.findElement(disableButton).click();
		
		//Return that the textBox is not enabled
		//return wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(driver.findElement(textBox))));
		
		//Or wait until textBox is disabled
		wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(driver.findElement(textBox))));
		
		//And check if the message appears and says "It's disabled!"
		return driver.findElement(message).getText().contains("It's disabled!");
	}
	
}
