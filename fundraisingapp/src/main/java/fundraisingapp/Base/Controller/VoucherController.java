package fundraisingapp.Base.Controller;

import fundraisingapp.Base.Dto.FundraiserDetailsDto;
import fundraisingapp.Base.Dto.VoucherDetailsDto;
import fundraisingapp.Base.Dto.VoucherDto;
import fundraisingapp.Base.Service.IVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vouchers")
@CrossOrigin
public class VoucherController {

    @Autowired
    IVoucherService voucherService;

    public VoucherController(IVoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @GetMapping
    public List<VoucherDto> getAllFundraisers(){
        return voucherService.getAllVouchers();
    }

    @PreAuthorize("hasAnyAuthority('FUNDRAISER', 'USER', 'COMPANY')")
    @GetMapping("/{id}")
    public ResponseEntity<VoucherDetailsDto> getSpecificVoucher(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(voucherService.getById(id));
    }
}
