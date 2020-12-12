package tacos.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import tacos.Taco;
import tacos.TacoType;
import tacos.User;

public interface TacoTypeRepository extends CrudRepository<TacoType, Long> {

    Page<Taco> findTacosBy(User user, Pageable pageable);

}
