package week6.day1;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

public class WireMockData {
	
	
	public static void main(String[] args) {
		
	
	//Step 1: Create mock request (http://localhost:8080)
	//http://localhost:8080/greetings
	
	MappingBuilder requestMocking = WireMock.get("/greetings");
	
	
	//Step 1: Create mock response
	ResponseDefinitionBuilder responceMOcking = WireMock.aResponse().withStatus(200)
				.withStatusMessage("OK")
				.withBody("Hello! World");
	
	
	//Mapping both request andresponce mocking
	WireMock.stubFor(requestMocking.willReturn(responceMOcking));
	}
}
