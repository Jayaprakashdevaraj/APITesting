package week4.day1;

import java.awt.image.FilteredImageSource;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GenerateJSONUsingPOJO {
	public static void main(String[] args) {
		
	
	EmployeeDetails empdetails = new EmployeeDetails();
	EmpAddress empAddress = new EmpAddress();
	ArrayList<String> bank = new ArrayList<String>();
	bank.add("HDFC");
	bank.add("ICICI");
	bank.add("SBI");
	
	empdetails.setName("Jayaprakash");
	empdetails.setJob("TTL");
	empdetails.setSalary(113000.00);
	empdetails.setEmpAddress(empAddress);
	empdetails.setMarried(false);
	empdetails.setBank(bank);
	
	empAddress.setState("TamilNadu");
	empAddress.setCity("Coimbatore");
	empAddress.setZipCode(641109);
	
	Gson gson = new GsonBuilder()
			.setPrettyPrinting()
			.create();
	
	System.out.println(gson.toJson(empdetails));
	
	}
}
