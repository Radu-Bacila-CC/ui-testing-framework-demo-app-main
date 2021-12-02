package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddOrRemoveElements;
import pages.BasicAuth;
import pages.BrokenImages;
import pages.CheckBoxes;
import pages.ContextMenu;
import pages.DropDownList;
import pages.JavaScriptAlerts;

public class Tests extends BaseTest {

	@Test(groups = "differenttests", priority = 1, enabled = false)
	public void addAndRemoveElementsTest() {
		AddOrRemoveElements addOrRemoveElements = homePage.clickAddOrRemoveElements();
		for (int i = 1; i <= 5; i++) {
			assertTrue(addOrRemoveElements.addElement(i), "Element was not added");
		}
		assertTrue(addOrRemoveElements.removeElements(), "All elemenents were deleted");
	}

	@Test(groups = "differenttests", priority = 2, enabled = false)
	public void checkBoxTest() {
		CheckBoxes chechBoxes = homePage.clickCheckBoxes();

		assertTrue(chechBoxes.checkBox2IsDisabled(), "CheckBox2 is enabled but should be disabled");
		assertTrue(chechBoxes.checkBox2IsEnabled(), "CheckBox2 is disabled but should be enabled");
		assertTrue(chechBoxes.checkBox2IsDisabled(), "CheckBox2 is disabled but should be enabled");

		assertTrue(chechBoxes.checkBox1IsEnabled(), "CheckBox1 is disabled but should be enabled");
		assertTrue(chechBoxes.checkBox1IsDiabled(), "CheckBox1 is enabled but should be disabled");

		assertTrue(chechBoxes.enableBoth(), "Both checkboxes are disabled but should be enabled");
		assertTrue(chechBoxes.disableBoth(), "Both checkboxes are enabled but should be disabled");

	}

	@Test(groups = "differenttests", priority = 3, enabled = false)
	public void dropDownListTest() {
		DropDownList dropDownList = homePage.clickDropDownList();
		assertTrue(dropDownList.selectOption1(), "Option 1 should be selected but it is not selected!");
		assertTrue(dropDownList.selectOption2(), "Option 2 should be selected but it is not selected!");
	}

	@Test(groups = "differenttests", priority = 4, enabled = false)
	public void basicAuthTest() {
		BasicAuth basicAuth = homePage.clickBasicAuth();
		assertTrue(basicAuth.checkSuccessText(), "Success text is not present");
	}

	@Test(groups = "differenttests", priority = 5, enabled = true)
	public void brokenImagesTest() {
		BrokenImages brokenImages = homePage.clickBrokenImages();
		assertTrue(brokenImages.checkImages(), "There should only be 2 broken images on the page!");
		assertTrue(brokenImages.checkImagesSimple(), "There should only be 2 broken images on the page!");
	}

	@Test(groups = "differenttests", priority = 6, enabled = false)
	public void contextMenuTest() {
		ContextMenu contextMenu = homePage.clickContextMenu();
		assertTrue(contextMenu.rightClickContextMenu(), "Alert message is incorrect!");
	}

	@Test(groups = "differenttests", priority = 7, enabled = false)
	public void javaScriptAlerts() {
		JavaScriptAlerts javaScriptAlerts = homePage.clickJavaScriptAlerts();
		assertTrue(javaScriptAlerts.clickJSAlert(), "Alert has not been triggered!");
		assertTrue(javaScriptAlerts.clickJSConfirmOk(), "OK button has not been clicked!");
		assertTrue(javaScriptAlerts.clickJSConfirmCancel(), "Cancel button has not been clicked!");
		assertTrue(javaScriptAlerts.clickJSPromptButton(), "Result string is incorrect!");
	}
}
