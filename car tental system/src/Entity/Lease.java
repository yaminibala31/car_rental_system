package Entity;

public class Lease {
	private int leaseid;
	private int vehicleid;
	private int customerid;
	private String startdate;
	private String enddate;
	private String type;
	
	public Lease() {
		
	}
	
	public Lease(int leaseid, int vehicleid, int customerid, String startdate, String enddate, String type) {
		super();
		this.leaseid = leaseid;
		this.vehicleid = vehicleid;
		this.customerid = customerid;
		this.startdate=startdate;
		this.type = type;
	}
	public int getLeaseid() {
		return leaseid;
	}
	public void setLeaseid(int leaseid) {
		this.leaseid = leaseid;
	}
	public int getVehicleid() {
		return vehicleid;
	}
	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Lease [leaseid=" + leaseid + ", vehicleid=" + vehicleid + ", customerid=" + customerid + ", startdate="
				+ startdate + ", enddate=" + enddate + ", type=" + type + "]";
	}
	
	

}
