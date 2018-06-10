package valard.dataOperations;

import java.sql.SQLException;

import valard.utils.DataSource;

public final class DatabaseCreator {
	
	private DatabaseCreator() {
		
	}
	
	public static void createDb(String dbName) throws SQLException {
		String query = String.format("CREATE DATABASE %s", dbName);
		DataSource.executeUpdate(query);
		
		createTableCompanies();
		createTableCoupons();
		createTableCustomers();
		createTableCustomersVsCoupons();
	}
	
	private static void createTableCompanies() throws SQLException{
		String query = "CREATE TABLE CouponsTesting.Companies("
				+ "CompanyId BIGINT NOT NULL AUTO_INCREMENT, "
				+ "CompanyName VARCHAR(30) NOT NULL, "
				+ "Password VARCHAR(30) NOT NULL, "
				+ "Email VARCHAR(40) NOT NULL, "
				+ "PRIMARY KEY(CompanyId)"
				+ ")";
		
		DataSource.executeUpdate(query);
	}
	
	private static void createTableCustomers() throws SQLException{
		String query = "CREATE TABLE CouponsTesting.Customers("
				+ "CustomerId BIGINT NOT NULL AUTO_INCREMENT, "
				+ "CustomerName VARCHAR(30) NOT NULL, "
				+ "Password VARCHAR(30) NOT NULL,"
				+ "PRIMARY KEY(CustomerId)"
				+ ")";
		
		DataSource.executeUpdate(query);
	}
	
	private static void createTableCoupons() throws SQLException{
		String query = "CREATE TABLE CouponsTesting.Coupons("
				+ "CouponId BIGINT NOT NULL AUTO_INCREMENT, "
				+ "CompanyId BIGINT NOT NULL, "
				+ "Title VARCHAR(150), "
				+ "StartDate DATE NOT NULL, "
				+ "EndDate DATE NOT NULL, "
				+ "Amount INT NOT NULL, "
				+ "Type ENUM('Food', 'Electronics', 'Entertainment', 'Vacation') NOT NULL,"
				+ "Message VARCHAR(330) NOT NULL, "
				+ "Price DOUBLE NOT NULL, "
				+ "Image VARCHAR(100), "
				+ "PRIMARY KEY(CouponId), "
				+ "FOREIGN KEY(CompanyId) REFERENCES CouponsTesting.Companies(CompanyId)"
				+ ")";
		
		DataSource.executeUpdate(query);
		
	}
	
	private static void createTableCustomersVsCoupons() throws SQLException{
		String query = "CREATE TABLE CouponsTesting.CustomerVsCoupons("
				+ "CustomerId BIGINT NOT NULL, "
				+ "CouponId BIGINT NOT NULL,"
				+ "PRIMARY KEY(CustomerId, CouponId), "
				+ "FOREIGN KEY(CustomerId) REFERENCES CouponsTesting.Customers(CustomerId), "
				+ "FOREIGN KEY(CouponId) REFERENCES CouponsTesting.Coupons(CouponId)"
				+ ")";
		
		DataSource.executeUpdate(query);
	}
	

}


















