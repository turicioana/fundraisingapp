package fundraisingapp.Base.Service.Mapper;

import fundraisingapp.Base.Dto.DonationDto;
import fundraisingapp.Base.Model.Donation;
import org.springframework.stereotype.Service;

@Service
public class DonationMapper implements IDonationMapper {
    @Override
    public Donation DonationDtoToDonation(DonationDto donationDto) {
        Donation donation = new Donation();
        donation.setAmount(donationDto.getAmount());
        return donation;
    }
}
