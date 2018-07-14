package trng.hibernat.dao;

import trng.hibernat.Entity.Customer;
import trng.hibernat.beans.*;

import java.util.List;
import java.util.Map;

public interface CustomerDao {
	boolean addCustomer(Customer customer);

	boolean deleteCustomer(int customerId);

	boolean updateCustomer(Customer customer);

	Customer loadCustomer(int customerId);

	List<Customer> getCustomers(String zipCode); // get all customers who's in the zip code. (User Query API)

	Map<String, Double> getMonthlySales(int year);// get monthly sales in the given year.

	List<ReportBean> getReport(int month);// get the report informaton (CustomerId, CustomerName, Total Order Price)
											// order by Total Order Price desc.

}
