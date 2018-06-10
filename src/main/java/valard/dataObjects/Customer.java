package valard.dataObjects;

import java.util.ArrayList;

public class Customer {
	
	public static ArrayList<Customer> customers = new ArrayList<>();
	
	private final long customerId;
	private String name;
	private String password;
	
	public Customer(long customerId, String name, String password) {
		this.customerId = customerId;
		setName(name);
		setPassword(password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getCustomerId() {
		return customerId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", password=" + password + "]";
	}
	
}














