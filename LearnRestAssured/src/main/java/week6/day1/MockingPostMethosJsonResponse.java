package week6.day1;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

public class MockingPostMethosJsonResponse {
	public static void main(String[] args) {
		MappingBuilder requestBody = WireMock.post("/api/v1/user")
				.withHeader("Content-Type", WireMock.equalTo("application/json"))
				.withRequestBody(WireMock.equalToJson("""
						{
							"name":"Jayaprakash",
							"gender":"male",
							"email":"sample@gmail.com",
							"status":"active"
						}
						"""));
		ResponseDefinitionBuilder responseBody = WireMock.aResponse()
				.withStatus(201)
				.withStatusMessage("Created")
				.withHeader("Content-Type", "application/json")
				.withBody("""
						{
						"id" :"12345",
						"name":"Jayaprakash Response",
						"gender":"male",
						"email":"sample@gmail.com",
						"status":"active"
					}
					""");
		
		WireMock.stubFor(requestBody.willReturn(responseBody));
		
	}

}
