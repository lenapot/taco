package tacos.service;

import org.springframework.data.domain.Page;
import tacos.Order;
import tacos.User;

import java.util.List;

public interface OrderService {

    void saveOrder(Order order);
    Page<Order> getOrdersByUser(User user, int pageNum);
    List<Order> getOrdersByUser(User user);
    Page<Order> getAllOrders( int pageNum);
    Order getOrder(long orderId);
    void updateOrderStatus(Order order);
}
