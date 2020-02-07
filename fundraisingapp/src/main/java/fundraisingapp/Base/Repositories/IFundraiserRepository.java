package fundraisingapp.Base.Repositories;

import fundraisingapp.Base.Model.Fundraiser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IFundraiserRepository extends CrudRepository<Fundraiser,Long> {
    List<Fundraiser> findAll();
    @Query(value = " select * from fundraisers f join fundraisers_users u on f.id = u.fundraiser_id"
            + " join fundraisers_categories c on c.fundraiser_id = f.id where u.user_id =:id",nativeQuery = true)
    List<Fundraiser> findAllByUser(@Param("id")Long id);
    Fundraiser getById(Long id);
}
