package fundraisingapp.Base.Service.Mapper;

import fundraisingapp.Base.Dto.VoucherDetailsDto;
import fundraisingapp.Base.Dto.VoucherDto;
import fundraisingapp.Base.Model.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherMapper implements IVoucherMapper{
    @Autowired
    IFundraiserMapper fundraiserMapper;

    @Autowired
    ICompanyMapper companyMapper;

    @Override
    public Voucher VoucherDtoToVoucher(VoucherDto voucherDto) {
        Voucher voucher = new Voucher();
        voucher.setType(voucherDto.getType());
        voucher.setPurpose(voucherDto.getPurpose());
        voucher.setNumber(voucherDto.getNumber());
        return voucher;
    }

    @Override
    public VoucherDto VoucherToVoucherDto(Voucher voucher) {
        VoucherDto voucherDto = new VoucherDto();
        voucherDto.setId(voucher.getId());
        voucherDto.setType(voucher.getType());
        voucherDto.setPurpose(voucher.getPurpose());
        voucherDto.setNumber(voucher.getNumber());
        return voucherDto;
    }

    @Override
    public VoucherDetailsDto VoucherToVoucherDetailsDto(Voucher voucher) {
        VoucherDetailsDto voucherDetailsDto = new VoucherDetailsDto();
        voucherDetailsDto.setType(voucher.getType());
        voucherDetailsDto.setPurpose(voucher.getPurpose());
        voucherDetailsDto.setNumber(voucher.getNumber());
        voucherDetailsDto.setCompanyDto(companyMapper.CompanyToCompanyDto(voucher.getCompany()));
        voucherDetailsDto.setFundraiserDetailsDto(fundraiserMapper.FundraiserToFundraiserDetailsDto(voucher.getFundraiser()));
        return voucherDetailsDto;
    }
}
