package week3.day1;

import io.restassured.RestAssured;

public class QueryParams {
	public static void main(String[] args) {
		RestAssured.given()
		.auth()
		.basic("admin", "lBWvJ1%Tb6/w")
		.pathParam("tableName", "incident")
		.queryParam("category", "hardware")
		.queryParam("sysparm_fields", "business_stc, sys_id,sys_created_by")
		.queryParam("state", "2")
		.log().all()
		.when()
		.get("https://dev272818.service-now.com/api/now/table/{tableName}")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}

}
