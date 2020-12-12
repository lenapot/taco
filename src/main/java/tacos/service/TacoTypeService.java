package tacos.service;

import org.springframework.data.domain.Page;
import tacos.Taco;
import tacos.TacoType;
import tacos.User;

public interface TacoTypeService {

    TacoType saveTacoType(TacoType tacoType);
//    Page<Order> getOrdersByUser(User user, int pageNum);
//    Page<Order> getOrdersByUser(User user);
//    Page<Order> getAllOrders(int pageNum);
    TacoType getTacoType(long tacoId);
    Page<TacoType> getTacoTypesByUser(User user, int pageNum);
//    void updateOrderStatus(Order order);
}
