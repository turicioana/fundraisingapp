package fundraisingapp.Base.Service.Mapper;

import fundraisingapp.Base.Dto.CompanyDto;
import fundraisingapp.Base.Model.Company;
import org.springframework.stereotype.Service;

@Service
public class CompanyMapper implements ICompanyMapper {
    @Override
    public Company CompanyDtoToCompany(CompanyDto companyDto) {
        Company company = new Company();
        company.setName(companyDto.getName());
        company.setAddress(companyDto.getAddress());
        company.setContact_email(companyDto.getContact_email());
        company.setPhone_number(companyDto.getPhone_number());

        return company;
    }

    @Override
    public CompanyDto CompanyToCompanyDto(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setName(company.getName());
        companyDto.setAddress(company.getAddress());
        companyDto.setContact_email(company.getContact_email());
        companyDto.setPhone_number(company.getPhone_number());
        return companyDto;
    }
}
