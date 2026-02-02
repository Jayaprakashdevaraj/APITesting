package incidente2eflow;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class CreateIncident {
/*	private UniqueData uniqueData;
	
	public CreateIncident(UniqueData uniqueData) {
		this.uniqueData = uniqueData;
	}
*/
	
	private UniqueData uniqueData;

    @BeforeClass
    public void setup() {
        uniqueData = new UniqueData();
    }
	
	@Test
	public void createNewIncident() {	
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


/*		response.statusCode(201)
		.statusLine(Matchers.containsString("Created"))
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000l));
*/
		String sysID = response.extract().jsonPath().getString("result.sys_id");
		uniqueData.globalsysID=sysID;
		System.out.println(sysID);
	}
}