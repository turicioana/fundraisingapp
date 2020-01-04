package fundraisingapp.Base.Controller;

import fundraisingapp.Base.Dto.FundraiserRegistrationDto;
import fundraisingapp.Base.Service.IAuthenticationFacade;
import fundraisingapp.Base.Service.IFundraiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fundraisers")
@CrossOrigin
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

    @PreAuthorize("hasAnyAuthority('FUNDRAISER', 'USER')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addFundraiser(@RequestBody FundraiserRegistrationDto fundraiserDto){
        if(fundraiserService.saveFundraiser(fundraiserDto)!=null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
