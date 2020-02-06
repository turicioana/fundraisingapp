package fundraisingapp.Base.Repositories;

import fundraisingapp.Base.Model.Fundraiser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IFundraiserRepository extends CrudRepository<Fundraiser,Long> {
    List<Fundraiser> findAll();
    Fundraiser getById(Long id);
}
