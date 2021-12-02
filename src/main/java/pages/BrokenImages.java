package pages;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenImages {
	private WebDriver driver;
	private By images = By.tagName("img");

	public BrokenImages(WebDriver driver) {
		this.driver = driver;
	}

	public boolean checkImages() {
		int brokenImagesCounter = 0;
		List<WebElement> imageList = driver.findElements(images);
		try {
			for (WebElement image : imageList) {
				if (image != null) {
					HttpClient client = HttpClientBuilder.create().build();
					HttpGet request = new HttpGet(image.getAttribute("src"));
					HttpResponse response = client.execute(request);
					if (response.getStatusLine().getStatusCode() != 200)
						brokenImagesCounter++;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return brokenImagesCounter == 2;
	}

	public boolean checkImagesSimple() {
		int brokenImagesCounter = 0;
		List<WebElement> imageList = driver.findElements(images);
		for (WebElement image : imageList) {
			if (image != null && Integer.parseInt(image.getAttribute("naturalWidth")) == 0)
				brokenImagesCounter++;
		}
		return brokenImagesCounter == 2;
	}
}
