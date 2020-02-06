package fundraisingapp.Base.Repositories;

import fundraisingapp.Base.Model.Donation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDonationRepository extends CrudRepository<Donation,Long> {

}
