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
	private By brokenImagesLink = By.xpath("//div[@id='content']/ul//a[@href='/broken_images']");
	private By contextMenuLink = By.xpath("//div[@id='content']/ul//a[@href='/context_menu']");
	private By javaScriptAlertsLink = By.xpath("//div[@id='content']/ul//a[@href='/javascript_alerts']");

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

	public BrokenImages clickBrokenImages() {
		driver.findElement(brokenImagesLink).click();
		return new BrokenImages(driver);
	}

	public BasicAuth clickBasicAuth() {
		driver.navigate().to("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		return new BasicAuth(driver);
	}

	public ContextMenu clickContextMenu() {
		driver.findElement(contextMenuLink).click();
		return new ContextMenu(driver);
	}

	public JavaScriptAlerts clickJavaScriptAlerts() {
		driver.findElement(javaScriptAlertsLink).click();
		return new JavaScriptAlerts(driver);
	}
}
