package basicRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteIncident {

	@Test
	public void createIncidentWithoutBody() {
//		Step1: Get URI / Endpoint for the server
		RestAssured.baseURI = "https://dev101740.service-now.com/api/now/table/incident";
//		Step2: Authentication (basic Auth)
		RestAssured.authentication =  RestAssured.basic("admin","N2IoYuwzaD7U");
//		Step3: Request Type (Post) -> Ctrl+2 , l
		Response response = RestAssured
				.given()
				.log().all()
				.pathParam("sys_id", "ff4c21c4735123002728660c4cf6a758")
				.contentType(ContentType.JSON)
				.delete("{sys_id}");
//		Step5: Print Response 
		response.prettyPrint();
//		Step4: print status code -> 201
		System.out.println(response.getStatusCode());
	}
	
}
	
	
	

