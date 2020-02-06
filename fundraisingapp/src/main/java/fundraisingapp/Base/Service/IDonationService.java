package fundraisingapp.Base.Service;

import fundraisingapp.Base.Dto.DonationDto;
import fundraisingapp.Base.Model.Donation;

public interface IDonationService {
    Donation saveDonation(Long id, DonationDto donationDto);
}
