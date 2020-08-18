package tacos.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tacos.Order;
import tacos.User;

import java.util.List;
import java.util.Map;

public interface OrderRepository extends CrudRepository<Order, Long> {

    Page<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);

    Page<Order> findAllByOrderByPlacedAtDesc(Pageable pageable);

    @Query("select ord.city as city, count(ord.id) as ordCount from Order ord group by ord.city order by ordCount DESC")
//    @Query("select order.city as city, count(order.id) as count from Order order group by order.city")
    List<Map<String, Integer>> getOrdersCountByCities();
}
