package fundraisingapp.Base.Service;

import fundraisingapp.Auth.Model.User;
import fundraisingapp.Auth.Service.IUserService;
import fundraisingapp.Base.Dto.ActiveAccountDto;
import fundraisingapp.Base.Dto.FundraiserDetailsDto;
import fundraisingapp.Base.Dto.FundraiserRegistrationDto;
import fundraisingapp.Base.Model.Fundraiser;
import fundraisingapp.Base.Model.Image;
import fundraisingapp.Base.Repositories.ICategoryRepository;
import fundraisingapp.Base.Repositories.IFundraiserRepository;
import fundraisingapp.Base.Repositories.IImageRepository;
import fundraisingapp.Base.Service.Mapper.IFundraiserMapper;
import fundraisingapp.Helpers.IFaceDetection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    private IImageRepository imageRepository;

    @Autowired
    private IUserService userService;

    @Autowired
    IFundraiserMapper fundraiserMapper;

    @Autowired
    IFaceDetection faceDetection;
    public FundraiserService(IFundraiserRepository fundraiserRepository, IFundraiserMapper fundraiserMapper,
                             ICategoryRepository categoryRepository, IAuthenticationFacade authenticationFacade,
                             IUserService userService, IImageRepository imageRepository,
                             IFaceDetection faceDetection) {
        this.fundraiserRepository = fundraiserRepository;
        this.fundraiserMapper = fundraiserMapper;
        this.categoryRepository = categoryRepository;
        this.authenticationFacade =authenticationFacade;
        this.userService =  userService;
        this.imageRepository = imageRepository;
        this.faceDetection = faceDetection;
    }

    @Override
    public List<FundraiserDetailsDto> getAllFundraisers() {
        List<Fundraiser> fundraisers = fundraiserRepository.findAll();
        List<FundraiserDetailsDto> fundraisersDto = new ArrayList<>();
        for (Fundraiser fundraiser : fundraisers) {
            if(authenticationFacade.getAuthenticatedUser().getRole().getName().equals("ADMIN") && !fundraiser.isActive())
            {
                fundraisersDto.add(fundraiserMapper.FundraiserToFundraiserDetailsDto(fundraiser));
            }
            else{
                if(!authenticationFacade.getAuthenticatedUser().getRole().getName().equals("ADMIN")&&fundraiser.isActive()) {
                    fundraisersDto.add(fundraiserMapper.FundraiserToFundraiserDetailsDto(fundraiser));
                }
            }
        }
        return fundraisersDto;
    }

    @Override
    public List<FundraiserDetailsDto> getAllFundraisersByUser() {
        User user = authenticationFacade.getAuthenticatedUser();
        List<Fundraiser> fundraisers = fundraiserRepository.findAllByUser(user.getId());
        List<FundraiserDetailsDto> fundraiserDto = new ArrayList<>();
        for( Fundraiser fundraiser: fundraisers){
            if(fundraiser.isActive()){
                fundraiserDto.add(fundraiserMapper.FundraiserToFundraiserDetailsDto(fundraiser));
            }
        }
        return  fundraiserDto;
    }

    private String imageProcessing(String image){
        String prefix = image.split(",")[0];
        String extension = prefix.split("/")[1].split(";")[0];
        String processedImage = faceDetection.encodeToString(
                faceDetection.toBufferedImage(faceDetection.detectFaces(faceDetection.decodeImage(image))),
                extension);
        return prefix + "," + processedImage;
    }

    @Override
    public Fundraiser saveFundraiser(FundraiserRegistrationDto fundraiserDto) throws IOException {
        Fundraiser fundraiser = fundraiserMapper.FundraiserDtoToFundraiser(fundraiserDto);
        List<Image> images = new ArrayList<>();
        for (String image:fundraiserDto.getImages()
             ) {
            Image image1 = new Image();
            image1.setFile(imageProcessing(image));
            images.add(image1);
        }
        fundraiser.setCategory(categoryRepository.getCategoryByName(fundraiserDto.getCategory()));
        fundraiser.setImages(images);
        fundraiser.setActualAmount(0);
        fundraiser.setActive(false);
        fundraiser.setUser(authenticationFacade.getAuthenticatedUser());
        fundraiserRepository.save(fundraiser);
        return fundraiser;
    }

    @Override
    public FundraiserDetailsDto getById(Long id) {
        Fundraiser fundraiser = fundraiserRepository.getById(id);
        FundraiserDetailsDto fundraiserDetailsDto = fundraiserMapper.FundraiserToFundraiserDetailsDto(fundraiser);
        List<String> images = new ArrayList<>();
        for (Image image: fundraiser.getImages()) {
            images.add(image.getFile());
        }
        fundraiserDetailsDto.setImages(images);
        return fundraiserDetailsDto;
    }

    @Override
    public Fundraiser increaseFundraiserAmount(Long id, double amount){
        Fundraiser fundraiser =  fundraiserRepository.getById(id);
        double curentAmount = fundraiser.getActualAmount();
        fundraiser.setActualAmount(curentAmount + amount);
        fundraiserRepository.save(fundraiser);
        return fundraiser;
    }

    @Override
    public Fundraiser activateFundraiser(Long id, ActiveAccountDto activeAccountDto) {
        Fundraiser fundraiser = fundraiserRepository.getById(id);
        fundraiser.setActive(activeAccountDto.isActive());
        userService.changeUserRole(fundraiser.getUser(),"FUNDRAISER");
        fundraiserRepository.save(fundraiser);
        return fundraiser;
    }
}
