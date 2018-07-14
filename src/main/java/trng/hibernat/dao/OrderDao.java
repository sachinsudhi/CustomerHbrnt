package trng.hibernat.dao;

import trng.hibernat.Entity.Order;

public interface OrderDao {
	boolean createOrder(Order order);

	boolean deleteOrder(Long orderId);

	boolean updateOrder(Order order);

	Order getOrder(Order order);
}
