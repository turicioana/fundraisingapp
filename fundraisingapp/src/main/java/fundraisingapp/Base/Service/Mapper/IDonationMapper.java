package fundraisingapp.Base.Service.Mapper;

import fundraisingapp.Base.Dto.DonationDto;
import fundraisingapp.Base.Model.Donation;

public interface IDonationMapper {
    Donation DonationDtoToDonation(DonationDto donationDto);
}
