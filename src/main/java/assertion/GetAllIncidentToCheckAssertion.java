package assertion;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllIncidentToCheckAssertion {
	
	@Test
	public void getAllIncident() {
		RestAssured.baseURI = "https://dev101740.service-now.com/api/now/table/incident";
		RestAssured.authentication =  RestAssured.basic("admin","N2IoYuwzaD7U");
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.get()
				.then()
				.assertThat()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.extract()
				.response()
				;
		System.out.println(response.prettyPrint());
	
		
	}

}
