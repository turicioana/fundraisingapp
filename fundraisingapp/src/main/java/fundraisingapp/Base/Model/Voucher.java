package fundraisingapp.Base.Model;


import javax.persistence.*;

@Entity(name = "Voucher")
@Table(name = "vouchers")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "purpose", nullable = false)
    private String purpose;

    @Column(name = "number", nullable = false)
    private String number;

    @ManyToOne
    @JoinTable(
            name = "vouchers_companies",
            joinColumns = @JoinColumn(
                    name = "voucher_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "company_id", referencedColumnName = "id"))
    private Company company;

    @ManyToOne
    @JoinTable(
            name = "vouchers_fundraisers",
            joinColumns = @JoinColumn(
                    name = "voucher_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "fundraiser_id", referencedColumnName = "id"))
    private Fundraiser fundraiser;

    public Voucher() {
    }

    public Long getId() {
        return id;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Fundraiser getFundraiser() {
        return fundraiser;
    }

    public void setFundraiser(Fundraiser fundraiser) {
        this.fundraiser = fundraiser;
    }
}
