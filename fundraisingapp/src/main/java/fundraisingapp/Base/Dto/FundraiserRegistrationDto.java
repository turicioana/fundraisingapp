package fundraisingapp.Base.Dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @NotNull(message = "Category should not be null.")
    @NotEmpty(message = "Category should not be empty.")
    private String category;

    private List<String> images;

    @NotNull(message = "Amount should not be null.")
    @NotEmpty(message = "Amount number should not be empty.")
    private double amount;

    public FundraiserRegistrationDto() {
    }

    public FundraiserRegistrationDto(String title, String description,String address, String contact_email,String phone_number, String category) {
        this.title = title;
        this.description = description;
        this.address = address;
        this.contact_email = contact_email;
        this.phone_number = phone_number;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> image) {
        this.images = image;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
