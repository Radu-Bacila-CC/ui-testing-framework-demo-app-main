package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DynamicControls;
import pages.DynamicLoading1;
import pages.DynamicLoading2;

public class ExceptionsTests extends BaseTest {

	@Test(groups = "expectiontests", priority = 1)
	public void notVisibleTest() {
		DynamicLoading1 dynamicLoading1 = homePage.clickDynamicLoading1();
		dynamicLoading1.startButtonClick();
		assertTrue(dynamicLoading1.waitForMessage().contains("Hello World!"),
				"Finish text: " + dynamicLoading1.waitForMessage());
	}

	@Test(groups = "expectiontests", priority = 2)
	public void timeoutTest() {
		DynamicLoading1 dynamicLoading1 = homePage.clickDynamicLoading1();
		dynamicLoading1.startButtonClick();
		try {
			assertTrue(dynamicLoading1.waitForMessageTimeout().contains("Hello World!"),
					"Finish text: " + dynamicLoading1.waitForMessageTimeout());
		} catch (TimeoutException e) {
			System.out.println("Exception catched: " + e.getMessage());
		}
	}

	@Test(groups = "expectiontests", priority = 3)
	public void noSuchElementTest() {
		DynamicLoading2 dynamicLoading2 = homePage.clickDynamicLoading2();
		dynamicLoading2.startButtonClick();
		String receivedText = dynamicLoading2.waitForMessage();
		Assert.assertTrue(receivedText.contains("Hello World!"), "Finish text: " + receivedText);
	}

	@Test(groups = "exceptiontests", priority = 4)
	public void staleElementTest() {
		DynamicControls dynamicControls = homePage.clickDynamicControls();
		assertTrue(dynamicControls.removeButtonClick(), "Checkbox is still visible but should not be!");
		assertTrue(dynamicControls.addButtonClick(), "Checkbox is not visible but it should be!");
	}

	@Test(groups = "exceptiontests", priority = 5)
	public void enableAndDisableTest() {
		DynamicControls dynamicControls = homePage.clickDynamicControls();
		assertTrue(dynamicControls.enableButtonClick(), "Textbox is not enabled but it should be!");
		assertTrue(dynamicControls.disableButtonClick(), "Textbox is not disabled but it should be!");
	}

}
