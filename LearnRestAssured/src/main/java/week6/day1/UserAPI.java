package week6.day1;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class UserAPI {

	WireMockServer mockServer = new WireMockServer();
	private static final String MOCK_BASEURL = "http://localhost:8080";
	private static final String LIVE_BASEURL = "https://gorest.co.in";
	private static final String Given_BASEURL = "/public/v2";
	String sampleResponse = """
		[
    {
        "id": 8379876,
        "name": "Udai Dhawan VM",
        "email": "dhawan_vm_udai@marvin-lubowitz.test",
        "gender": "female",
        "status": "inactive"
    },
    {
        "id": 8379875,
        "name": "Madhuri Mahajan",
        "email": "madhuri_mahajan@bosco.example",
        "gender": "male",
        "status": "active"
    },
    {
        "id": 8379873,
        "name": "Adhrit Tandon IV",
        "email": "adhrit_tandon_iv@wuckert.example",
        "gender": "female",
        "status": "inactive"
    },
    {
        "id": 8379872,
        "name": "Devagya Sethi DC",
        "email": "sethi_devagya_dc@morissette-witting.test",
        "gender": "female",
        "status": "active"
    },
    {
        "id": 8379871,
        "name": "Suryakanta Iyer VM",
        "email": "vm_suryakanta_iyer@kilback-crona.test",
        "gender": "female",
        "status": "active"
    },
    {
        "id": 8379870,
        "name": "Anjushree Asan",
        "email": "asan_anjushree@braun.test",
        "gender": "male",
        "status": "active"
    },
    {
        "id": 8379869,
        "name": "Dayaananda Menon",
        "email": "dayaananda_menon@larkin.test",
        "gender": "female",
        "status": "inactive"
    },
    {
        "id": 8379868,
        "name": "Shashi Sinha",
        "email": "shashi_sinha@stroman-prohaska.test",
        "gender": "female",
        "status": "inactive"
    },
    {
        "id": 8379867,
        "name": "Msgr. Nimit Nehru",
        "email": "nehru_nimit_msgr@hessel.example",
        "gender": "female",
        "status": "inactive"
    },
    {
        "id": 8379866,
        "name": "Deepan Nair",
        "email": "nair_deepan@bailey.test",
        "gender": "female",
        "status": "inactive"
    }
]
			""";
	
	
	@BeforeSuite
	public void startServer() {
		mockServer.start();
	}
	
	
	@BeforeClass
	public void beforeRequest() {
		MappingBuilder requestMocking = WireMock.get("/public/v2/users");
		ResponseDefinitionBuilder responseMocking = WireMock.aResponse()
				.withStatus(200)
				.withStatusMessage("OK")
				.withHeader("Content-Type", "application/json")
				.withBody(sampleResponse);
		
		mockServer.stubFor(requestMocking.willReturn(responseMocking));
	}
	
	@Test
	public void validateGetAllUser() {
		RestAssured.given()
		.baseUri(MOCK_BASEURL)
		.basePath(Given_BASEURL)
		.log().all()
		.get("/users")
		.then()
		.log().all()
		.statusCode(200)
		.statusLine(Matchers.containsString("OK"))
		.contentType(ContentType.JSON);
		
	}
	
	
	@AfterSuite
	public void stopServer() {
		mockServer.stop();
	}

}
