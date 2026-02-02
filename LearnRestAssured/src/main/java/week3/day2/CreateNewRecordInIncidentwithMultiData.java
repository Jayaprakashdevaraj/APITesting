package week3.day2;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import groovy.transform.stc.POJO;
import io.restassured.http.ContentType;

public class CreateNewRecordInIncidentwithMultiData {
	static PojoInfo pojoinfo = new PojoInfo();
	
	
	@DataProvider 
	public String[][] testData(){
		return new String[][] {
			{"Shortdes-1", "Des-1", "Software", "1"},
			{"Shortdes-2", "Des-2", "hardware", "2"},
			{"Shortdes-3", "Des-3", "database", "3"}
		};
	}
	
	@Test(dataProvider = "testData")
	public void run(String shorty, String descr, String categories, String state){
		pojoinfo.setShort_description(shorty);
		pojoinfo.setDescription(descr);
		pojoinfo.setCategory(categories);
		pojoinfo.setState(state);

		given()
			.baseUri("https://dev272818.service-now.com")
			.basePath("/api/now/table/")
			.auth()
			.basic("admin", "lBWvJ1%Tb6/w")
			.pathParam("tableName", "incident")
			.header("Content-Type", "application/json")
			.log().all()
		.when()
			.body(pojoinfo)
			.post("{tableName}")
		.then()
			.log().all()
			.assertThat()
			.statusCode(201)
			.statusLine(Matchers.containsString("Created"))
			.contentType(ContentType.JSON);
		

	}

}
