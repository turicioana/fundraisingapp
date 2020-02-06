package fundraisingapp.Base.Model;

import fundraisingapp.Auth.Model.User;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Fundraiser")
@Table(name = "fundraisers")
public class Fundraiser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "decription", nullable = false, columnDefinition="text")
    private String description;

    @Column(name = "maximumAmount", nullable = false)
    private double maximumAmount;

    @Column(name = "actualAmount", nullable = false)
    private double actualAmount;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_email")
    private String contact_email;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "active")
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> images;

    @ManyToOne
    @JoinTable(
            name = "fundraisers_users",
            joinColumns = @JoinColumn(
                    name = "fundraiser_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"))
    private User user;

    @ManyToOne
    @JoinTable(
            name = "fundraisers_categories",
            joinColumns = @JoinColumn(
                    name = "fundraiser_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "category_id", referencedColumnName = "id"))
    private Category category;

    @OneToMany(mappedBy = "fundraiser")
    private List<Voucher> vouchers;

    @OneToMany()
    private List<Donation> donations;

    public Fundraiser() {
    }

    public Long getId() {
        return id;
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<Voucher> vouchers) {
        this.vouchers = vouchers;
    }

    public double getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(double maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(double actualAmount) {
        this.actualAmount = actualAmount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }
}
