package fundraisingapp.Auth.Model;


import fundraisingapp.Base.Model.Company;
import fundraisingapp.Base.Model.Donation;
import fundraisingapp.Base.Model.Fundraiser;

import javax.persistence.*;
import java.util.List;

@Entity(name = "User")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Role role;

    @Column(name = "isEnabled", nullable = false)
    private boolean isEnabled;

    @OneToMany()
    private List<Fundraiser> fundraisers;

    @OneToMany()
    private List<Donation> donations;

    @OneToMany()
    private List<Company> companies;

    public User(){}

    public User(String name, String email, String password, Role role)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String email, String name, String password, Role role, boolean isEnabled) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.isEnabled = isEnabled;
        this.name = name;
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }

    public boolean isEnabled() { return isEnabled; }

    public void setEnabled(boolean enabled) { isEnabled = enabled; }

}
