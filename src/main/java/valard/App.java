package valard;

import java.sql.SQLException;

import valard.dataOperations.CouponType;
import valard.dataOperations.DatabaseCreator;
import valard.dataOperations.Insert;
import valard.dataOperations.Select;
import valard.utils.DateUtil;

public class App {
	
    public static void main( String[] args ) {
    	
    	try {
			DatabaseCreator.createDb("CouponsTesting");
			
			long time1 = DateUtil.getNowPlusMonths(3);
			long time2 = DateUtil.getNowPlusMonths(5);
			long time3 = DateUtil.getNowPlusMonths(8);
			long time4 = DateUtil.getNow() + ((DateUtil.getNowPlusMonths(1) - DateUtil.getNow())
					+ (DateUtil.getNowPlusDays(14) - DateUtil.getNow()));
			long time5 = DateUtil.getNowPlusDays(16);
			
			Insert.insertCompany("Google", "d1sf35da1fad", "google@gmail.com");
			Insert.insertCompany("MicroSoft", "dsg1ad35gag", "microsoft@live.com");
			Insert.insertCompany("Intel", "sdf1d35g1", "initel@int.com");
			Insert.insertCompany("Ubisoft", "1adsf3asf15", "Ubi@soft.com");
			Insert.insertCompany("Test", "erb3ae1h5g1sg3", "test@test.com");
			
			Insert.insertCustomer("Nick", "ds15g3s1dh53sdh");
			Insert.insertCustomer("Regev", "sadf3a1f53w");
			Insert.insertCustomer("Chen", "as2dg35s1dg351");
			Insert.insertCustomer("Vlad", "asdf31as51f3ae1f38");
			Insert.insertCustomer("Lida", "1as35g13sa8g13");
			
			Insert.insertCoupon(1, "title1", time1, 250, CouponType.Vacation, "description1", 3500, "www.google.com/imgs/google.jpg");
			Insert.insertCoupon(2, "title2", time2, 450, CouponType.Entertainment, "description2", 4852, "img2");
			Insert.insertCoupon(3, "title3", time3, 35, CouponType.Food, "description3", 3841, "img3");
			Insert.insertCoupon(4, "title4", time4, 1500, CouponType.Electronics, "description4", 1500, "img4");
			Insert.insertCoupon(5, "title5", time5, 351, CouponType.Vacation, "description5", 1381, "img5");
			
//    		Update.updateCompanyEmail("Kolya666kv@gmail.com", 1);
//    		Update.updateCompanyEmail("ABC", 2);
//    		Update.updateCompanyEmail("@ABC.com", 3);
//    		Update.updateCompanyEmail(".@a.a", 4);
//    		Update.updateCompanyEmail("as@as.as", 5);
    		
			Select.selectCompanies();
			System.out.println("-----------------------------------");
			Select.selectCustomers();
			System.out.println("-----------------------------------");
			Select.selectCoupons();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
    	
    }
    
}










