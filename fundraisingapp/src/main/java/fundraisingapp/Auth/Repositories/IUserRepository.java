package fundraisingapp.Auth.Repositories;

import fundraisingapp.Auth.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUserRepository extends CrudRepository<User,String> {
    List<User> findAll();
    User findByEmail(String email);
}
