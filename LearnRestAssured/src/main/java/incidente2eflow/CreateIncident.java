package incidente2eflow;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class CreateIncident {
	static private PojoInfo pi = new PojoInfo(); 
	
	public static String sysID;
	
	@Test
	public void createNewIncident() {	
		pi.setShort_description("Create incident short description");
		pi.setDescription("Create incident Description");
		pi.setCategory("software");
		pi.setState("1");
		
		 ValidatableResponse response = RestAssured.given()
				.baseUri("https://dev272818.service-now.com")
				.basePath("/api/now/table/")
				.auth()
				.basic("admin", "lBWvJ1%Tb6/w")
				.pathParam("tableName", "incident")
				.header("Content-Type", "application/json")
				.log().all()
				.when()
				.post("{tableName}")
				.then()
				.log().all();


		 response.statusCode(201)
		.statusLine(Matchers.containsString("Created"))
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(10000l));

		sysID = response.extract().jsonPath().getString("result.sys_id");
//		uniqueData.globalsysID=sysID;
//		data.setSysID(sysID);
		System.out.println("Post request SYS ID is "+sysID);
	}
}