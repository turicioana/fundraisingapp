package fundraisingapp.Auth.Repositories;

import fundraisingapp.Auth.Model.Privilege;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPrivilegeRepository extends CrudRepository<Privilege,Long> {
    List<Privilege> findAll();
    Privilege findByName(String name);
}
