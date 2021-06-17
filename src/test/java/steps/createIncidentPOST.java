package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class createIncidentPOST {
	
	Response response;
	ValidatableResponse validatableResponse;

	@Given("Enter the endpoint")
	public void enterTheEndpoint() {
		RestAssured.baseURI = "https://dev101573.service-now.com/api/now/table/incident";
	}

	@Given("Provide the authetication details")
	public void provideTheAutheticationDetails() {
		RestAssured.authentication= RestAssured.basic("admin","sHGiLcCqtX64");
	}

	@When("send the POST request")
	public void sendThePOSTRequest() {
		validatableResponse = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post()
				.then()
				.assertThat();
	}

	@Then("verify the status code as {int}")
	public void verifyTheStatusCodeAs(Integer int1) {
		validatableResponse.statusCode(int1);
	}

}
