package trng.hibernat.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import trng.hibernat.utils.HibernateUtils;
import trng.hibernat.Entity.Customer;
import trng.hibernat.beans.*;

public class CustomerDaoImplementation implements CustomerDao {
	SessionFactory sf;
	final static Logger logger = Logger.getLogger(CustomerDaoImplementation.class);
	public CustomerDaoImplementation() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public boolean addCustomer(Customer customer) {
		logger.debug("Executing CustomerDao::addCustomer API" + customer.getCustomerID());
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.save(customer);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("failed to execute addCustomer method", e);
			return false;
		}
		session.close();
		logger.debug("Completed executing CustomerDao::addCustomer API");
		return true;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();
		try {
			Customer customer = (Customer) session.load(Customer.class, customerId);
			session.delete(customer);
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("failed to execute deleteCustomer method", e);
			return false;
		}
		session.close();
		return true;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();
		try {
			session.update(customer);
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("failed to execute updateCustomer method", e);
			return false;
		}
		session.close();
		return true;
	}

	@Override
	public Customer loadCustomer(int customerId) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();
		Customer customer;
		try {
			customer = (Customer) session.get(Customer.class, customerId);
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("failed to execute loadCustomer method", e);
			return null;
		}
		session.close();
		return customer;
	}

	@Override
	public List<Customer> getCustomers(String zipCode) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		Query query = session.createQuery("FROM Customer as c where c.address.billingZIP=:zip");
		query.setParameter("zip", zipCode);
		@SuppressWarnings("unchecked")
		List<Customer> customersList = query.list();

		session.getTransaction().commit();
		
		session.close();

		if (customersList != null && customersList.size() > 0) {
			return customersList;
		}
		return null;
	}

	@Override
	public Map<String, Double> getMonthlySales(int year) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();

		Query query = session.createQuery("select month(o.paymentDueDate) , SUM(op.quantity*op.price) FROM Orders as o, OrderProducts as op where o.orderID=op.orderId and year(o.paymentDueDate) =:yr group by month(o.paymentDueDate)");
		query.setParameter("yr", year);
		List<List<Object>> listOfSales=query.setResultTransformer(Transformers.TO_LIST).list();
		Map<String, Double> monthlySales=new HashMap<>();
		for(List<Object> l:listOfSales) {
			monthlySales.put((l.get(0)).toString(), (Double)l.get(1));
		}
		if(monthlySales==null || monthlySales.size()==0)
			System.out.println("No such customer exists in the datastore");
		session.getTransaction().commit();
		session.close();
         
			return monthlySales;
	}

	@Override
	public List<ReportBean> getReport(int month) {
		sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        
        Query query =  session.createQuery("select new trng.hibernat.beans.ReportBean(c.customerID, c.firstName, op.quantity, op.price) from Customer as c,Orders as o, OrderProducts as op where c.customerID=o.customerId and o.orderID=op.orderId and month(o.paymentDueDate)=:mnth order by month(o.paymentDueDate)");
        query.setParameter("mnth", month);
        List<ReportBean> reportBeans = query.list();

        session.close();
        	System.out.println("Report sent");
             return reportBeans;
	}

}