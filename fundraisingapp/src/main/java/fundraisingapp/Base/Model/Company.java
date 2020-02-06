package fundraisingapp.Base.Model;

import fundraisingapp.Auth.Model.User;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Company")
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_email")
    private String contact_email;

    @Column(name = "phone_number")
    private String phone_number;

    @OneToMany(mappedBy = "company")
    private List<Voucher> vouchers;

    @ManyToOne
    @JoinTable(
            name = "companies_users",
            joinColumns = @JoinColumn(
                    name = "company_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"))
    private User user;


    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){ this.id = id;}

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

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<Voucher> vouchers) {
        this.vouchers = vouchers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
