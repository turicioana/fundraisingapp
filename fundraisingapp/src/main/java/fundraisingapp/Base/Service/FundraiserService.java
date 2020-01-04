package fundraisingapp.Base.Service;

import fundraisingapp.Auth.Service.IUserService;
import fundraisingapp.Base.Dto.FundraiserRegistrationDto;
import fundraisingapp.Base.Model.Fundraiser;
import fundraisingapp.Base.Repositories.ICategoryRepository;
import fundraisingapp.Base.Repositories.IFundraiserRepository;
import fundraisingapp.Base.Service.Mapper.IFundraiserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FundraiserService implements IFundraiserService {

    @Autowired
    private IFundraiserRepository fundraiserRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    private IUserService userService;

    @Autowired
    IFundraiserMapper fundraiserMapper;

    public FundraiserService(IFundraiserRepository fundraiserRepository, IFundraiserMapper fundraiserMapper,
                             ICategoryRepository categoryRepository, IAuthenticationFacade authenticationFacade,
                             IUserService userService) {
        this.fundraiserRepository = fundraiserRepository;
        this.fundraiserMapper = fundraiserMapper;
        this.categoryRepository = categoryRepository;
        this.authenticationFacade =authenticationFacade;
        this.userService =  userService;
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

    @Override
    public Fundraiser saveFundraiser(FundraiserRegistrationDto fundraiserDto) {
        Fundraiser fundraiser = fundraiserMapper.FundraiserDtoToFundraiser(fundraiserDto);
        fundraiser.setCategory(categoryRepository.getCategoryByName(fundraiserDto.getCategory()));
        fundraiser.setUser(authenticationFacade.getAuthenticatedUser());
        userService.changeUserRole(authenticationFacade.getAuthenticatedUser(),"FUNDRAISER");
        fundraiserRepository.save(fundraiser);
        return fundraiser;
    }
}
