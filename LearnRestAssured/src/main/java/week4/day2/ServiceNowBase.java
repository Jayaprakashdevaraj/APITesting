package week4.day2;

import org.testng.annotations.BeforeClass;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;

public class ServiceNowBase {
	
	protected RequestSpecBuilder rs = new RequestSpecBuilder();
	protected PojoInfo pi = new PojoInfo(); 
	
	protected static String sysID;
	
	
	@BeforeClass
	public void base() {
		rs.setBaseUri("https://dev272818.service-now.com");
		rs.setBasePath("/api/now/table/");
		rs.setAuth(basic("admin", "lBWvJ1%Tb6/w"));

		rs.addPathParam("tableName", "incident");

	}


	

}
