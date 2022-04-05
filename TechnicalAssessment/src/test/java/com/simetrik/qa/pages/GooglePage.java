package com.simetrik.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.simetrik.qa.utils.CommonUI;

public class GooglePage extends CommonUI{

	
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
	
	public boolean resultsExist() {
		boolean exist = false;
		
		if(result.isDisplayed()) {
			exist = true;
		}
		
		
		return exist;
		
	}
	
}
