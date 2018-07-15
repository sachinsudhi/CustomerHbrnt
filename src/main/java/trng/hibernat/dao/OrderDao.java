package trng.hibernat.dao;

import trng.hibernat.Entity.Orders;

public interface OrderDao {
	boolean createOrder(Orders order);

	boolean deleteOrder(Long orderId);

	boolean updateOrder(Orders order);

	Orders getOrder(Orders order);
}
