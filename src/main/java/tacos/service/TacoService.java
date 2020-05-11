package tacos.service;

import org.springframework.data.domain.Page;
import tacos.Taco;
import tacos.User;

public interface TacoService {

    Taco saveTaco(Taco taco);
//    Page<Order> getOrdersByUser(User user, int pageNum);
//    Page<Order> getOrdersByUser(User user);
//    Page<Order> getAllOrders(int pageNum);
    Taco getTaco(long orderId);
    Page<Taco> getTacosByUser(User user, int pageNum);
//    void updateOrderStatus(Order order);
}
