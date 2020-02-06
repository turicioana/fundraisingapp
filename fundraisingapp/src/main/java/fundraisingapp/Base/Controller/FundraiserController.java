package fundraisingapp.Base.Controller;

import fundraisingapp.Base.Dto.*;
import fundraisingapp.Base.Model.Fundraiser;
import fundraisingapp.Base.Service.IAuthenticationFacade;
import fundraisingapp.Base.Service.IDonationService;
import fundraisingapp.Base.Service.IFundraiserService;
import fundraisingapp.Base.Service.IVoucherService;
import fundraisingapp.Base.Service.Mapper.IVoucherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import javax.xml.ws.Response;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("fundraisers")
@CrossOrigin
public class FundraiserController {
    @Autowired
    private IFundraiserService fundraiserService;

    @Autowired
    private IVoucherService voucherService;

    @Autowired
    private IDonationService donationService;


    public FundraiserController(IFundraiserService fundraiserService,
                                IVoucherService voucherService,
                                IDonationService donationService) {
        this.fundraiserService = fundraiserService;
        this.voucherService = voucherService;
        this.donationService = donationService;
    }

    @GetMapping
    public List<FundraiserDetailsDto> getAllFundraisers(){
        return fundraiserService.getAllFundraisers();
    }

    @PreAuthorize("hasAnyAuthority('FUNDRAISER', 'USER', 'COMPANY','ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<FundraiserDetailsDto> getSpecificFundraiser(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(fundraiserService.getById(id));
    }

    @PreAuthorize("hasAnyAuthority('FUNDRAISER', 'USER')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addFundraiser(@RequestBody FundraiserRegistrationDto fundraiserDto) throws IOException {
        if(fundraiserService.saveFundraiser(fundraiserDto)!=null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PatchMapping("/{id}")
    public ResponseEntity<?> activateFundraiser(@PathVariable Long id, @RequestBody ActiveAccountDto activeAccountDto){
        if(fundraiserService.activateFundraiser(id,activeAccountDto)!=null)
        {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PreAuthorize("hasAnyAuthority('COMPANY')")
    @PostMapping("/{id}/vouchers")
    public ResponseEntity<String> addVoucher(@PathVariable Long id, @RequestBody VoucherDto voucherDto){
        if(voucherService.saveVoucher(id,voucherDto)!=null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping("/{id}/donations")
    public ResponseEntity<?> addDonation(@PathVariable Long id, @RequestBody DonationDto donationDto){
        if(donationService.saveDonation(id,donationDto)!=null){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
