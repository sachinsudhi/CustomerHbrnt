package trng.hibernat.service;

import trng.hibernat.Entity.Order;
import trng.hibernat.dao.OrderDao;
import trng.hibernat.dao.OrderDaoImplementation;

public class OrderServiceImplementation implements OrderService{
	OrderDao odao;
	public OrderServiceImplementation() {
		odao=new OrderDaoImplementation();
	}
	@Override
	public boolean createOrder(Order order) {
		return odao.createOrder(order);
	}

	@Override
	public boolean deleteOrder(Long orderId) {
		return odao.deleteOrder(orderId);
	}

	@Override
	public boolean updateOrder(Order order) {
		return odao.updateOrder(order);
	}

	@Override
	public Order getOrder(Order order) {
		return odao.getOrder(order);
	}
	
}