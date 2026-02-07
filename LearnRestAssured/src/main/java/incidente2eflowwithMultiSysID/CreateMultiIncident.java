package incidente2eflowwithMultiSysID;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.ValidatableResponse;
import week3.day2.PojoInfo;

public class CreateMultiIncident {
	static PojoInfo pi = new PojoInfo();
	public static List<String> sysidList = new ArrayList<String>();
	
	@DataProvider
	public Object[][] testdata(){
		return new String[][] {
			{"Create shoer-1","Create Des-1","Hardware","1"},
			{"Create shoer-2","Create Des-2","Hardware","2"}
		};
	}
		
	@Test(dataProvider = "testdata")
	public void createMultiIncidensysID(String shorty, String desc, String cat, String states) {
		pi.setShort_description(shorty);
		pi.setDescription(desc);
		pi.setCategory(cat);
		pi.setState(states);
		
		String sysID = given()
			.baseUri("https://dev272818.service-now.com")
			.basePath("/api/now/table/")
			.auth() 
			.basic("admin", "lBWvJ1%Tb6/w")
			.pathParam("tableName", "incident")
			.headers("Content-Type", "application/json")
			.log().all()
		.when()
			.body(pi)
			.post("{tableName}")
		.then()
			.log().all()
			.statusCode(201)
			.statusLine(Matchers.containsString("Created"))
			.time(Matchers.lessThan(5000l))
			.extract()
			.jsonPath()
			.get("result.sys_id");
		

		
		
		sysidList.add(sysID);
			
	}
	

}
