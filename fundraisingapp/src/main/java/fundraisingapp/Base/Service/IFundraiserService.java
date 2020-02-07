package fundraisingapp.Base.Service;

import fundraisingapp.Base.Dto.ActiveAccountDto;
import fundraisingapp.Base.Dto.FundraiserDetailsDto;
import fundraisingapp.Base.Dto.FundraiserRegistrationDto;
import fundraisingapp.Base.Model.Fundraiser;

import java.io.IOException;
import java.util.List;

public interface IFundraiserService {
    List<FundraiserDetailsDto> getAllFundraisers();
    List<FundraiserDetailsDto> getAllFundraisersByUser();
    Fundraiser saveFundraiser(FundraiserRegistrationDto fundraiserDto) throws IOException;
    FundraiserDetailsDto getById(Long id);
    Fundraiser activateFundraiser(Long id, ActiveAccountDto activeAccountDto);
    Fundraiser increaseFundraiserAmount(Long id, double amount);
}
