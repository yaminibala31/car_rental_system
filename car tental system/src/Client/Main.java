package Client;

import Cardao.ICarLeaseRepository;
import Cardao.ICarLeaseRepositoryImpl;
import Entity.*;
import java.util.Scanner;
import Exception.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		ICarLeaseRepositoryImpl crep= new ICarLeaseRepositoryImpl();
		Scanner sc = new Scanner(System.in);
//		Vehicle v1=new Vehicle(14,"mini","cupper",2003,35.00,1,5,1600);
//		
//		crep.addCar(v1);
		//crep.removeCar(11);
//		List<Vehicle> cars = crep.listAvailableCars();
//		for (Vehicle v : cars) {
//		    System.out.println(v.getVehicleid() + " - " + v.getMake() + " " + v.getModel());
//		}
//		List<Vehicle> rentedcars = crep.listRentedCars();
//		for (Vehicle v : rentedcars) {
//		    System.out.println(v.getVehicleid() + " - " + v.getMake() + " " + v.getModel());
//		}
		
//		//List<Vehicle> findcars = crep.findCarById(4)throws Exception;
//		try {
//		    List<Vehicle> findcars = crep.findCarById(4);
//		    if (findcars.size() == 0) {
//		        System.out.println("Car not found.");
//		    } else {
//		        for (Vehicle v : findcars) {
//		            System.out.println(v.toString());
//		        }
//		    }
//		} //catch (CarNotFoundException e) {
//		   // System.out.println("Custom Exception: " + e.getMessage());
//		    //e.printStackTrace();
//		//}
//		catch (Exception e) {
//		    System.out.println("Something went wrong.");
//		    e.printStackTrace();
//		}
		
//		Customer c1=new Customer(12,"pooorani","bala","pooorani@gmail.com","9360448906");
//		crep.addCustomer(c1);
//
   //     }
//		int id = crep.generateUniqueLeaseID();
//		System.out.println("Next Lease ID (preview): " + id);
//		Lease lease = crep.createLease(202, 101, "2025-04-05", "2025-04-10", "Daily");
//		if (lease != null) {
//		    System.out.println("Lease created:\n" + lease.toString());
//		} else {
//		    System.out.println("Lease not created");
//		}
//		try {
//            // Call returnCar with an existing lease ID
//            Lease returnedLease = crep.returnCar(4); // Replace 101 with a valid lease ID from your DB
//
//            if (returnedLease != null) {
//                System.out.println(" Car returned successfully for Lease ID: " + returnedLease.getLeaseid());
//            } else {
//                System.out.println("Lease not found or return failed.");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//		try {
//		    List<Lease> historyLeases = crep.listLeaseHistory();
//
//		    if (historyLeases.isEmpty()) {
//		        System.out.println(" No lease history found (no past leases).");
//		    } else {
//		        System.out.println("Lease History:");
//		        for (Lease lease : historyLeases) {
//		            System.out.println(lease.toString());
//		        }
//		    }
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}
//		Lease lease = crep.findLeaseById(5);
//		if (lease != null) {
//		    crep.recordPayment(lease, 7500.0);
//		} else {
//		    System.out.println("Lease not found.");
//		}
		int choice;

        do {
            System.out.println(".. car rental menu ..");
            System.out.println("1. Add Car");
            System.out.println("2. Remove Car");
            System.out.println("3. List Available Cars");
            System.out.println("4. List Rented Cars");
            System.out.println("5. Find Car by ID");
            System.out.println("6. Add Customer");
            System.out.println("7. Remove Customer");
            System.out.println("8. List All Customers");
            System.out.println("9. Find Customer by ID");
            System.out.println("10. Create Lease");
            System.out.println("11. Return Car");
            System.out.println("12. List Active Leases");
            System.out.println("13. Lease History");
            System.out.println("14. Find Lease by ID");
            System.out.println("15. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1: 
                    System.out.print("enter vehicle ID: ");
                    int vid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("enter make: ");
                    String make = sc.nextLine();
                    System.out.print("enter model: ");
                    String model = sc.nextLine();
                    System.out.print("enter year:");
                    int year = sc.nextInt();
                    
                    System.out.print("enter daily rate: ");
                    double rate = sc.nextDouble();
                    System.out.print("is available 1-yes or 0-no ");
                    int status = sc.nextInt();
                    System.out.print("enter passenger capacity: ");
                    int pcap = sc.nextInt();
                    System.out.print("enter engine capacity:");
                    int ecap = sc.nextInt();

                    Vehicle vehicle = new Vehicle(vid, make, model, year, rate, status, pcap, ecap);
                    crep.addCar(vehicle);
                    break;
                    
                    

                case 2:
                	
                    System.out.print("enter vehicle id to remove: ");
                    crep.removeCar(sc.nextInt());
                    break;
                    

                case 3: 
                    System.out.println("available Cars:");
                    
                    crep.listAvailableCars().forEach(System.out::println);
                    break;

                case 4:
                	
                    System.out.println("rented Cars:");
                    crep.listRentedCars().forEach(System.out::println);
                    
                    break;

                case 5: 
                    System.out.print("enter vehicle id to search:");
                    try 
                    {
                        crep.findCarById(sc.nextInt()).forEach(System.out::println);
                    } 
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 6: 
                	
                    System.out.print("enter customer id: ");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("enter first name: ");
                    String fname = sc.nextLine();
                    System.out.print("e last name: ");
                    String lname = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("enter phone number: ");
                    String phone = sc.nextLine();

                    Customer cust = new Customer(cid, fname, lname, email, phone);
                    crep.addCustomer(cust);
                    break;

                case 7: 
                	
                	
                    System.out.print("enter customer id to remove: ");
                    crep.removeCustomer(sc.nextInt());
                    break;

                case 8: 
                	
                    crep.listCustomers().forEach(System.out::println);
                    break;

                case 9: 
                    System.out.print("enter customer id to find: ");
                    try {
                        Customer c = crep.findCustomerById(sc.nextInt());
                        System.out.println(c);
                        
                    } 
                    catch (Exception e) {
                        e.printStackTrace();
                        
                    }
                    
                    break;

                case 10: 
                    System.out.print("enter customer id:");
                    int custid = sc.nextInt();
                    System.out.print("enter vehicle id ");
                    int veid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("enter lease start date (YYYY-MM-DD): ");
                    String sdate = sc.nextLine();
                    System.out.print("enter lease end date (YYYY-MM-DD): ");
                    String edate = sc.nextLine();
                    System.out.print("enter lease type daily /weekly: ");
                    String ltype = sc.nextLine();
                    crep.createLease(custid, veid, sdate, edate, ltype);
                    break;

                case 11: 
                	
                    System.out.print("Enter lease ID to return car: ");
                    crep.returnCar(sc.nextInt());
                    break;

                case 12: 
                	
                    crep.listActiveLeases().forEach(System.out::println);
                    break;

                case 13: 
                    crep.listLeaseHistory().forEach(System.out::println);
                    break;

                case 14: 
                    System.out.print("Enter lease ID: ");
				Lease l = null;
				try {
					l = crep.findLeaseById(sc.nextInt());
				} 
				catch (LeaseNotFoundException e) {
					
					e.printStackTrace();
				}
                    if (l != null) System.out.println(l);
                    else System.out.println("lease not found");
                    break;

                case 15:
                    System.out.println("exist");
                    break;

                
            }

        } while (choice != 0);

        sc.close();
	
		
	

		
		
		
	}
}