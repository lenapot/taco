package tacos.service;

import org.springframework.data.domain.Page;
import tacos.Order;
import tacos.OrderVo;
import tacos.User;

import java.util.List;

public interface OrderService {

    void saveOrder(Order order);
    Page<OrderVo> getOrdersByUser(User user, int pageNum);
    List<Order> getOrdersByUser(User user);
    Page<OrderVo> getAllOrders(int pageNum);
    Order getOrder(Long orderId);
    void updateOrderStatus(Order order);
    String getTacosWithCountInStr(Long orderId);
}
