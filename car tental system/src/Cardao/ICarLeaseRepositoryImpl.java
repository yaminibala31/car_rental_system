package Cardao;

import Entity.*;
import Exception.*;
import java.util.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import util.DBConnection;


public class ICarLeaseRepositoryImpl implements ICarLeaseRepository {
	
	public static  Connection con;
	Scanner sc= new Scanner(System.in);
	
	
	public ICarLeaseRepositoryImpl() {
		try {
			con=DBConnection.getConnection();
			System.out.println("connection established");
		}
		catch(Exception e) {
			System.out.println("not connected");
			
		}
	}
	@Override
	public void addCar(Vehicle vehicle) {
		
		int vehicleid=vehicle.getVehicleid();
	    String make=vehicle.getMake();
	    String model=vehicle.getModel();
	    int year=vehicle.getYear();
	    double dailyRate=vehicle.getDailyRate();
	    int available=vehicle.getStatus();
	    int pcapacity=vehicle.getpcapacity();
	    int ecapacity= vehicle.getecapacity();
	    
	    String query = "insert into vehicle (vehicleid,make, model, year, dailyRate, available, pcapacity, ecapacity) values (?,?, ?, ?, ?, ?, ?, ?)";
	    
	    try {
	    	PreparedStatement stat=con.prepareStatement(query);
	    	
            stat.setInt(1,vehicleid );
            stat.setString(2, make);
            stat.setString(3, model);
            stat.setInt(4,year );
            stat.setDouble(5, dailyRate);
            stat.setInt(6, available);
            stat.setInt(7, pcapacity);
            stat.setInt(8,ecapacity);
            stat.executeUpdate();
        } 
	    
	    
	    catch (Exception e) {
            e.printStackTrace();
        }
	    System.out.println("car successfully added");
    
		
	}

	@Override
	public void removeCar(int vehicleid) {
		
		String query="delete from vehicle where vehicleid=?";
		
		try {
			PreparedStatement stat=con.prepareStatement(query);
			
			stat.setInt(1, vehicleid);
	        int rows = stat.executeUpdate();
	        
	        if(rows>0) {
	        	System.out.println("vehicle with id number  "+vehicleid+" removed successfully");
	        	
	        }
	        else {
	        	System.out.println("vehicle not found");
	        }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Vehicle> listAvailableCars() {
		List<Vehicle> availablecars = new ArrayList<>();
		
	    String query = "select * from vehicle where available = 1";

	    try {
	        PreparedStatement stat = con.prepareStatement(query);
	        ResultSet rs = stat.executeQuery();

	        while (rs.next()) {
	            Vehicle v1 = new Vehicle();
	            v1.setVehicleid(rs.getInt("vehicleid"));
	            v1.setMake(rs.getString("make"));
	            v1.setModel(rs.getString("model"));
	            v1.setYear(rs.getInt("year"));
	            v1.setDailyRate(rs.getDouble("dailyRate"));
	            v1.setStatus(rs.getInt("available"));
	            v1.setpcapacity(rs.getInt("pcapacity"));
	            v1.setecapacity(rs.getInt("ecapacity"));

	            availablecars.add(v1);
	        }
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	    }

	    return availablecars;
	}

	@Override
	public List<Vehicle> listRentedCars() {
		List<Vehicle> rentedcars = new ArrayList<>();
		
	    String query = "select * from vehicle where available = 0";

	    try {
	        PreparedStatement stat = con.prepareStatement(query);
	        ResultSet rs = stat.executeQuery();

	        while (rs.next()) {
	        	
	            Vehicle v1 = new Vehicle();
	            v1.setVehicleid(rs.getInt("vehicleid"));
	            v1.setMake(rs.getString("make"));
	            v1.setModel(rs.getString("model"));
	            v1.setYear(rs.getInt("year"));
	            v1.setDailyRate(rs.getDouble("dailyRate"));
	            v1.setStatus(rs.getInt("available"));
	            v1.setpcapacity(rs.getInt("pcapacity"));
	            v1.setecapacity(rs.getInt("ecapacity"));

	            rentedcars.add(v1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return rentedcars;
	}

	@Override
	public List<Vehicle> findCarById(int vehicleid) throws CarNotFoundException {
		List<Vehicle> vehicles = new ArrayList<>();
	    String query = "select * from vehicle where vehicleid = ?";

	    try {
	        PreparedStatement stmt = con.prepareStatement(query);
	        stmt.setInt(1, vehicleid);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) 
	        {
	            Vehicle v2 = new Vehicle();
	            v2.setVehicleid(rs.getInt("vehicleid"));
	            v2.setMake(rs.getString("make"));
	            v2.setModel(rs.getString("model"));
	            v2.setYear(rs.getInt("year"));
	            v2.setDailyRate(rs.getDouble("dailyRate"));
	            v2.setStatus(rs.getInt("available"));
	            v2.setpcapacity(rs.getInt("pcapacity"));
	            v2.setecapacity(rs.getInt("ecapacity"));

	            vehicles.add(v2);
	        } 
	        else 
	        {
	        	throw new CarNotFoundException("vehicle with ID number " + vehicleid + " does not exist");
	        }
	    } 
	    catch(CarNotFoundException e){
	    	throw e;
	    	
	    }
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	        
	    }

	    return vehicles;
		
	}

	@Override
	public void addCustomer(Customer customer) {
		int customerid=customer.getCustomerid();
		String firstname=customer.getFirstname();
	    String lastname=customer.getLastname();
		String email=customer.getEmail();
		String phonenumber=customer.getPhonenumber();
		
		String query="insert into customer(customerid,firstname,lastname,email,phonenumber) values(?,?,?,?,?)";
		
		try {
			PreparedStatement stat= con.prepareStatement(query);
			stat.setInt(1, customerid);
			stat.setString(2, firstname);
			stat.setString(3, lastname);
			stat.setString(4, email);
			stat.setString(5, phonenumber);
			stat.executeUpdate();
		}
		catch (Exception e) {
            e.printStackTrace();
        }
		System.out.println("Customer successfully added");
		
	}

	@Override
	public void removeCustomer(int customerid) {
		String query="delete from customer where customerid=?";
		
		try {
			PreparedStatement stat= con.prepareStatement(query);
			stat.setInt(1, customerid);
			int rows=stat.executeUpdate();
			if(rows>0) {
				System.out.println("customer with ID number  "+customerid+" removed successfully");
	        	
	        }
	        else {
	        	System.out.println("customer not found");
	        }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
			

	@Override
	public List<Customer> listCustomers() {
		List<Customer> cust=new ArrayList<>();
		String query="select * from customer";
		 try {
			 PreparedStatement stat= con.prepareStatement(query);
			 ResultSet rs=stat.executeQuery();
			 
			 while(rs.next()) {
				 Customer c = new Customer();
		            c.setCustomerid(rs.getInt("customerid"));
		            c.setFirstname(rs.getString("firstName"));
		            c.setLastname(rs.getString("lastName"));
		            c.setEmail(rs.getString("email"));
		            c.setPhonenumber(rs.getString("phoneNumber"));
		            
		            cust.add(c);
			 }
			 
		 }
		 catch(SQLException e) {
			 e.toString();
		 }
		 
		
		
		return cust;
	}

	@Override
	public Customer findCustomerById(int customerid) throws CustomerNotFoundException {
		
		String query = "select * from customer where customerid=?";
		
	    Customer customer = null;

	    try {
	        PreparedStatement stat = con.prepareStatement(query);
	        stat.setInt(1, customerid);
	        
	        ResultSet rs = stat.executeQuery();

	        if (rs.next()) {
	            customer = new Customer();
	            
	            customer.setCustomerid(rs.getInt("customerid"));
	            customer.setFirstname(rs.getString("firstName"));
	            customer.setLastname(rs.getString("lastName"));
	            customer.setEmail(rs.getString("email"));
	            customer.setPhonenumber(rs.getString("phoneNumber"));
	            
	            
	            
	        } 
	        
	        else {
	        	
	            throw new CustomerNotFoundException("Customer with ID number " + customerid + " does not exist");
	        }
	        
	        
	    } 
	    catch(CustomerNotFoundException e) {
	    	System.out.println("Handled Exception: " + e.getMessage());
	    	
	    }
	    
	    catch (SQLException e) {
	    	System.err.println("Database error: " + e.getMessage());
	        
	    }

	    return customer;
	}
	public int generateUniqueLeaseID() {
	    int maxID = 0;
	    String query = "select max(leaseid) as maxid from lease";

	    try 
	    {
	    	 Statement st = con.createStatement();
	 	    ResultSet rs = st.executeQuery(query);
	        if (rs.next()) {
	            maxID = rs.getInt("maxid");
	            
	        }
	        
	    } 
	    catch (SQLException e) {
	        e.printStackTrace();
	        
	    }

	    return maxID + 1;
	}
	public void updateCarStatus(int vehicleid, int status) {
	    String query = "update vehicle set available = ? where vehicleid = ?";
	    
	    
	    try (PreparedStatement stat = con.prepareStatement(query)) {
	        stat.setInt(1, status);
	        stat.setInt(2, vehicleid);
	        stat.executeUpdate();
	        
	        
	    } 
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public Lease createLease(int customerid, int vehicleid, String startdate, String enddate, String type)  {
		Lease lease=null;
		
		//if vehicle exist and available
		try {
			List<Vehicle> availablecars =listAvailableCars();
			Vehicle Selectedcars= null;
			
			if (availablecars.isEmpty()) {
	            System.out.println("No vehicles available for lease");
	            return null;
	            
	            
	        }
			
			
			for(Vehicle v1:availablecars) {
				if(v1.getVehicleid()== vehicleid && v1.getStatus()==1) {
					Selectedcars=v1;
					break;
					
				}
				
			}
			if(Selectedcars==null) {
				System.out.println("car is not available or not found");
				return null;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		//if customer exist use them else insert the new customer
		Customer customer = null;
		try {
			customer= findCustomerById(customerid);
		}
		catch(Exception e){
			System.out.println("customer not found. Enter the new Customer details:");
//			
//			System.out.println("Enter customer id:");
//			int custid=sc.nextInt();
//			sc.nextLine();
//			System.out.println("Enter customer firstname:");
//			String firname=sc.nextLine();
//			System.out.println("Enter customer lastname:");
//			String lasname=sc.nextLine();
//			System.out.println("Enter customer email:");
//			String email=sc.nextLine();
//			System.out.println("Enter customer phnnum:");
//			String phonenumber=sc.nextLine();
			
			customer =new Customer(customerid,"new","user","default@","90067");
			addCustomer(customer);
			
			//customerid = custid;
			
			
			
		}
		
		int leaseid= generateUniqueLeaseID();
		String query="insert into lease(leaseid,vehicleid,customerid,startdate,enddate,type) values(?,?,?,?,?,?)";
		try {
			PreparedStatement stat= con.prepareStatement(query); 
			stat.setInt(1, leaseid);
			stat.setInt(2, vehicleid);
            stat.setInt(3, customerid);
            stat.setString(4, startdate);
            stat.setString(5, enddate);
            stat.setString(6, type);
            
            int result=stat.executeUpdate();
            if(result>0) {
            	lease = new Lease(leaseid, vehicleid, customerid, startdate, enddate, type);
                updateCarStatus(vehicleid, 0);//get id from above func and 0 status
                System.out.println("the status is updated");
                System.out.println("lease created with id :  "+leaseid);
                
            }
            
		}
		catch(Exception e) {
        	e.printStackTrace();
        }
		
		return lease;
	}

	@Override
	public void returnCar(int leaseid)  {
		Lease lease = new Lease();
	    ICarLeaseRepositoryImpl carlease = new ICarLeaseRepositoryImpl();

	    try {
	    	String query="select leaseid from lease where leaseid =?";
	        PreparedStatement st = con.prepareStatement(query);
	        st.setInt(1, leaseid);
	        ResultSet rs = st.executeQuery();

	        if (!rs.next()) {///not exist
	            throw new LeaseNotFoundException("lease id not found");
	            
	        }
	        else {
	            // lease details
	        	String leasequery="select * from lease where leaseid = ? ";
	        	
	        	PreparedStatement stat = con.prepareStatement(leasequery);
	        	stat.setInt(1, leaseid);
	            ResultSet set = stat.executeQuery();
	            
	            if (set.next()) {
	                lease.setLeaseid(set.getInt(1));
	                lease.setVehicleid(set.getInt(2));
	                lease.setCustomerid(set.getInt(3));
	                lease.setStartdate(set.getDate(4).toString());
	                lease.setEnddate(set.getDate(5).toString());
	                lease.setType(set.getString(6)); // if lease_type column exists
	            }

//	            // Set car as available
//	            Statement stam = con.createStatement();
//	            stam.executeUpdate("update vehicle set available = 1 WHERE vehicleid = " + lease.getVehicleid());
	            
	            updateCarStatus(lease.getVehicleid(), 1);//change status into available after returning

	            // Update end date if returned earlier
	            LocalDate curDate = LocalDate.now();
	            String currentDate = curDate.toString();

	            if (!currentDate.equals(lease.getEnddate())) {
	                java.sql.Date sqlEndDate = java.sql.Date.valueOf(curDate);
	                Statement stmtd = con.createStatement();
	                stmtd.executeUpdate("update lease set enddate = '" + currentDate + "' where leaseid = " + leaseid);
	                lease.setEnddate(currentDate);
	            }

	            // Get daily rate from vehicle table
	            Statement stmte = con.createStatement();
	            ResultSet rateSet = stmte.executeQuery("select dailyrate from vehicle where vehicleid = " + lease.getVehicleid());
	            double dailyRate = 0;
	            if (rateSet.next()) {
	                dailyRate = rateSet.getDouble(1);
	            }

	            // Calculate amount = days * dailyRate
	            LocalDate start = LocalDate.parse(lease.getStartdate());
	            LocalDate end = LocalDate.parse(lease.getEnddate());
	            long days = ChronoUnit.DAYS.between(start, end);//more return more num of days
	            double amount = days * dailyRate;

	            // Record the payment
	            carlease.recordPayment(lease, amount);
	        }

	    } 
	    
	    
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	}

	@Override
	public List<Lease> listActiveLeases() {
		List<Lease> activeleases=new ArrayList<>();
		String query="select * from lease where enddate > CURDATE()";
		
		try {
			PreparedStatement stat= con.prepareStatement(query);
			ResultSet rs=stat.executeQuery();
			
			while (rs.next()) {
				Lease l = new Lease();
				l.setLeaseid(rs.getInt("leaseid"));
				l.setCustomerid(rs.getInt("customerid"));
				l.setVehicleid(rs.getInt("vehicleid"));
				l.setStartdate(rs.getString("startdate"));
				l.setEnddate(rs.getString("enddate"));
				l.setType(rs.getString("type"));
	            activeleases.add(l);
			}
			
			if (activeleases.isEmpty()) {
	            System.out.println("No active leases found.");
	        }
		}
		catch (SQLException e) {
		        e.printStackTrace();
		}

		return activeleases;
	}

	@Override
	public List<Lease> listLeaseHistory() {
		List<Lease> leasehistory= new ArrayList<>();
		String query="select * from lease where enddate < CURRENT_DATE";
		try{
			PreparedStatement stat= con.prepareStatement(query);
			ResultSet rs= stat.executeQuery();
			
			while(rs.next()) {
				Lease l = new Lease();
				l.setLeaseid(rs.getInt("leaseid"));
				l.setCustomerid(rs.getInt("customerid"));
				l.setVehicleid(rs.getInt("vehicleid"));
				l.setStartdate(rs.getString("startdate"));
				l.setEnddate(rs.getString("enddate"));
				l.setType(rs.getString("type"));
		            leasehistory.add(l);
			}
			
		}
		
		catch (SQLException e) {
	        e.printStackTrace();
	    }

	return leasehistory;
	}
	
	
	public Lease findLeaseById(int leaseID)throws LeaseNotFoundException {
	    Lease lease = null;
	    String query = "select * from Lease where leaseid = ?";
	    try {
	        PreparedStatement stmt = con.prepareStatement(query);
	        stmt.setInt(1, leaseID);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	        	lease  = new Lease();
	        	lease.setLeaseid(rs.getInt("leaseid"));
	        	lease.setCustomerid(rs.getInt("customerid"));
	        	lease.setVehicleid(rs.getInt("vehicleid"));
	        	lease.setStartdate(rs.getString("startdate"));
	        	lease.setEnddate(rs.getString("enddate"));
	        	lease.setType(rs.getString("type"));
	        }
	        
            else {
	        	
	            throw new LeaseNotFoundException("Lease with ID number " + leaseID + " does not exist");
	        }
	    }
	    catch (LeaseNotFoundException e) {
	    	System.out.println("Handled Exception: " + e.getMessage()); // Rethrow so test can catch it
	    }
	       catch (Exception e) {
	        e.printStackTrace(); // Or handle SQL or others
	    }
	    
	        
	   
	    return lease;
	}


	@Override
	public void recordPayment(Lease lease, double amount) {
		try {
	        //Calculate number of days
	        Statement st = con.createStatement();
	        ResultSet set = st.executeQuery(
	            "select DATEDIFF(CURDATE(), (select startdate from lease where leaseid = " + lease.getLeaseid() + "))"
	        );

	        set.next();
	        int numberdays = set.getInt(1);

	        //Calculate total amount
	        double totalAmount = amount * numberdays;
	        System.out.println("Amount to be Paid: " + totalAmount);

	        //Insert payment record
	        String query = "insert into payment (leaseid, transactiondate, amount) values (?, ?, ?)";
	        PreparedStatement pst = con.prepareStatement(query);
	        pst.setInt(1, lease.getLeaseid());
	        pst.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now())); // current date
	        pst.setDouble(3, totalAmount);

	        int rowsInserted = pst.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("Payment recorded successfully.");
	        } else {
	            System.out.println("Payment insertion failed.");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	}
	
	

}
