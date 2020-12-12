package tacos.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tacos.Order;
import tacos.OrderVo;
import tacos.User;

import java.util.List;
import java.util.Map;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByUserOrderByPlacedAtDesc(User user);

    Page<OrderVo> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);

    Page<OrderVo> findAllByOrderByPlacedAtDesc(Pageable pageable);

    @Query("select ord.city as city, count(ord.id) as ordCount from Order ord group by ord.city order by ordCount DESC")
    List<Map<String, Integer>> getOrdersCountByCities();

    @Query(value = "select new tacos.OrderVo(ord.id, ord.name, concat(ord.state, ' ',  ord.city, ' ', ord.street), " +
            "ord.placedAt) \n" +
            "from Order ord\n" +
            "order by ord.placedAt DESC")
    List<OrderVo> getOrdersByMonth();

    @Query(value = "select taco.tacotype.name as tacotype, count(taco.id) as count " +
            "from Taco taco " +
            "where taco.order.id=:orderId " +
            "group by taco.tacotype.name")
    List<Map<String, Object>> getTacosCountByType(@Param("orderId") Long orderId);
}
