package incidente2eflow;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class DeleteIncident {
	

	@Test
	public static void deleteIncident() {	

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
				.delete("{tableName}/{sys_id}")
				.then()
				.log().all();


		 response.statusCode(204)
		.statusLine(Matchers.containsString("No Content"))
		.time(Matchers.lessThan(5000l));
	}
}