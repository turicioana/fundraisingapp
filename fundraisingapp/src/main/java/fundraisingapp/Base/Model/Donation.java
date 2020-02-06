package fundraisingapp.Base.Model;

import fundraisingapp.Auth.Model.User;

import javax.persistence.*;

@Entity(name = "Donation")
@Table(name = "donations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private double amount;

    @ManyToOne
    @JoinTable(
            name = "donations_users",
            joinColumns = @JoinColumn(
                    name = "donation_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(
            name = "user_id", referencedColumnName = "id"))
    private User user;

    @ManyToOne
    @JoinTable(
            name = "donations_fundraisers",
            joinColumns = @JoinColumn(
                    name = "donation_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(
            name = "fundraiser_id", referencedColumnName = "id"))
    private Fundraiser fundraiser;

    public Donation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Fundraiser getFundraiser() {
        return fundraiser;
    }

    public void setFundraiser(Fundraiser fundraiser) {
        this.fundraiser = fundraiser;
    }
}
