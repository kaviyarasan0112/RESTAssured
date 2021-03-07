package assertion;

import org.hamcrest.Matchers;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AssertBodyWithArray {
	
	@Test
	public void createIncidentWithoutBody() {
		RestAssured.baseURI = "https://dev101740.service-now.com/api/now/table/incident";
		RestAssured.authentication =  RestAssured.basic("admin","N2IoYuwzaD7U");
		Response response = RestAssured
				.given()
				.queryParam("sysparm_fields", "number,sys_id")
				.contentType(ContentType.JSON)
				.get()
				.then()
				.assertThat()
				.body("result.number",Matchers.hasItem("INC0010004"))// Array 
				.extract()
				.response()
				;
		response.prettyPrint();
		System.out.println(response.getStatusCode());
	}

}
