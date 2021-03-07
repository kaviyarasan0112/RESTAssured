package assertion;

import org.apache.tools.ant.filters.TokenFilter.ContainsString;
import org.apache.tools.ant.taskdefs.condition.Equals;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AssertionConcepts {
	

	@Test
	public void createIncidentWithoutBody() {
		RestAssured.baseURI = "https://dev101740.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin","N2IoYuwzaD7U");
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body("{    \"short_description\": \"Created a new Incident as String\",    \"category\": \"software\"}")
				.post()
				.then()
				.assertThat()
				.body("result.short_description", Matchers.equalTo("Created a new Incident as") )
//				.body("result.short_description",Matchers.containsString("Created a new Incident") )
				.extract()
				.response()
				;
		response.prettyPrint();
		System.out.println(response.getStatusCode());
		
	}

}
