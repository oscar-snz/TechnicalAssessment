package com.simetrik.qa.steps;

import com.simetrik.qa.utils.CommonUI;
import com.simetrik.qa.utils.ObjInitialize;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void setUp() {
		CommonUI.openBrowser("chrome");
		ObjInitialize.intializeClassObj();
	}

	@After
	public void tearDown() {
		CommonUI.quitBrowser();
	}

}
