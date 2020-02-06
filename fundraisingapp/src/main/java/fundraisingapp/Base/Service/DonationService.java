package fundraisingapp.Base.Service;

import fundraisingapp.Base.Dto.DonationDto;
import fundraisingapp.Base.Model.Donation;
import fundraisingapp.Base.Repositories.IDonationRepository;
import fundraisingapp.Base.Service.Mapper.IDonationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationService implements IDonationService {
    @Autowired
    private IDonationRepository donationRepository;

    @Autowired
    private IDonationMapper donationMapper;

    @Autowired
    private IFundraiserService fundraiserService;

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    public DonationService(IDonationRepository donationRepository,
                           IDonationMapper donationMapper,
                           IFundraiserService fundraiserService,
                           IAuthenticationFacade authenticationFacade) {
        this.donationRepository = donationRepository;
        this.donationMapper = donationMapper;
        this.fundraiserService = fundraiserService;
        this.authenticationFacade = authenticationFacade;
    }

    @Override
    public Donation saveDonation(Long id, DonationDto donationDto) {
        Donation donation = new Donation();
        donation.setAmount(donationDto.getAmount());
        donation.setFundraiser(fundraiserService.increaseFundraiserAmount(id, donation.getAmount()));
        donation.setUser(authenticationFacade.getAuthenticatedUser());
        donationRepository.save(donation);
        return donation;
    }
}
