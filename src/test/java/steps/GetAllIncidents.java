package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncidents {
	
	
	@Given("Enter the URL")
	public void enterTheUrl() {
		
		RestAssured.baseURI = "https://dev101740.service-now.com/api/now/table/incident";
	    
	}
	@And("Enter the authentication details")
	public void enterTheAuthenticationDetails() {
		RestAssured.authentication= RestAssured.basic("admin","N2IoYuwzaD7U");
	}
	@Then("Print the incident details")
	public void printTheIncidentDetails() {
		Response response = RestAssured
				.given()
				.queryParam("sysparm_fields", "number,sys_id")
				.get();
		System.out.println(response.prettyPrint());
	}

}
