package fundraisingapp.Base.Service.Mapper;

import fundraisingapp.Base.Dto.FundraiserDetailsDto;
import fundraisingapp.Base.Dto.FundraiserRegistrationDto;
import fundraisingapp.Base.Model.Fundraiser;

public interface IFundraiserMapper {
    Fundraiser FundraiserDtoToFundraiser(FundraiserRegistrationDto fundraiserDto);
    FundraiserRegistrationDto FundraiserToFundraiserDto(Fundraiser fundraiser);
    FundraiserDetailsDto FundraiserToFundraiserDetailsDto(Fundraiser fundraiser);
}
