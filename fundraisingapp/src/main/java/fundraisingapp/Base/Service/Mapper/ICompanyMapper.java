package fundraisingapp.Base.Service.Mapper;

import fundraisingapp.Base.Dto.CompanyDto;
import fundraisingapp.Base.Model.Company;

public interface ICompanyMapper {
    Company CompanyDtoToCompany(CompanyDto companyDto);
    CompanyDto CompanyToCompanyDto(Company company);
}
