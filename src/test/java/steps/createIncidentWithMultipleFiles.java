package steps;

import java.io.File;

import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class createIncidentWithMultipleFiles {
	

	
	ValidatableResponse validatableResponse;

	
	@When ("send the POST Request with filename as (.*)")
	public void sendThePOSTRequestWithFilename(String filename) {
		
		validatableResponse = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(new File("./Data/"+filename+".JSON"))
				.post()
				.then()
				.assertThat();

	}
}
