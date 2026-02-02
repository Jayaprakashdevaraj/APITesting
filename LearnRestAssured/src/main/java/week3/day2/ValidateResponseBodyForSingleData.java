package week3.day2;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import io.restassured.http.ContentType;

public class ValidateResponseBodyForSingleData {
	static PojoInfo pojoinfo = new PojoInfo();
	
	public static void main(String[] args) {
		pojoinfo.setCategory("Software");
		pojoinfo.setShort_description("Pojo short description");
		pojoinfo.setDescription("Pojo description");
		pojoinfo.setState("4");
		
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
			.contentType(ContentType.JSON)
			.time(Matchers.lessThan(5000l));
		

	}

}
