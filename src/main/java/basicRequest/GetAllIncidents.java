package basicRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncidents {

	@Test
	public void getAllIncident() {
//		Step1: Get URI / Endpoint for the server
		RestAssured.baseURI = "https://dev101573.service-now.com/api/now/table/incident";
//		Step2: Authentication (basic Auth)
		RestAssured.authentication =  RestAssured.basic("admin","sHGiLcCqtX64");
//		Step3: Request Type (Get) -> Ctrl+2 , l
		Response response = RestAssured.get();
//		Step5: Print Response 
		response.prettyPrint();
		System.out.println(response.getContentType());
//		Step4: print status code -> 200
		System.out.println(response.getStatusCode());
	
}
}
