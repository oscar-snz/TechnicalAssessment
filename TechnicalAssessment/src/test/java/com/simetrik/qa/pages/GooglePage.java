package com.simetrik.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.simetrik.qa.utils.CommonUI;

public class GooglePage extends CommonUI {

	@FindBy(css = ".gLFyf.gsfi")
	WebElement searchTextBox;

	@FindBy(css = ".LC20lb.MBeuO.DKV0Md")
	WebElement result;

	public GooglePage() {
		PageFactory.initElements(driver, this);
	}

	public void search(String text) {
		enter(searchTextBox, text);
		sendEnter(searchTextBox);

	}

	// This method will return true if at least one result is found

	

	// this method will return the amount of results
	public int resultsCount() {
		int count = 0;
		count = driver.findElements(By.cssSelector(".LC20lb.MBeuO.DKV0Md")).size();
		return count;
	}

}
