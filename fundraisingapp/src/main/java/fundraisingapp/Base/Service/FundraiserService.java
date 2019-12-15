package fundraisingapp.Base.Service;

import fundraisingapp.Base.Dto.FundraiserRegistrationDto;
import fundraisingapp.Base.Model.Fundraiser;
import fundraisingapp.Base.Repositories.IFundraiserRepository;
import fundraisingapp.Base.Service.Mapper.IFundraiserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FundraiserService implements IFundraiserService {

    @Autowired
    private IFundraiserRepository fundraiserRepository;

    @Autowired
    IFundraiserMapper fundraiserMapper;

    public FundraiserService(IFundraiserRepository fundraiserRepository, IFundraiserMapper fundraiserMapper) {
        this.fundraiserRepository = fundraiserRepository;
        this.fundraiserMapper = fundraiserMapper;
    }

    @Override
    public List<FundraiserRegistrationDto> getAllFundraisers() {
        List<Fundraiser> fundraisers = fundraiserRepository.findAll();
        List<FundraiserRegistrationDto> fundraisersDto = new ArrayList<>();
        for (Fundraiser fundraiser : fundraisers) {
            fundraisersDto.add(fundraiserMapper.FundraiserToFundraiserDto(fundraiser));
        }
        return fundraisersDto;
    }
}
