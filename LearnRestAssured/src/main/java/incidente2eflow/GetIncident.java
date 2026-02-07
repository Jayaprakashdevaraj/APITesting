package incidente2eflow;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class GetIncident {

/*	private UniqueData uniqueData;

    @BeforeClass
    public void setup() {
        uniqueData = new UniqueData();
    }
*/
	@Test
	public static void getIncidentInfo() {
		System.out.println("Get sysID info is "+CreateIncident.sysID);
		RestAssured.given()
				.baseUri("https://dev272818.service-now.com")
				.basePath("/api/now/table/")
				.auth()
				.basic("admin", "lBWvJ1%Tb6/w")
				.pathParam("tableName", "incident")
				.pathParam("sys_id", CreateIncident.sysID)
				.header("Content-Type", "application/json")
				.log().all()
				.when()
				.get("{tableName}/{sys_id}")
				.then()
				.log().all()
				.statusCode(200)
				.statusLine(Matchers.containsString("OK"))
				.body("result.sys_id", Matchers.equalTo(CreateIncident.sysID));
	
	}

}
