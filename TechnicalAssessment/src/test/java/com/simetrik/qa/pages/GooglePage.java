package com.simetrik.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.simetrik.qa.utils.CommonUI;

public class GooglePage extends CommonUI{

	public GooglePage() {
		PageFactory.initElements(driver, this);
	}
}
