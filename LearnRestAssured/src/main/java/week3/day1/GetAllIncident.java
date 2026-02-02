package week3.day1;

import io.restassured.RestAssured;

public class GetAllIncident {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.given()
		.auth()
		.basic("admin", "lBWvJ1%Tb6/w")
		.when()
		.get("https://dev272818.service-now.com/api/now/table/incident")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();

	}

}
