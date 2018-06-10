package valard.dataOperations;

import java.sql.SQLException;

import valard.utils.DataSource;

public final class Delete {
	
	private Delete() {}
	
	public static void deleteCompany(long id) throws SQLException{
		String query = String.format("DELETE FROM CouponsTesting.Companies "
				+ "WHERE CompanyId = %d"
				, id);
		
		DataSource.executeUpdate(query);
	}
	
	public static void deleteCustomer(long id) throws SQLException{
		String query = String.format("DELETE FROM CouponsTesting.Customers "
				+ "WHERE CustomerId = %d"
				, id);
		
		DataSource.executeUpdate(query);
	}
	
	public static void deleteCoupon(long id) throws SQLException{
		String query = String.format("DELETE FROM CouponsTesting.Coupons "
				+ "WHERE CouponId = %d"
				, id);
		
		DataSource.executeUpdate(query);
	}
	
}