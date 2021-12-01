package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoading1 {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private By startButton=By.xpath("//div[@id='start']/button[.='Start']");
	private By finishElement=By.xpath("//div[@id='finish']/h4[.='Hello World!']");
	
	
	public DynamicLoading1 (WebDriver driver){
        this.driver = driver;
    }
	
	public void startButtonClick()
	{
		//Click the Start Button
		driver.findElement(startButton).click();
	}
	
	public String waitForMessage() throws TimeoutException 
	{
		this.wait=new WebDriverWait(driver, 10);
		//finishElement is present but is invisible
		//Wait until finishElement changes visibility (10 seconds)
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(finishElement)));
		return driver.findElement(finishElement).getText();
		
	}
	
	public String waitForMessageTimeout() throws TimeoutException 
	{
		this.wait=new WebDriverWait(driver, 2);
		//Wait until finishElement changes visibility
		//Wait is 2 seconds so it should return timeOut Expection
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(finishElement)));
		return driver.findElement(finishElement).getText();
		
	}
	
}
