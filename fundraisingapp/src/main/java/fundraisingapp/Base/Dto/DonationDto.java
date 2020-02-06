package fundraisingapp.Base.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DonationDto {
    private Long id;

    @NotNull(message = "Donated amount should not be null.")
    @NotEmpty(message = "Donated should not be empty.")
    private double amount;

    public DonationDto() {
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
