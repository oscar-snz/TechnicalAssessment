package com.simetrik.qa.steps;


import com.simetrik.qa.utils.CommonUI;
import com.simetrik.qa.utils.ObjInitialize;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
public class GoogleSteps extends ObjInitialize{

	@Given("user is on search page {string}")
	public void user_is_on_search_page(String url) {
		CommonUI.openBrowser("chrome");
		CommonUI.navigate(url);
		intializeClassObj();
	}

	@When("user enters keyword {string}")
	public void user_enters(String key) {
		GooglePageObj.search(key);
		
		

	}



	@Then("user verifies results greater than zero")
	public void user_verifies_results_greater_than_zero() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(GooglePageObj.resultsExist(), true);
		if(GooglePageObj.resultsExist()){
			System.out.println("Total of " + GooglePageObj.resultsCount() + " results were found");
		}
	    softAssert.assertAll();
	    
	    CommonUI.quitBrowser();
	    
	    
	}

}
