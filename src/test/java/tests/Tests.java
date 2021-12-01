package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddOrRemoveElements;
import pages.CheckBoxes;
import pages.DropDownList;

public class Tests extends BaseTest {

	@Test(groups = "differenttests", priority = 1)
	public void addAndRemoveElementsTest() {
		AddOrRemoveElements addOrRemoveElements = homePage.clickAddOrRemoveElements();
		for (int i = 1; i <= 5; i++) {
			assertTrue(addOrRemoveElements.addElement(i), "Element was not added");
		}
		for (int i = 5; i >= 1; i--) {
			assertTrue(addOrRemoveElements.removeElement(i), "Element was deleted");
		}
	}

	@Test(groups = "differenttests", priority = 2)
	public void checkBoxTest() {
		CheckBoxes chechBoxes = homePage.clickCheckBoxes();
		assertTrue(chechBoxes.checkBox2IsDisabled(), "CheckBox2 is enabled but should be disabled");
		assertTrue(chechBoxes.checkBox2IsEnabled(), "CheckBox2 is disabled but should be enabled");
		assertTrue(chechBoxes.checkBox1IsEnabled(), "CheckBox1 is disabled but should be enabled");
		assertTrue(chechBoxes.checkBox1IsDiabled(), "CheckBox1 is enabled but should be disabled");
		assertTrue(chechBoxes.checkBox1IsEnabled(), "CheckBox1 is disabled but should be enabled");
	}

	@Test(groups = "differenttests", priority = 3)
	public void dropDownListTest() {
		DropDownList dropDownList = homePage.clickDropDownList();
		assertTrue(dropDownList.selectOption1(), "Option 1 should be selected but it is not selected!");
		assertTrue(dropDownList.selectOption2(), "Option 2 should be selected but it is not selected!");
	}
}
