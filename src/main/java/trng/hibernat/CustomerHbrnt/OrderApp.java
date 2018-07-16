package trng.hibernat.CustomerHbrnt;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import trng.hibernat.Entity.Customer;
import trng.hibernat.Entity.OrderProducts;
import trng.hibernat.Entity.Orders;
import trng.hibernat.service.CustomerService;
import trng.hibernat.service.CustomerServiceImplementation;
import trng.hibernat.service.OrderService;
import trng.hibernat.service.OrderServiceImplementation;
import trng.hibernat.utils.HibernateUtils;

public class OrderApp {
	OrderService oserv;
	CustomerService cserv;
	static Scanner scanner;

	public OrderApp() {
		oserv = new OrderServiceImplementation();
		cserv=new CustomerServiceImplementation();
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		OrderApp capp = new OrderApp();
		while (true) {
			HibernateUtils.displayOrderMenu();
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				capp.insertOrder();
				break;

			case 2:
				capp.removeOrder();
				break;
			case 3:
				capp.changeOrder();
				break;
			case 4:
				capp.loadOrder();
				break;

			default:
				scanner.close();
				System.exit(0);
				break;

			}
		}
	}

	public void insertOrder() {
		System.out.println("\nEnter Customer order details:\n");
		System.out.println("\nEnter order message:\n");
		String message = scanner.next();
		Date d = Calendar.getInstance().getTime();
		Customer c=new Customer();
		cserv.addCustomer(c);
		Orders ord = new Orders(c.getCustomerID(),d, d, d, message);
		boolean result=oserv.createOrder(ord);	
		if(result)
			   System.out.println("Success");
		   else
			   System.out.println("Failure");
	}

	public void removeOrder() {
		System.out.println("\nEnter order Id of the order to be deleted:\n");
		Long oid = (long) scanner.nextInt();
		boolean result=oserv.deleteOrder(oid);
		if(result)
			   System.out.println("Success");
		   else
			   System.out.println("Failure");
	}

	public void changeOrder() {
		System.out.println("\nEnter Customer order details:\n");
		System.out.println("\nEnter customer ID:\n");
		int cid = scanner.nextInt();
		System.out.println("\nEnter order ID:\n");
		int oid = scanner.nextInt();
		System.out.println("\nEnter order message:\n");
		String message = scanner.next();
		Date d = Calendar.getInstance().getTime();
		Orders ord = new Orders(cid, d, d, d, message);
		ord.setOrderID(oid);
		boolean result=oserv.updateOrder(ord);
	   if(result)
		   System.out.println("Success");
	   else
		   System.out.println("Failure");
	}

	public void loadOrder() {
		System.out.println("\nEnter order Id of the order to be loaded:\n");
		int oid = scanner.nextInt();
		Orders ord=new Orders(oid);
		Orders o=oserv.getOrder(ord);
		System.out.println("Order message: "+o.getCustomMessage());
	}
}