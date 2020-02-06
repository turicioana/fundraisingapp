package fundraisingapp.Base.Repositories;

import fundraisingapp.Base.Model.Company;
import fundraisingapp.Base.Model.Image;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImageRepository extends CrudRepository<Image, Long> {
    @Query(value = "select * from images i join images_fundraisers if on i.id = if.image_id " +
            "where if.fundraiser_id = :id", nativeQuery = true)
    List<Image> getImagesByFundraiserId(@Param("id")Long id);
}
