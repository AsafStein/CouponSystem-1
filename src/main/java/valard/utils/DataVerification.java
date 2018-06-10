package valard.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.validator.routines.EmailValidator;

public final class DataVerification {
	
	private DataVerification() {}
	
	public static final String EMAIL_EXCEPTION = "email pattern does not match";
	public static final String COMPANY_ID_EXCEPTION = "this ComapnyId does not exists in table Companies.CompanyId field";
	public static final String CUSTOMER_ID_EXCEPTION = "this CustomerId does not exists in table Customers.CustomerId field";
	public static final String COUPON_ID_EXCEPTION = "this CouponId does not exists in table Coupons.CouponId field";
	public static final String DATE_VERIFICATION_EXCEPTION = "Early Date time can't be AFTER Late Date time";
	public static final String NEGATIVE_NUMBER_EXCEPTION = "Negative Number in non negative number field (amount, price)";
	
	public static boolean emailVerification(String email) {
		boolean verified = EmailValidator.getInstance().isValid(email);
		return verified;
	}
	
	public static boolean companyIdExistance(long id) throws SQLException {
		boolean verified = false;
		
		String query = "SELECT CompanyId FROM CouponsTesting.Companies "
				+ "WHERE CompanyId = " + id;
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		
		if(rs.next())
			verified = true;
		
		return verified;
	}
	
	public static boolean customerIdExistance(long id) throws SQLException{
		boolean verified = false;
		
		String query = "SELECT CustomerId FROM CouponsTesting.Customers "
				+ "WHERE CustomerId = " + id;
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		
		if(rs.next())
			verified = true;
		
		return verified;
	}
	
	public static boolean couponIdExistance(long id) throws SQLException{
		boolean verified = false;
		
		String query = "SELECT CouponId FROM CouponsTesting.Coupons "
				+ "WHERE CouponId = " + id;
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		
		if(rs.next())
			verified = true;
		
		return verified;
	}
	
	public static boolean dateVerification(Date early, Date late) {
		boolean verified = false;
		
		if(early.before(late))
			verified = true;
		
		return verified;
	}
	
	public static boolean numberIsNegative(int num) {
		boolean verified = false;
		
		if(num < 0)
			verified = true;
		
		return verified;
	}
	
	public static boolean numberIsNegative(double num) {
		boolean verified = false;
		
		if(num < 0)
			verified = true;
		
		return verified;
	}
}












