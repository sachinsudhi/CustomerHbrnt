package trng.hibernat.dao;

import java.util.List;
import java.util.Map;

import trng.hibernat.Entity.Customer;
import trng.hibernat.beans.*;

public class CustomerDaoImplementation implements CustomerDao{

	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer loadCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomers(String zipCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> getMonthlySales(int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReportBean> getReport(int month) {
		// TODO Auto-generated method stub
		return null;
	}
	
}