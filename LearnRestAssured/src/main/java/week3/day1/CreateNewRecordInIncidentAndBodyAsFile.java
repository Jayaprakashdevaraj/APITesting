package week3.day1;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.hamcrest.Matchers;

import io.restassured.http.ContentType;

public class CreateNewRecordInIncidentAndBodyAsFile {

	static File requestBodyAsJSON = new File("src/main/resources/Data/RequestBody_JSON_Format.json");
	static File requestBodyAsCSV = new File("src/main/resources/Data/testdata.csv");
	
	public static void main(String[] args) {
		given()
			.baseUri("https://dev272818.service-now.com")
			.basePath("/api/now/table/")
			.auth()
			.basic("admin", "lBWvJ1%Tb6/w")
			.pathParam("tableName", "incident")
			.header("Content-Type", "application/json")
			.log().all()
		.when()
			.body(requestBodyAsJSON)
			.post("{tableName}")
		.then()
			.log().all()
			.assertThat()
			.statusCode(201)
			.statusLine(Matchers.containsString("Created"))
			.contentType(ContentType.JSON);
	}

}
