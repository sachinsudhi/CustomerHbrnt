package trng.hibernat.service;

import trng.hibernat.Entity.Order;

public interface OrderService {
	boolean createOrder(Order order);

	boolean deleteOrder(Long orderId);

	boolean updateOrder(Order order);

	Order getOrder(Order order);
}
