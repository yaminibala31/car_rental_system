package Entity;

public class Vehicle {
	private int vehicleid;
    private String make;
    private String model;
    private int year;
    private double dailyRate;
    private int available;
    private int pcapacity;
    private int ecapacity;
    
    public Vehicle(){
    	
    }
    
    

	public Vehicle(int vehicleid, String make, String model, int year, double dailyRate, int available,
			int pcapacity, int ecapacity) {
		super();
		this.vehicleid = vehicleid;
		this.make = make;
		this.model = model;
		this.year = year;
		this.dailyRate = dailyRate;
		this.available = available;
		this.pcapacity = pcapacity;
		this.ecapacity = ecapacity;
	}
	public int getVehicleid() {
		return vehicleid;
	}
	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getDailyRate() {
		return dailyRate;
	}
	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}
	public int getStatus() {
		return available;
	}
	public void setStatus(int available) {
		this.available = available;
	}
	public int getpcapacity() {
		return pcapacity;
	}
	public void setpcapacity(int pcapacity) {
		this.pcapacity = pcapacity;
	}
	public int getecapacity() {
		return ecapacity;
	}
	public void setecapacity(int ecapacity) {
		this.ecapacity = ecapacity;
	}
	
	public String toString() {
		return "Vehicle [vehicleid=" + vehicleid + ", make=" + make + ", model=" + model + ", year=" + year
				+ ", dailyRate=" + dailyRate + ", available=" + available + ", pcapacity=" + pcapacity + ", ecapacity="
				+ ecapacity + "]";
	}

}
