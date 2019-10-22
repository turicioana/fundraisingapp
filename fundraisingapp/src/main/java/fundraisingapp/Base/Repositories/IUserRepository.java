package fundraisingapp.Base.Repositories;

import fundraisingapp.Base.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUserRepository extends CrudRepository<User,String> {
    List<User> findAll();
    User findByEmail(String email);
}
