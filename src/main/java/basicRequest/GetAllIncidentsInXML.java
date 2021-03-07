package basicRequest;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetAllIncidentsInXML {
	
	@Test
	public void getAllIncident() {
//		Step1: Get URI / Endpoint for the server
		RestAssured.baseURI = "https://dev101740.service-now.com/api/now/table/incident";
//		Step2: Authentication (basic Auth)
		RestAssured.authentication= RestAssured.basic("admin","N2IoYuwzaD7U");
//		Step3: Request Type (Get) with param
		Response response = RestAssured
				.given()
				.queryParam("sysparm_fields", "number,sys_id")
				.accept(ContentType.XML)
				.get();
//		Step5: Print Response 
//		response.prettyPrint();
//		Step4: print status code -> 200
		System.out.println(response.getStatusCode());
		
		//need to parse the response to xml
		XmlPath xmlPath = response.xmlPath();
		List<String> ListOfsysID = xmlPath.getList("response.result.sys_id");
		System.out.println(ListOfsysID.get(0));
		System.out.println(response.prettyPrint());
		
		
	}

}
