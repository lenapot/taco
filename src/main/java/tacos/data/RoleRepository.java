package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);
}
