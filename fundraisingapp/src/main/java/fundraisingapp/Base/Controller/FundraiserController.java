package fundraisingapp.Base.Controller;

import fundraisingapp.Base.Dto.FundraiserRegistrationDto;
import fundraisingapp.Base.Service.IFundraiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("fundraisers")
public class FundraiserController {
    @Autowired
    private IFundraiserService fundraiserService;

    public FundraiserController(IFundraiserService fundraiserService) {
        this.fundraiserService = fundraiserService;
    }

    @GetMapping
    public List<FundraiserRegistrationDto> getAllFundraisers(){
        return fundraiserService.getAllFundraisers();
    }
}
