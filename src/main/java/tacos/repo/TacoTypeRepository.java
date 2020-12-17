package tacos.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import tacos.domain.Taco;
import tacos.domain.TacoType;
import tacos.domain.User;

public interface TacoTypeRepository extends CrudRepository<TacoType, Long> {

    Page<Taco> findTacosBy(User user, Pageable pageable);

}
