package week6.day2;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateOAuthAccessToken {
	public static void main(String[] args) {
		
	
	String access_token = RestAssured.given()
				.baseUri("https://dev272818.service-now.com")
				.contentType(ContentType.URLENC)
				.when()
				.formParam("grand_type", "password")
				.formParam("client-id", "")
				.formParam("client_secret", "")
				.formParam("username", "admin")
				.formParam("password", "lBWvJ1%Tb6/w")
				.post("/oauth_token.do")
				.then()
				.log().all()
				.assertThat()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.extract()
				.jsonPath()
				.getString("access_tokem");
	
	System.out.println(access_token);
	
	
	RestAssured.given()
				.baseUri("https://dev272818.service-now.com")
				.basePath("/api/now/table")
				.header("Authorization","Bearer "+access_token)
				.log().all()
				.when()
				.get("/incident")
				.then()
				.assertThat()
				.statusCode(200);
	
				
	}
}

