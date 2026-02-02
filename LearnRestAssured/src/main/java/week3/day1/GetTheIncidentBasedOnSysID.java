package week3.day1;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;

public class GetTheIncidentBasedOnSysID {
public static void main(String[] args) {
	RestAssured.given()
	.auth()
	.basic("admin", "lBWvJ1%Tb6/w")
	.pathParam("tableName", "incident")
	.pathParam("sys_id", "5914951953be3210721051a0a0490e9e")
	.when()
	.get("https://dev272818.service-now.com/api/now/table/{tableName}/{sys_id}")
	.then()
	.assertThat()
	.statusCode(200)
	.log().all();
//	.log().ifValidationFails(LogDetail.STATUS);

}
}
