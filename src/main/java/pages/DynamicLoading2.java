package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoading2 {
	private WebDriver driver;
	private By startButton=By.xpath("//div[@id='start']/button[.='Start']");
	private By finish=By.id("finish");
	private WebDriverWait wait;
	
	public DynamicLoading2 (WebDriver driver){
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
		///finishElement does not exist and it is created after Start Button is clicked
		//Wait until finishElement is created and check it's visibility and text
		WebElement finishElement = wait.until(ExpectedConditions.presenceOfElementLocated(finish));
		return finishElement.getText();
		
	}
	
}
