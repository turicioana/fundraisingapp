package fundraisingapp.Base.Service;

import fundraisingapp.Auth.Service.IUserService;
import fundraisingapp.Base.Dto.CompanyDto;
import fundraisingapp.Base.Model.Company;
import fundraisingapp.Base.Repositories.ICompanyRepository;
import fundraisingapp.Base.Service.Mapper.ICompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements ICompanyService {
    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    private IUserService userService;

    @Autowired
    private ICompanyRepository companyRepository;

    @Autowired
    private ICompanyMapper companyMapper;

    public CompanyService(IAuthenticationFacade authenticationFacade,
                          IUserService userService,
                          ICompanyRepository companyRepository,
                          ICompanyMapper companyMapper) {
        this.authenticationFacade = authenticationFacade;
        this.userService = userService;
        this.companyRepository = companyRepository;
        this.companyMapper =  companyMapper;
    }

    @Override
    public Company saveCompany(CompanyDto companyDto) {
        Company company = companyMapper.CompanyDtoToCompany(companyDto);
        company.setUser(authenticationFacade.getAuthenticatedUser());
        userService.changeUserRole(authenticationFacade.getAuthenticatedUser(),"COMPANY");
        companyRepository.save(company);
        return company;
    }

    public Company getActiveCompany(){
        return companyRepository.getCompanyByActiveUserId(authenticationFacade.getAuthenticatedUser().getId());
    }
}
