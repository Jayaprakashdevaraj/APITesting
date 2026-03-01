package stepdefinations;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.sdk.logs.data.Body;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

public class GetAllIncidentInfo {
	
	private RequestSpecBuilder rs = new RequestSpecBuilder();
	private Response response;
	PojoInfo pj = new PojoInfo();
	
	
	@Given("user should set baseuri as {string} setup the basic")
	public void user_should_set_baseuri_as_setup_the_basic(String baseURI) {
		rs.setBaseUri(baseURI);
	}
	@Given("user should set basepath as {string} setup the basic")
	public void user_should_set_basepath_as_setup_the_basic(String basePath) {
		rs.setBasePath(basePath);
	}
	@Given("user should provide basic authentication username as {string} and password as {string}")
	public void user_should_provide_basic_authenticatio_username_as_and_password_as(String username, String password) {
	    rs.setAuth(RestAssured.basic(username, password));
	}
	@Given("user should set header key as {string} and value as {string}")
	public void user_should_set_header_key_ad_and_value_as(String key, String value) {
		rs.addHeader(key, value);
	 }

	
	@When("user hit the get method and retriva all method from incident table")
	public void user_hit_the_get_method_and_retriva_all_method_from_incident_table() {
		response = RestAssured.given().spec(rs.build()).get("incident");
		
	}
	@Then("user should see the status should be {string}")
	public void user_should_see_the_status_should_be(String statusCode) {
	    response.then().statusCode(Integer.parseInt(statusCode));
	    
	}
	@Then("user should see the status line should be {string}")
	public void user_should_see_the_status_line_should_be(String statusLine) {
		response.then().statusLine(Matchers.containsString(statusLine));

	}
	@Then("user should get the response in the {string} format")
	public void user_should_get_the_responsr_in_the_js_on_format(String responseFormat) {
	   if(responseFormat.equalsIgnoreCase("JSON")) {
		   System.out.println("Response is expected JSON format");
	   }else if( responseFormat.equalsIgnoreCase("xml")){
		   System.out.println("Response is expected xml format");
	   }
	}

	
	@Given("user should give short description as {string}")
	public void user_should_give_short_description_as(String shortDescription) {
	    pj.setShort_description(shortDescription);
	}
	@When("user hit the post method to create new record in incident table")
	public void user_hit_the_post_method_to_create_new_record_in_incident_table() {
	    response = RestAssured.given().spec(rs.build()).when().body(pj).post("incident");
	}

	@Then("user should get success responce with following expected values")
	public void user_should_get_success_responce_with_following_expected_values(DataTable dataTable) {
		List<Map<String, String>> asMaps = dataTable.asMaps();
		for (Map<String, String> map : asMaps) {
			 response.then().statusCode(Integer.parseInt(map.get("statusCode")));
			 response.then().statusLine(Matchers.containsString(map.get("statusLine")));
			 if(map.get("responseFormat").equalsIgnoreCase("JSON")) {
				   System.out.println("Response is expected JSON format");
			   }else if( map.get("responseFormat").equalsIgnoreCase("xml")){
				   System.out.println("Response is expected xml format");
			   }
			
		}
	    
	}
	@Then("user should see the {string} value in short_description key")
	public void user_should_see_the_value_in_short_description_key(String expectedshortDescription) {
		response.then().assertThat().body("result.short_description", Matchers.equalTo(expectedshortDescription));
	}





	

}
