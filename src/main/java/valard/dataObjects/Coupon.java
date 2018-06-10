package valard.dataObjects;

import java.sql.Date;
import java.util.ArrayList;

import valard.dataOperations.CouponType;

public class Coupon {
	
	public static ArrayList<Coupon> coupons = new ArrayList<>();
	
	private final long couponId;
	private long companyId;
	private String title;
	private Date startDate;
	private Date endDate;
	private int amount;
	private CouponType type;
	private String message;
	private double price;
	private String imgUrl;
	
	public Coupon(long couponId, long companyId, String title, Date startDate, Date endDate,
			int amount, CouponType type, String message, double price, String imgUrl) {
		this.couponId = couponId;
		setAmount(amount);
		setCompanyId(companyId);
		setEndDate(endDate);
		setImgUrl(imgUrl);
		setMessage(message);
		setPrice(price);
		setStartDate(startDate);
		setTitle(title);
		setType(type);
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public CouponType getType() {
		return type;
	}

	public void setType(CouponType type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public long getCouponId() {
		return couponId;
	}

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", companyId=" + companyId + ", title=" + title + ", startDate="
				+ startDate + ", endDate=" + endDate + ", amount=" + amount + ", type=" + type + ", message=" + message
				+ ", price=" + price + ", imgUrl=" + imgUrl + "]";
	}

}

















