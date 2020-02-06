package fundraisingapp.Base.Controller;

import fundraisingapp.Base.Dto.CompanyDto;
import fundraisingapp.Base.Service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("companies")
@CrossOrigin
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    public CompanyController(ICompanyService companyService) {
        this.companyService = companyService;
    }

    @PreAuthorize("hasAnyAuthority('USER')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addCompany(@RequestBody CompanyDto companyDto){
        if(companyService.saveCompany(companyDto)!=null)
        {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
