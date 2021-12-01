package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;
	private By formAuthenticationLink = By.linkText("Form Authentication");
	private By dynamicLoadingLink = By.xpath("//div[@id='content']/ul//a[@href='/dynamic_loading']");
	private By dynamicLoading1Link = By.xpath("//div[@id='content']//a[@href='/dynamic_loading/1']");
	private By dynamicLoading2Link = By.xpath("//div[@id='content']//a[@href='/dynamic_loading/2']");
	private By dynamicControlsLink = By.xpath("//div[@id='content']/ul//a[@href='/dynamic_controls']");
	private By addOrRemoveLink = By.xpath("//div[@id='content']/ul//a[@href='/add_remove_elements/']");
	private By checkBoxesLink = By.xpath("//div[@id='content']/ul//a[@href='/checkboxes']");
	private By dropDownListLink = By.xpath("//div[@id='content']/ul//a[@href='/dropdown']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage clickFormAuthentication() {
		driver.findElement(formAuthenticationLink).click();
		return new LoginPage(driver);
	}

	public DynamicLoading1 clickDynamicLoading1() {
		driver.findElement(dynamicLoadingLink).click();
		driver.findElement(dynamicLoading1Link).click();
		return new DynamicLoading1(driver);
	}

	public DynamicLoading2 clickDynamicLoading2() {
		driver.findElement(dynamicLoadingLink).click();
		driver.findElement(dynamicLoading2Link).click();
		return new DynamicLoading2(driver);
	}

	public DynamicControls clickDynamicControls() {
		driver.findElement(dynamicControlsLink).click();
		return new DynamicControls(driver);
	}

	public AddOrRemoveElements clickAddOrRemoveElements() {
		driver.findElement(addOrRemoveLink).click();
		return new AddOrRemoveElements(driver);
	}

	public CheckBoxes clickCheckBoxes() {
		driver.findElement(checkBoxesLink).click();
		return new CheckBoxes(driver);
	}

	public DropDownList clickDropDownList() {
		driver.findElement(dropDownListLink).click();
		return new DropDownList(driver);
	}
}
