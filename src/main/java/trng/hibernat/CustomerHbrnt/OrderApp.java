package trng.hibernat.CustomerHbrnt;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import trng.hibernat.Entity.Order;
import trng.hibernat.service.OrderService;
import trng.hibernat.service.OrderServiceImplementation;
import trng.hibernat.utils.HibernateUtils;

public class OrderApp {
	OrderService oserv;
	static Scanner scanner;

	public OrderApp() {
		oserv = new OrderServiceImplementation();
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
		System.out.println("\nEnter customer ID:\n");
		int cid = scanner.nextInt();
		System.out.println("\nEnter order ID:\n");
		int oid = scanner.nextInt();
		System.out.println("\nEnter order message:\n");
		String message = scanner.next();
		Date d = Calendar.getInstance().getTime();
		Order ord = new Order(oid, cid, d, d, d, message);
		oserv.createOrder(ord);	
	}

	public void removeOrder() {
		System.out.println("\nEnter order Id of the order to be deleted:\n");
		Long oid = (long) scanner.nextInt();
		oserv.deleteOrder(oid);
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
		Order ord = new Order(oid, cid, d, d, d, message);
		boolean result=oserv.updateOrder(ord);
	   if(result)
		   System.out.println("Success");
	   else
		   System.out.println("Failure");
	}

	public void loadOrder() {
		System.out.println("\nEnter order Id of the order to be loaded:\n");
		int oid = scanner.nextInt();
		Order ord=new Order(oid);
		Order o=oserv.getOrder(ord);
		o.toString();
	}
}