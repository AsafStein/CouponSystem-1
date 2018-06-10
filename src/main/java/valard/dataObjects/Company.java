package valard.dataObjects;

import java.util.ArrayList;

public class Company {
	
	public static ArrayList<Company> companies = new ArrayList<>();
	
	private final long companyId;
	private String name;
	private String passwrod;
	private String email;
	
	public Company(long companyId, String name, String password, String email) {
		this.companyId = companyId;
		setEmail(email);
		setName(name);
		setPasswrod(password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswrod() {
		return passwrod;
	}

	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCompanyId() {
		return companyId;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", name=" + name + ", passwrod=" + passwrod + ", email=" + email
				+ "]";
	}
	
}














