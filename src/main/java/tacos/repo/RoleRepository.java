package tacos.repo;

import org.springframework.data.repository.CrudRepository;
import tacos.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);
}
