package Cardao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import Entity.Customer;
import Entity.Lease;
import Entity.Vehicle;
import Exception.CarNotFoundException;
import Exception.CustomerNotFoundException;
import Exception.LeaseNotFoundException;

class cartest {
	
	private ICarLeaseRepositoryImpl carrentalDao;
	
	@BeforeEach
    void setup() {
		carrentalDao = new ICarLeaseRepositoryImpl(); 
    }

	@Test
	void testAddCarSuccessfully()
	{
        Vehicle vehicle = new Vehicle();
        
        vehicle.setVehicleid(58);//primary key
        vehicle.setMake("honda");
        vehicle.setModel("plus");
        vehicle.setYear(2022);
        vehicle.setDailyRate(25.0);
        vehicle.setStatus(1);
        vehicle.setpcapacity(5);
        vehicle.setecapacity(2);

        assertDoesNotThrow(() -> {//doesnot throw any type of error
        	
        carrentalDao.addCar(vehicle);
        });
    }
	
//	@Test
//	void testCreateLeaseSuccess() {
//	    
//	    int vehicleid = 58;//which exist
//	    int customerid = 12;//which exist
//	    String startdate = "2025-04-08";
//	    String enddate = "2025-04-20";
//	    String type = "Daily";
//
//	    Lease lease = carrentalDao.createLease( customerid, vehicleid, startdate, enddate, type);
//
//	    assertNotNull(lease);
//	    assertEquals(vehicleid, lease.getVehicleid());
//	    assertEquals(customerid, lease.getCustomerid());
//	    assertEquals(startdate, lease.getStartdate());
//	    assertEquals(enddate, lease.getEnddate());
//	    assertEquals(type, lease.getType());
//
//	    System.out.println("Lease created: " + lease);
//	}
	
	@Test
	void testCreateLeaseVehicleUnavailable() {
		 

	    //for the vehicle id that doesn't exist
	    Lease lease = carrentalDao.createLease(2001, 9999, "2025-04-15", "2025-04-20", "Daily");

	    assertNull(lease); //table contains unavailablecarss
	}
	
	@Test
    void testReturnCarSuccessful() {
        int leaseId = 2; 
      //lamba functiion which helps to run function without parameters

        assertDoesNotThrow(() -> {
            carrentalDao.returnCar(leaseId);
        });
    }
	
//	@Test
//    void testCustomerNotFoundThrowsException() {
//		assertThrows(CustomerNotFoundException.class, () -> {
//		    carrentalDao.findCustomerById(8888);
//		});
//    }

    @Test
    void testVehicleNotFoundThrowsException() {
        assertThrows(CarNotFoundException.class, () -> {
        	carrentalDao.findCarById(9999); 
        });
    }
//
//    @Test
//    void testLeaseNotFoundThrowsException() {
//        assertThrows(LeaseNotFoundException.class, () -> {
//        carrentalDao.findLeaseById(7777); 
//        });
//    }
    
    void testFindCustomerByIdHandledException()  {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        

        
        Customer customer=null;
		try {
			customer = carrentalDao.findCustomerById(8888);
			
		} catch (CustomerNotFoundException e) {
			
			e.printStackTrace();
		} 

        
        System.setOut(originalOut);

        
        String output = outContent.toString();
        assertTrue(output.contains("Handled Exception: Customer with ID number 8888 does not exist"));
        assertNull(customer); 
    }
    
    @Test
    void testFindLeaseByIdHandledException() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Lease lease=null;
		try {
			lease = carrentalDao.findLeaseById(7777);
		} catch (LeaseNotFoundException e) {
			
			e.printStackTrace();
		} 

        System.setOut(originalOut);
        String output = outContent.toString();

        assertTrue(output.contains("Handled Exception: Lease with ID number 7777 does not exist"));
        assertNull(lease);
    }
    
    


	
	
	
	
	

}
