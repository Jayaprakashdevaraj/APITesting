package incidente2eflow;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class GetIncident {

	private UniqueData uniqueData;

    @BeforeClass
    public void setup() {
        uniqueData = new UniqueData();
    }

	@Test
	public void getIncidentInfo(String sysID) {
		RestAssured.given()
				.baseUri("https://dev272818.service-now.com")
				.basePath("/api/now/table/")
				.auth()
				.basic("admin", "lBWvJ1%Tb6/w")
				.pathParam("tableName", "incident")
				.pathParam("sys_id", uniqueData.globalsysID)
				.header("Content-Type", "application/json")
				.log().all()
				.when()
				.post("{tableName}/{sys_id}")
				.then()
				.log().all()
				.body("result.sys_id", Matchers.equalTo(sysID));
		System.out.println(sysID);
		
	}

}
