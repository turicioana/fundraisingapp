package fundraisingapp.Base.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CompanyDto {
    @NotNull(message = "Name should not be null.")
    @NotEmpty(message = "Name should not be empty.")
    private String name;

    @NotNull(message = "Address should not be null.")
    @NotEmpty(message = "Address should not be empty.")
    private String address;

    @NotNull(message = "Contact email should not be null.")
    @NotEmpty(message = "Contact email should not be empty.")
    private String contact_email;

    @NotNull(message = "Phone number should not be null.")
    @NotEmpty(message = "Phone number should not be empty.")
    private String phone_number;

    public CompanyDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
