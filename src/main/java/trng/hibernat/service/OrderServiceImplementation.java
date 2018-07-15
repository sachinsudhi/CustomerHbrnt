package trng.hibernat.service;

import trng.hibernat.Entity.Orders;
import trng.hibernat.dao.OrderDao;
import trng.hibernat.dao.OrderDaoImplementation;

public class OrderServiceImplementation implements OrderService{
	OrderDao odao;
	public OrderServiceImplementation() {
		odao=new OrderDaoImplementation();
	}
	@Override
	public boolean createOrder(Orders order) {
		return odao.createOrder(order);
	}

	@Override
	public boolean deleteOrder(Long orderId) {
		return odao.deleteOrder(orderId);
	}

	@Override
	public boolean updateOrder(Orders order) {
		return odao.updateOrder(order);
	}

	@Override
	public Orders getOrder(Orders order) {
		return odao.getOrder(order);
	}
	
}