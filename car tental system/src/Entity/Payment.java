 package Entity;

public class Payment {
	private int paymentid;
	private int leaseid;
	private String date;
	private double amount;
	
	public Payment(int paymentid, int leaseid, String date, double amount) {
		super();
		this.paymentid = paymentid;
		this.leaseid = leaseid;
		this.date=date;
		this.amount = amount;
	}
	
	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}
	public int getLeaseid() {
		return leaseid;
	}
	public void setLeaseid(int leaseid) {
		this.leaseid = leaseid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	

}
