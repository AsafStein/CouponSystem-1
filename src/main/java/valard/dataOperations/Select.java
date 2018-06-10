package valard.dataOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import valard.dataObjects.Company;
import valard.dataObjects.Coupon;
import valard.dataObjects.Customer;
import valard.utils.DataSource;

public final class Select {
	
	private Select() {}

	public static void selectCompanies() throws SQLException {
		String query = "SELECT CompanyId FROM CouponsTesting.Companies";

		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery(query);
		
		while(rs.next()) {
			for (Company comp : Company.companies) {
				if(comp.getCompanyId() == rs.getLong(1)) {
					System.out.println(comp);
					break;
				}
			}
		}
		
		connection.close();
		preparedStatement.close();
		rs.close();
	}
	
	public static void selectCompanyRow(long id) throws SQLException {
		String query = "SELECT CompanyId FROM CouponsTesting.Companies "
				+ "WHERE CompanyId = " + id;
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery(query);
		
		rs.next();
		for (Company comp : Company.companies) {
			if(comp.getCompanyId() == rs.getLong(1)) {
				System.out.println(comp);
				break;
			}
		}
		
		connection.close();
		preparedStatement.close();
		rs.close();
	}
	
	public static void selectCustomers() throws SQLException{
		String query = "SELECT CustomerId FROM CouponsTesting.Customers";

		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery(query);
		
		while(rs.next()) {
			for (Customer cust : Customer.customers) {
				if(cust.getCustomerId() == rs.getLong(1)) {
					System.out.println(cust);
					break;
				}
			}
		}
		
		connection.close();
		preparedStatement.close();
		rs.close();
	}
	
	public static void selectCustomerRow(long id) throws SQLException{
		String query = "SELECT CustomerId FROM CouponsTesting.Customers "
				+ "WHERE CustomerId = " + id;

		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery(query);
		
		rs.next();
		for (Customer cust : Customer.customers) {
			if(cust.getCustomerId() == rs.getLong(1)) {
				System.out.println(cust);
				break;
			}
		}
		
		connection.close();
		preparedStatement.close();
		rs.close();
	}
	
	public static void selectCouponRow(long id) throws SQLException{
		String query = "SELECT CouponId FROM CouponsTesting.Coupons "
				+ "WHERE CouponId = " + id;

		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery(query);
		
		rs.next();
		for (Coupon coupon : Coupon.coupons) {
			if(coupon.getCouponId() == rs.getLong(1)) {
				System.out.println(coupon);
				break;
			}
		}
		
		connection.close();
		preparedStatement.close();
		rs.close();
	}
	
	public static void selectCoupons() throws SQLException{
		String query = "SELECT CouponId FROM CouponsTesting.Coupons";
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery(query);
		
		while(rs.next()) {
			for (Coupon coupon : Coupon.coupons) {
				if(coupon.getCouponId() == rs.getLong(1)) {
					System.out.println(coupon);
					break;
				}
			}
		}
		
		connection.close();
		preparedStatement.close();
		rs.close();
	}
	
}
















