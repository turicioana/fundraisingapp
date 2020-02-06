package fundraisingapp.Base.Dto;

public class ActiveAccountDto {

    private boolean active;

    public ActiveAccountDto(boolean active) {
        this.active = active;
    }

    public ActiveAccountDto() {
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
