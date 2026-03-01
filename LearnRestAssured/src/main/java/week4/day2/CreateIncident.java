package week4.day2;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class CreateIncident extends ServiceNowBase {
	
	@Test
	public void createNewIncident() {	
		pi.setShort_description("Create incident short description");
		pi.setDescription("Create incident Description for Jayaprakash");
		pi.setCategory("software");
		pi.setState("1");
		
		 ValidatableResponse response = RestAssured.given()
				.spec(rs.build())
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