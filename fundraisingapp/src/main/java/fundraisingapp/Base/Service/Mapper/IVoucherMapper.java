package fundraisingapp.Base.Service.Mapper;

import fundraisingapp.Base.Dto.VoucherDetailsDto;
import fundraisingapp.Base.Dto.VoucherDto;
import fundraisingapp.Base.Model.Voucher;

public interface IVoucherMapper {
    Voucher VoucherDtoToVoucher(VoucherDto voucherDto);
    VoucherDto VoucherToVoucherDto(Voucher voucher);
    VoucherDetailsDto VoucherToVoucherDetailsDto(Voucher voucher);
}
