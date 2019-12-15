package fundraisingapp.Base.Service;

import fundraisingapp.Base.Dto.FundraiserRegistrationDto;
import fundraisingapp.Base.Model.Fundraiser;

import java.util.List;

public interface IFundraiserService {
    List<FundraiserRegistrationDto> getAllFundraisers();
}
