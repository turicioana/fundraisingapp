package fundraisingapp.Base.Repositories;

import fundraisingapp.Base.Model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepository extends CrudRepository<Company,Long> {
    @Query(value = "select * from companies c join companies_users cu on c.id = cu.company_id " +
            "where cu.user_id = :id", nativeQuery = true)
    Company getCompanyByActiveUserId(@Param("id")Long id);
}
