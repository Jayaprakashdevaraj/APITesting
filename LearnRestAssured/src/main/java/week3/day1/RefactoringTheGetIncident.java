package week3.day1;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class RefactoringTheGetIncident {
	
	static String baseURI = "https://dev272818.service-now.com";
	static String basePath ="/api/now/table";
	public static void main(String[] args) {
		
		Map<String, String> requiredQueryParam = new HashMap<String, String>();
		requiredQueryParam.put("category", "hardware");
		requiredQueryParam.put("sysparm_fields", "business_stc, sys_id,sys_created_by");
		requiredQueryParam.put("state", "2");
		
		Map<String, String> requriedPathParams = new HashMap<String, String>();
		requriedPathParams.put("tableName", "incident");
		requriedPathParams.put("sys_id", "ff4c21c4735123002728660c4cf6a758");

		
		
		given()
		.baseUri(baseURI)
		.basePath(basePath)
	//	.baseUri("https://dev272818.service-now.com")
	//	.basePath("/api/now/table")
		.auth()
		.basic("admin", "lBWvJ1%Tb6/w")
		.pathParams(requriedPathParams)
		.queryParams(requiredQueryParam)
		.when()
		.get("/{tableName}/{sys_id}")
		.then()
		.assertThat()
		.statusCode(200)
		.statusLine(Matchers.containsString("OK"))
		.contentType(ContentType.JSON)
		.log().all();
		
	}

}
