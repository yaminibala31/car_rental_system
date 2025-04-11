package Cardao;


import java.util.*;

import Entity.*;
import Exception.CarNotFoundException;
import Exception.CustomerNotFoundException;
import Exception.LeaseNotFoundException;

public interface ICarLeaseRepository {
	// vehicle management
    void addCar(Vehicle vehicle);
    
    void removeCar(int vehicleid);
    List<Vehicle> listAvailableCars();
    
    List<Vehicle> listRentedCars();
    List<Vehicle> findCarById(int vehicleid) throws CarNotFoundException;
    
    //customer management
    
    void addCustomer(Customer customer);
    void removeCustomer(int customerid);
    
    List<Customer> listCustomers();
    Customer findCustomerById(int customerid) throws CustomerNotFoundException;
    
    // lease management
    Lease createLease(int customerid, int vehicleid, String startdate, String enddate, String type);
    
    void returnCar(int leaseID);
    List<Lease> listActiveLeases();
    
    
    List<Lease> listLeaseHistory();
    Lease findLeaseById(int leaseID)throws LeaseNotFoundException;
    
    
    // payment handling
    void recordPayment(Lease lease,double amount);
    


}
