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

    @Column(name = "decription", nullable = false)
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_email")
    private String contact_email;

    @Column(name = "phone_number")
    private String phone_number;

    @OneToMany(mappedBy = "fundraiser")
    private List<Image> images;

    @ManyToOne
    @JoinTable(
            name = "fundraisers_users",
            joinColumns = @JoinColumn(
                    name = "fundraiser_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"))
    private User user;

    public Fundraiser() {
    }
}
