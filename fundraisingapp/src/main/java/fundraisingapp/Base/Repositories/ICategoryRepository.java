package fundraisingapp.Base.Repositories;

import fundraisingapp.Base.Model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends CrudRepository<Category,Long> {
    @Query(value = "select * from categories where name = :name", nativeQuery = true)
    Category getCategoryByName(@Param("name")String name);
    List<Category> findAll();
}
