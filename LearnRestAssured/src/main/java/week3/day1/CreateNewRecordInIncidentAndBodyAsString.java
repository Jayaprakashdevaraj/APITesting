package week3.day1;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

import io.restassured.http.ContentType;

public class CreateNewRecordInIncidentAndBodyAsString {

	static String requestBody = """
			{
			"description": "Test incident creation 1",
			"short_description": "Test incident short description 1"
			}
			""";
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
			.body(requestBody)
			.post("{tableName}")
		.then()
			.log().all()
			.assertThat()
			.statusCode(201)
			.statusLine(Matchers.containsString("Created"))
			.contentType(ContentType.JSON);
		

	}

}
