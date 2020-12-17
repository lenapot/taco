package tacos.service;

import org.springframework.data.domain.Page;
import tacos.domain.Order;
import tacos.vo.OrderVo;
import tacos.domain.User;

import java.util.List;

public interface OrderService {

    Order saveOrder(Order order);
    Page<OrderVo> getOrdersByUser(User user, int pageNum);
    List<Order> getOrdersByUser(User user);
    Page<OrderVo> getAllOrders(int pageNum);
    Order getOrder(Long orderId);
    void updateOrderStatus(Order order);
    String getTacosWithCountInStr(Long orderId);
}
