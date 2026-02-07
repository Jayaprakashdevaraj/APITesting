package stepdefinations;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

public class GetAllIncidentInfo {
	
	private RequestSpecBuilder rs = new RequestSpecBuilder();
	private Response response;
	
	
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
		response.then().statusLine(Matchers.containsString("OK"));

	}
	@Then("user should get the response in the {string} format")
	public void user_should_get_the_responsr_in_the_js_on_format(String responseFormat) {
	   if(responseFormat.equalsIgnoreCase("JSON")) {
		   System.out.println("Response is expected JSON format");
	   }else if(responseFormat.equalsIgnoreCase("XML")){
		   System.out.println("Response is not expected xml format");
	   }
	}

	




	

}
