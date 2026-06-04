package re.ss18.service;



import re.ss18.entity.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(String email);

    List<Order> getMyOrders(String email);

    List<Order> getAllOrders();

    Order updateStatus(Long id, String status);
}