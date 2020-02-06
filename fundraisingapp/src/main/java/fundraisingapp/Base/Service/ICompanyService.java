package fundraisingapp.Base.Service;

import fundraisingapp.Base.Dto.CompanyDto;
import fundraisingapp.Base.Model.Company;

public interface ICompanyService {
    Company saveCompany(CompanyDto companyDto);
    Company getActiveCompany();
}
