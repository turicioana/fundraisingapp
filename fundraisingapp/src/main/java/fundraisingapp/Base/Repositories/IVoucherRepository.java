package fundraisingapp.Base.Repositories;

import fundraisingapp.Base.Model.Voucher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVoucherRepository extends CrudRepository<Voucher, Long> {
    List<Voucher> findAll();
    Voucher getById(Long id);
}
