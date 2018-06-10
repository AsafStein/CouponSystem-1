package valard.dataOperations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DateTimeException;

import valard.utils.DataSource;
import valard.utils.DataVerification;
import valard.utils.DateUtil;

public final class Update {
	
	private Update() {}
	
	public static void updateCompanyRow(String name, String password, String email, long id) throws SQLException{
		
		if(!DataVerification.companyIdExistance(id))
			throw new SQLException(DataVerification.COMPANY_ID_EXCEPTION);
		
		if(!DataVerification.emailVerification(email))
			throw new IllegalArgumentException(DataVerification.EMAIL_EXCEPTION);
		
		String query = String.format("UPDATE CouponsTesting.Companies "
				+ "SET CompanyName = '%s', Password = '%s', Email = '%s' "
				+ "WHERE CompanyId = %d", name, password, email, id);
		
		DataSource.executeUpdate(query);
	}
	
	public static void updateCompanyName(String name, long id) throws SQLException{
		
		if(!DataVerification.companyIdExistance(id))
			throw new SQLException(DataVerification.COMPANY_ID_EXCEPTION);
		
		String query = String.format("UPDATE CouponsTesting.Companies "
				+ "SET CompanyName = '%s' WHERE CompanyId = %d"
				, name, id);
				
		DataSource.executeUpdate(query);
	}
	
	public static void updateCompanyPassword(String password, long id) throws SQLException{
		
		if(!DataVerification.companyIdExistance(id))
			throw new SQLException(DataVerification.COMPANY_ID_EXCEPTION);
		
		String query = String.format("UPDATE CouponsTesting.Companies "
				+ "SET Password = '%s' WHERE CompanyId = %d"
				, password, id);
				
		DataSource.executeUpdate(query);
	}
	
	public static void updateCompanyEmail(String email, long id) throws SQLException{
		
		if(!DataVerification.companyIdExistance(id))
			throw new SQLException(DataVerification.COMPANY_ID_EXCEPTION);
		
		if(!DataVerification.emailVerification(email))
			throw new IllegalArgumentException(DataVerification.EMAIL_EXCEPTION);
		
		String query = String.format("UPDATE CouponsTesting.Companies "
				+ "SET Email = '%s' WHERE CompanyId = %d"
				, email, id);
				
		DataSource.executeUpdate(query);
	}
	
	public static void updateCustomerRow(String name, String password, long id) throws SQLException{
		
		if(!DataVerification.customerIdExistance(id))
			throw new SQLException(DataVerification.CUSTOMER_ID_EXCEPTION);
		
		String query = String.format("UPDATE CouponsTesting.Customers "
				+ "SET CustomerName = '%s', Password = '%s' "
				+ "WHERE CustomerId = '%d'"
				,name, password, id);
		
		DataSource.executeUpdate(query);
	}
	
	public static void updateCustomerName(String name, long id) throws SQLException{
		
		if(!DataVerification.customerIdExistance(id))
			throw new SQLException(DataVerification.CUSTOMER_ID_EXCEPTION);
		
		String query = String.format("UPDATE CouponsTesting.Customers "
				+ "SET CustomerName = '%s' "
				+ "WHERE CustomerId = '%d'"
				,name, id);
		
		DataSource.executeUpdate(query);
	}
	
	public static void updateCustomerPassword(String password, long id) throws SQLException{
		
		if(!DataVerification.customerIdExistance(id))
			throw new SQLException(DataVerification.CUSTOMER_ID_EXCEPTION);
		
		String query = String.format("UPDATE CouponsTesting.Customers "
				+ "SET Password = '%s' "
				+ "WHERE CustomerId = '%d'"
				,password, id);
		
		DataSource.executeUpdate(query);
	}
	
	public static void updateCouponRow(long companyId, String title, long startDate, long endDate, 
			int amount, CouponType type, String message, int price, String imgUrl, long id) throws SQLException{
		
		if(!DataVerification.couponIdExistance(id))
			throw new SQLException(DataVerification.COUPON_ID_EXCEPTION);
		if(!DataVerification.companyIdExistance(companyId))
			throw new SQLException(DataVerification.COMPANY_ID_EXCEPTION);
		
		Date start = new Date(DateUtil.getNow());
		Date end = new Date(endDate);
		
		if(!DataVerification.dateVerification(start, end))
			throw new DateTimeException(DataVerification.DATE_VERIFICATION_EXCEPTION);
		if(DataVerification.numberIsNegative(amount))
			throw new ArithmeticException(DataVerification.NEGATIVE_NUMBER_EXCEPTION);
		if(DataVerification.numberIsNegative(price))
			throw new ArithmeticException(DataVerification.NEGATIVE_NUMBER_EXCEPTION);
		
		String query = "UPDATE CouponsTesting.Coupons "
				+ "SET CompanyId = ?, Title = ?, StartDate = ?, EndDate = ?, Amount = ?, "
				+ "Type = ?, Message = ?, Price = ?, Image = ? "
				+ "WHERE CouponId = ?";
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setLong(1, companyId);
		preparedStatement.setString(2, title);
		preparedStatement.setDate(3, start);
		preparedStatement.setDate(4, end);
		preparedStatement.setInt(5, amount);
		preparedStatement.setString(6, type.name());
		preparedStatement.setString(7, message);
		preparedStatement.setInt(8, price);
		preparedStatement.setString(9, imgUrl);
		preparedStatement.setLong(10, id);
		preparedStatement.executeUpdate();
		
		connection.close();
		preparedStatement.close();
		
	}
	
	public static void updateCouponCompany(long companyId, long id) throws SQLException{
		
		if(!DataVerification.couponIdExistance(id))
			throw new SQLException(DataVerification.COUPON_ID_EXCEPTION);
		if(!DataVerification.companyIdExistance(companyId))
			throw new SQLException(DataVerification.COMPANY_ID_EXCEPTION);
		
		String query = "UPDATE CouponsTesting.Coupons "
				+ "SET CompanyId = ? "
				+ "WHERE CouponId = ?";
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setLong(1, companyId);
		preparedStatement.setLong(2, id);
		preparedStatement.executeUpdate();
		
		connection.close();
		preparedStatement.close();
	}
	
	public static void updateCouponTitle(String title, long id) throws SQLException{
		
		if(!DataVerification.couponIdExistance(id))
			throw new SQLException(DataVerification.COUPON_ID_EXCEPTION);
		
		String query = "UPDATE CouponsTesting.Coupons "
				+ "SET Title = ? "
				+ "WHERE CouponId = ?";
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, title);
		preparedStatement.setLong(2, id);
		preparedStatement.executeUpdate();
		
		connection.close();
		preparedStatement.close();
	}
	
	public static void updateCouponStartDate(long time, long id) throws SQLException{
		
		if(!DataVerification.couponIdExistance(id))
			throw new SQLException(DataVerification.COUPON_ID_EXCEPTION);
		
		String query = "SELECT EndDate FROM CouponsTesting "
				+ "WHERE CouponId = " + id;
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		
		rs.next();
		if(!DataVerification.dateVerification(new Date(time), rs.getDate(1)))
			throw new DateTimeException(DataVerification.DATE_VERIFICATION_EXCEPTION);
		
		query = "UPDATE CouponsTesting.Coupons "
				+ "SET StartDate = ? "
				+ "WHERE CouponId = ?";
		
		preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setDate(1, new Date(time));
		preparedStatement.setLong(2, id);
		preparedStatement.executeUpdate();
		
		connection.close();
		preparedStatement.close();
	}
	
	public static void updateCouponStartDate(Date time, long id) throws SQLException{
		
		if(!DataVerification.couponIdExistance(id))
			throw new SQLException(DataVerification.COUPON_ID_EXCEPTION);
		
		String query = "SELECT EndDate FROM CouponsTesting "
				+ "WHERE CouponId = " + id;
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		
		rs.next();
		if(!DataVerification.dateVerification(time, rs.getDate(1)))
			throw new DateTimeException(DataVerification.DATE_VERIFICATION_EXCEPTION);
		
		query = "UPDATE CouponsTesting.Coupons "
				+ "SET StartDate = ? "
				+ "WHERE CouponId = ?";
		
		preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setDate(1, time);
		preparedStatement.setLong(2, id);
		
		connection.close();
		preparedStatement.close();
	}
	
	public static void updateCouponEndDate(long time, long id) throws SQLException{
		
		if(!DataVerification.couponIdExistance(id))
			throw new SQLException(DataVerification.COUPON_ID_EXCEPTION);
		
		String query = "SELECT StartDate FROM CouponsTesting "
				+ "WHERE CouponId = " + id;
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		
		rs.next();
		if(!DataVerification.dateVerification(rs.getDate(1), new Date(time)))
			throw new DateTimeException(DataVerification.DATE_VERIFICATION_EXCEPTION);
		
		query = "UPDATE CouponsTesting.Coupons "
				+ "SET EndDate = ? "
				+ "WHERE CouponId = ?";
		
		preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setDate(1, new Date(time));
		preparedStatement.setLong(2, id);
		
		connection.close();
		preparedStatement.close();
	}
	
	public static void updateCouponEndDate(Date time, long id) throws SQLException{
		
		if(!DataVerification.couponIdExistance(id))
			throw new SQLException(DataVerification.COUPON_ID_EXCEPTION);
		
		String query = "SELECT StartDate FROM CouponsTesting "
				+ "WHERE CouponId = " + id;
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		
		rs.next();
		if(!DataVerification.dateVerification(rs.getDate(1), time))
			throw new DateTimeException(DataVerification.DATE_VERIFICATION_EXCEPTION);
		
		query = "UPDATE CouponsTesting.Coupons "
				+ "SET EndDate = ? "
				+ "WHERE CouponId = ?";
		
		preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setDate(1, time);
		preparedStatement.setLong(2, id);
		
		connection.close();
		preparedStatement.close();
	}
	
	public static void updateCouponAmount(int amount, long id) throws SQLException{
		
		if(!DataVerification.couponIdExistance(id))
			throw new SQLException(DataVerification.COUPON_ID_EXCEPTION);
		if(DataVerification.numberIsNegative(amount))
			throw new ArithmeticException(DataVerification.NEGATIVE_NUMBER_EXCEPTION);
		
		String query = "UPDATE CouponsTesting.Coupons "
				+ "SET Amount = ? "
				+ "WHERE CouponId = ?";
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setInt(1, amount);
		preparedStatement.setLong(2, id);
		
		connection.close();
		preparedStatement.close();
	}
	
	public static void updateCouponType(CouponType type, long id) throws SQLException{
		
		if(!DataVerification.couponIdExistance(id))
			throw new SQLException(DataVerification.COUPON_ID_EXCEPTION);
		
		String query = "UPDATE CouponsTesting.Coupons "
				+ "SET Type = ? "
				+ "WHERE CouponId = ?";
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, type.name());
		preparedStatement.setLong(2, id);
		
		connection.close();
		preparedStatement.close();
	}
	
	public static void updateCouponMessage(String message, long id) throws SQLException{
		
		if(!DataVerification.couponIdExistance(id))
			throw new SQLException(DataVerification.COUPON_ID_EXCEPTION);
		
		String query = "UPDATE CouponsTesting.Coupons "
				+ "SET Message = ? "
				+ "WHERE CouponId = ?";
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, message);
		preparedStatement.setLong(2, id);
		
		connection.close();
		preparedStatement.close();
	}
	
	public static void updateCouponPrice(double price, long id) throws SQLException{
		
		if(!DataVerification.couponIdExistance(id))
			throw new SQLException(DataVerification.COUPON_ID_EXCEPTION);
		if(DataVerification.numberIsNegative(price))
			throw new ArithmeticException(DataVerification.NEGATIVE_NUMBER_EXCEPTION);
		
		String query = "UPDATE CouponsTesting.Coupons "
				+ "SET Price = ? "
				+ "WHERE CouponId = ?";
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setDouble(1, price);
		preparedStatement.setLong(2, id);
		
		connection.close();
		preparedStatement.close();
	}
	
	public static void updateCouponImage(String url, long id) throws SQLException{
		
		if(!DataVerification.couponIdExistance(id))
			throw new SQLException(DataVerification.COUPON_ID_EXCEPTION);
		
		String query = "UPDATE CouponsTesting.Coupons "
				+ "SET Image = ? "
				+ "WHERE CouponId = ?";
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, url);
		preparedStatement.setLong(2, id);
		
		connection.close();
		preparedStatement.close();
	}
}

















