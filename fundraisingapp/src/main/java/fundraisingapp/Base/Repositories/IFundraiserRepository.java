package fundraisingapp.Base.Repositories;

import fundraisingapp.Base.Model.Fundraiser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IFundraiserRepository extends CrudRepository<Fundraiser,Long> {
    List<Fundraiser> findAll();
}
