package incidente2eflowwithMultiSysID;

import java.util.Iterator;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class GetIncident {

	@Test
	public static void getIncidentInfo() {
		for (String sysid : CreateMultiIncident.sysidList) {
			System.out.println("Get sysID info is "+sysid);	
		
		RestAssured.given()
				.baseUri("https://dev272818.service-now.com")
				.basePath("/api/now/table/")
				.auth()
				.basic("admin", "lBWvJ1%Tb6/w")
				.pathParam("tableName", "incident")
	//			.pathParam("sys_id", uniqueData.globalsysID)
				.pathParam("sys_id", sysid)
				.header("Content-Type", "application/json")
				.log().all()
				.when()
				.get("{tableName}/{sys_id}")
				.then()
				.log().all()
				.body("result.sys_id", Matchers.equalTo(sysid));
	
	}
	}
}
