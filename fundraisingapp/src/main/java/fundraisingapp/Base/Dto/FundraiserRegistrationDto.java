package fundraisingapp.Base.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FundraiserRegistrationDto {
    @NotNull(message = "Title should not be null.")
    @NotEmpty(message = "Title should not be empty.")
    private String title;

    @NotNull(message = "Description should not be null.")
    @NotEmpty(message = "Description should not be empty.")
    private String description;

    @NotNull(message = "Address should not be null.")
    @NotEmpty(message = "Address should not be empty.")
    private String address;

    @NotNull(message = "Contact email should not be null.")
    @NotEmpty(message = "Contact email should not be empty.")
    private String contact_email;

    @NotNull(message = "Phone number should not be null.")
    @NotEmpty(message = "Phone number should not be empty.")
    private String phone_number;

    public FundraiserRegistrationDto() {
    }

    public FundraiserRegistrationDto(String title, String description,String address, String contact_email,String phone_number) {
        this.title = title;
        this.description = description;
        this.address = address;
        this.contact_email = contact_email;
        this.phone_number = phone_number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
