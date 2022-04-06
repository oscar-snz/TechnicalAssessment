package com.simetrik.qa.steps;

import com.simetrik.qa.utils.CommonUI;
import com.simetrik.qa.utils.Constants;
import com.simetrik.qa.utils.ObjInitialize;
import com.simetrik.qa.utils.RegionDataObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class GoogleSteps extends ObjInitialize {

	@Given("user navigates to application {string}")
	public void user_navigates_to_application(String region) {

		RegionDataObject.filterRegion(region, "Environment");

		CommonUI.navigate(regionDataMap.get("url"));

		intializeClassObj();
	}

	@When("user searches with specific keyword {string}")
	public void user_searches_with_specific_keyword(String value) {
		googlePageObj.search(value);

	}

	@Then("user verifies search {string}")
	public void user_verifies_search(String value) {

		int result = Integer.parseInt(value);

		int actCount = googlePageObj.resultsCount();

		boolean outcome = actCount > result;

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(outcome);

		softAssert.assertAll();

	}

}
