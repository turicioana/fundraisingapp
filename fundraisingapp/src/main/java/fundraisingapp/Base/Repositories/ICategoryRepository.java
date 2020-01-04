package fundraisingapp.Base.Repositories;

import fundraisingapp.Base.Model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends CrudRepository<Category,Long> {
    @Query(value = "select * from categories where title = :title", nativeQuery = true)
    Category getCategoryByName(@Param("title")String title);
}
