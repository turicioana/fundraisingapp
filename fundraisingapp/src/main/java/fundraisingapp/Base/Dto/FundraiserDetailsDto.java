package fundraisingapp.Base.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class FundraiserDetailsDto {
    
    private Long id;

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

    @NotNull(message = "Phone number should not be null.")
    @NotEmpty(message = "Phone number should not be empty.")
    private String category;

    private double amount;

    private double actualAmount;

    List<String> images;

    public FundraiserDetailsDto() {
    }

    public FundraiserDetailsDto(Long Id, String title, String description,String address, String contact_email,String phone_number, String category) {
        this.title = title;
        this.description = description;
        this.address = address;
        this.contact_email = contact_email;
        this.phone_number = phone_number;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setImages(List<String> images) {
        this.images = images;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(double actualAmount) {
        this.actualAmount = actualAmount;
    }
}
