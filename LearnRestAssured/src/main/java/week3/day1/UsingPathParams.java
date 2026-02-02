package week3.day1;

import io.restassured.RestAssured;

public class UsingPathParams {
	public static void main(String[] args) {
		RestAssured.given()
		.auth()
		.basic("admin", "lBWvJ1%Tb6/w")
		.pathParam("tableName", "incident")
		.log().all()
		.when()
		.get("https://dev272818.service-now.com/api/now/table/{tableName}")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}

}
