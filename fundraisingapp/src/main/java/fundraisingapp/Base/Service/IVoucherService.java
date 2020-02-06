package fundraisingapp.Base.Service;

import fundraisingapp.Base.Dto.VoucherDetailsDto;
import fundraisingapp.Base.Dto.VoucherDto;
import fundraisingapp.Base.Model.Voucher;

import java.util.List;

public interface IVoucherService {
    Voucher saveVoucher(Long fundraiserId,VoucherDto voucherDto);
    List<VoucherDto> getAllVouchers();
    VoucherDetailsDto getById(Long id);
}
