package fundraisingapp.Auth.Repositories;

import fundraisingapp.Auth.Model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IRoleRepository extends CrudRepository<Role,Long> {
    List<Role> findAll();
    Role findByName(String name);
}
