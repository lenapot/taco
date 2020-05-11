package tacos.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import tacos.Order;
import tacos.User;

public interface OrderRepository extends CrudRepository<Order, Long> {

    Page<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);

    Page<Order> findAllByOrderByPlacedAtDesc(Pageable pageable);
}
