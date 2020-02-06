package fundraisingapp.Base.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VoucherDetailsDto {

    @NotNull(message = "Name should not be null.")
    @NotEmpty(message = "Name should not be empty.")
    private String type;

    @NotNull(message = "Address should not be null.")
    @NotEmpty(message = "Address should not be empty.")
    private String purpose;

    @NotNull(message = "Contact email should not be null.")
    @NotEmpty(message = "Contact email should not be empty.")
    private String number;

    private CompanyDto company;

    private FundraiserDetailsDto fundraiser;

    public VoucherDetailsDto() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CompanyDto getCompany() {
        return company;
    }

    public void setCompanyDto(CompanyDto company) {
        this.company = company;
    }

    public FundraiserDetailsDto getFundraiser() {
        return fundraiser;
    }

    public void setFundraiserDetailsDto(FundraiserDetailsDto fundraiser) {
        this.fundraiser = fundraiser;
    }
}
