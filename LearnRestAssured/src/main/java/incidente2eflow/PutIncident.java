package incidente2eflow;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class PutIncident {
	
	static PojoInfo pojoinfo = new PojoInfo();

	
	@Test
	public static void updateExistingIncident() {
		
		pojoinfo.setShort_description("Update Short Description");
		pojoinfo.setDescription("Update Description");
		pojoinfo.setCategory("Hardware");
		pojoinfo.setState("12");
		
		
		 ValidatableResponse response = RestAssured.given()
				.baseUri("https://dev272818.service-now.com")
				.basePath("/api/now/table/")
				.auth()
				.basic("admin", "lBWvJ1%Tb6/w")
				.pathParam("tableName", "incident")
				.pathParam("sys_id", CreateIncident.sysID)
				.header("Content-Type", "application/json")
				.log().all()
				.when()
				.body(pojoinfo)
				.put("{tableName}/{sys_id}")
				.then()
				.log().all();


		 response.statusCode(200)
		.statusLine(Matchers.containsString("OK"))
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000l));

		String putSysID = response.extract().jsonPath().getString("result.sys_id");
		System.out.println("PUT request SYS ID is "+putSysID);
	}
}