package trng.hibernat.service;

import trng.hibernat.Entity.Orders;

public interface OrderService {
	boolean createOrder(Orders order);

	boolean deleteOrder(Long orderId);

	boolean updateOrder(Orders order);

	Orders getOrder(Orders order);
}
