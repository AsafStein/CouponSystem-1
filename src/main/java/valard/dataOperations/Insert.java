package valard.dataOperations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DateTimeException;

import valard.dataObjects.Company;
import valard.dataObjects.Coupon;
import valard.dataObjects.Customer;
import valard.utils.DataSource;
import valard.utils.DataVerification;
import valard.utils.DateUtil;

public final class Insert {
	
	private Insert() {}
	
	public static void insertCompany(final String name, final String password, final String email) throws SQLException {
		
		if(!DataVerification.emailVerification(email))
			throw new IllegalArgumentException(DataVerification.EMAIL_EXCEPTION);
		
		String query = String.format("INSERT INTO CouponsTesting.Companies("
				+ "CompanyName, Password, Email)"
				+ "VALUES('%s', '%s', '%s')", name, password, email);
		DataSource.executeUpdate(query);
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs;
		
		query = String.format("SELECT CompanyId FROM CouponsTesting.Companies "
				+ "WHERE CompanyName = '%s' AND Password = '%s' AND Email = '%s'", name, password, email);
		rs = preparedStatement.executeQuery(query);
		
		rs.next();
		Company.companies.add(new Company(rs.getLong(1), name, password, email));
		
		connection.close();
		preparedStatement.close();
		rs.close();
	}
	
	public static void insertCustomer(final String name, final String password) throws SQLException {
		String query = String.format("INSERT INTO CouponsTesting.Customers("
				+ "CustomerName, Password)"
				+ "VALUES('%s', '%s')", name, password);
		
		DataSource.executeUpdate(query);
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs;
		
		query = String.format("SELECT CustomerId FROM CouponsTesting.Customers "
				+ "WHERE CustomerName = '%s' AND Password = '%s'", name, password);
		rs = preparedStatement.executeQuery(query);
		
		rs.next();
		Customer.customers.add(new Customer(rs.getLong(1), name, password));
		
		connection.close();
		preparedStatement.close();
		rs.close();
	}
	
	public static void insertCoupon(long companyId, String title, long endDate, int amount,
			CouponType type, String message, int price, String imgUrl) throws SQLException {
		
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
		
		String query = "INSERT INTO CouponsTesting.Coupons("
				+ "CompanyId, Title, StartDate, EndDate, Amount, Type, Message, Price, Image)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet rs;
		
		preparedStatement.setLong(1, companyId);
		preparedStatement.setString(2, title);
		preparedStatement.setDate(3, start);
		preparedStatement.setDate(4, end);
		preparedStatement.setInt(5, amount);
		preparedStatement.setString(6, type.name());
		preparedStatement.setString(7, message);
		preparedStatement.setInt(8, price);
		preparedStatement.setString(9, imgUrl);
		preparedStatement.executeUpdate();
		
		query = "SELECT CouponId FROM CouponsTesting.Coupons "
				+ "WHERE CompanyId = ? AND Title = ? AND StartDate = ? AND EndDate = ? AND "
				+ "Amount = ? AND Type = ? AND Message = ? AND Price = ? AND Image = ?";
		
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, companyId);
		preparedStatement.setString(2, title);
		preparedStatement.setDate(3, start);
		preparedStatement.setDate(4, end);
		preparedStatement.setInt(5, amount);
		preparedStatement.setString(6, type.name());
		preparedStatement.setString(7, message);
		preparedStatement.setDouble(8, price);
		preparedStatement.setString(9, imgUrl);
		rs = preparedStatement.executeQuery();
		
		rs.next();
		Coupon.coupons.add(new Coupon(rs.getLong(1), companyId, title, start, end, amount, type, message, price, imgUrl));
		
		connection.close();
		preparedStatement.close();
		rs.close();
	}
	
}












