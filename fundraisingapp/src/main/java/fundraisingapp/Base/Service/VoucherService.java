package fundraisingapp.Base.Service;

import fundraisingapp.Base.Dto.VoucherDetailsDto;
import fundraisingapp.Base.Dto.VoucherDto;
import fundraisingapp.Base.Model.Voucher;
import fundraisingapp.Base.Repositories.IFundraiserRepository;
import fundraisingapp.Base.Repositories.IVoucherRepository;
import fundraisingapp.Base.Service.Mapper.IVoucherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoucherService implements IVoucherService {

    @Autowired
    private IVoucherRepository voucherRepository;

    @Autowired
    private IVoucherMapper voucherMapper;

    @Autowired
    private IFundraiserRepository fundraiserRepository;

    @Autowired
    private ICompanyService companyService;


    public VoucherService(IVoucherRepository voucherRepository,
                          IVoucherMapper voucherMapper,
                          IFundraiserRepository fundraiserRepository,
                          ICompanyService companyService) {
        this.voucherRepository = voucherRepository;
        this.voucherMapper = voucherMapper;
        this.fundraiserRepository = fundraiserRepository;
        this.companyService = companyService;
    }

    @Override
    public Voucher saveVoucher(Long fundraiserId,VoucherDto voucherDto) {
        Voucher voucher = voucherMapper.VoucherDtoToVoucher(voucherDto);
        voucher.setFundraiser(fundraiserRepository.getById(fundraiserId));
        voucher.setCompany(companyService.getActiveCompany());
        voucherRepository.save(voucher);
        return voucher;
    }

    @Override
    public List<VoucherDto> getAllVouchers() {
        List<Voucher> vouchers =  voucherRepository.findAll();
        List<VoucherDto> vouchersDto = new ArrayList<>();
        for(Voucher voucher: vouchers){
            vouchersDto.add(voucherMapper.VoucherToVoucherDto(voucher));
        }
        return vouchersDto;
    }

    @Override
    public VoucherDetailsDto getById(Long id) {
        Voucher voucher = voucherRepository.getById(id);
        return voucherMapper.VoucherToVoucherDetailsDto(voucher);
    }

}
