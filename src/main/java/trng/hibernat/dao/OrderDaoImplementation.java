package trng.hibernat.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import trng.hibernat.Entity.Orders;
import trng.hibernat.utils.HibernateUtils;

public class OrderDaoImplementation implements OrderDao{
	SessionFactory sf;
	final static Logger logger = Logger.getLogger(CustomerDaoImplementation.class);
	
	public OrderDaoImplementation() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public boolean createOrder(Orders order) {
		logger.debug("Executing OrderDao::addOrder API" + order.getOrderID());
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(order);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception here");
			logger.error("failed to execute addOrder method", e);
			return false;
		}
		session.close();
		System.out.println("Insert completed");
		logger.debug("Completed executing OrderDao::addOrder API");
		return true;
	}

	@Override
	public boolean deleteOrder(Long orderId) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();
		try {
			Orders order = (Orders) session.load(Orders.class, orderId);
			session.delete(order);
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("failed to execute deleteOrder method", e);
			return false;
		}
		session.close();
		return true;
	}

	@Override
	public boolean updateOrder(Orders order) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();
		try {
			session.update(order);
			session.getTransaction().commit();
		} catch (Exception e) {
			logger.error("failed to execute updateOrder method", e);
			return false;
		}
		session.close();
		return true;
	}

	@Override
	public Orders getOrder(Orders order) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();
        int orderId=order.getOrderID();
		Query query = session.createQuery("FROM ORDER where orderID=:ord");
		query.setParameter("ord", orderId);
		@SuppressWarnings("unchecked")
		List<Orders> ordersList = query.list();

		session.getTransaction().commit();
		session.close();

		if (ordersList != null && ordersList.size() > 0) {
			return ordersList.get(0);
		}
		return null;
	}
	
}