package tacos.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import tacos.Order;
import tacos.Taco;
import tacos.User;

public interface TacoRepository extends CrudRepository<Taco, Long> {

    Page<Taco> findTacosBy(User user, Pageable pageable);

}
