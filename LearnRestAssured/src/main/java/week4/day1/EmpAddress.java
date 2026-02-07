package week4.day1;

import com.google.gson.annotations.SerializedName;

public class EmpAddress {
	
	private String state;
	private String city;
	
	@SerializedName("pincode")
	private int zipCode;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}


}
