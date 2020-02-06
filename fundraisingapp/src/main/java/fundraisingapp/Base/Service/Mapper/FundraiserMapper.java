package fundraisingapp.Base.Service.Mapper;

import fundraisingapp.Base.Dto.FundraiserDetailsDto;
import fundraisingapp.Base.Dto.FundraiserRegistrationDto;
import fundraisingapp.Base.Model.Fundraiser;
import org.springframework.stereotype.Service;

@Service
public class FundraiserMapper implements IFundraiserMapper {
    @Override
    public Fundraiser FundraiserDtoToFundraiser(FundraiserRegistrationDto fundraiserDto) {
        Fundraiser fundraiser = new Fundraiser();
        fundraiser.setTitle(fundraiserDto.getTitle());
        fundraiser.setDescription(fundraiserDto.getDescription());
        fundraiser.setAddress(fundraiserDto.getAddress());
        fundraiser.setContact_email(fundraiserDto.getContact_email());
        fundraiser.setPhone_number(fundraiserDto.getPhone_number());
        fundraiser.setMaximumAmount(fundraiserDto.getAmount());

        return fundraiser;
    }

    @Override
    public FundraiserRegistrationDto FundraiserToFundraiserDto(Fundraiser fundraiser) {
        FundraiserRegistrationDto fundraiserRegistrationDto = new FundraiserRegistrationDto();
        fundraiserRegistrationDto.setTitle(fundraiser.getTitle());
        fundraiserRegistrationDto.setDescription(fundraiser.getDescription());
        fundraiserRegistrationDto.setAddress(fundraiser.getAddress());
        fundraiserRegistrationDto.setContact_email(fundraiser.getContact_email());
        fundraiserRegistrationDto.setPhone_number(fundraiser.getPhone_number());
        fundraiserRegistrationDto.setCategory(fundraiser.getCategory().getName());

        return fundraiserRegistrationDto;
    }

    @Override
    public FundraiserDetailsDto FundraiserToFundraiserDetailsDto(Fundraiser fundraiser) {
        FundraiserDetailsDto fundraiserDetailsDto = new FundraiserDetailsDto();
        fundraiserDetailsDto.setId(fundraiser.getId());
        fundraiserDetailsDto.setTitle(fundraiser.getTitle());
        fundraiserDetailsDto.setDescription(fundraiser.getDescription());
        fundraiserDetailsDto.setAddress(fundraiser.getAddress());
        fundraiserDetailsDto.setCategory(fundraiser.getCategory().getName());
        fundraiserDetailsDto.setContact_email(fundraiser.getContact_email());
        fundraiserDetailsDto.setPhone_number(fundraiser.getPhone_number());
        fundraiserDetailsDto.setAmount(fundraiser.getMaximumAmount());
        fundraiserDetailsDto.setActualAmount(fundraiser.getActualAmount());

        return fundraiserDetailsDto;
    }
}
