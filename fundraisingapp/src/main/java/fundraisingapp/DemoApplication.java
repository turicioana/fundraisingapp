package fundraisingapp;

import fundraisingapp.Auth.Model.Privilege;
import fundraisingapp.Auth.Model.Role;
import fundraisingapp.Auth.Model.User;
import fundraisingapp.Auth.Repositories.IPrivilegeRepository;
import fundraisingapp.Auth.Repositories.IRoleRepository;
import fundraisingapp.Auth.Repositories.IUserRepository;
import fundraisingapp.Base.Model.Category;
import fundraisingapp.Base.Model.Company;
import fundraisingapp.Base.Model.Fundraiser;
import fundraisingapp.Base.Repositories.ICategoryRepository;
import fundraisingapp.Base.Repositories.ICompanyRepository;
import fundraisingapp.Base.Repositories.IFundraiserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
//@EnableAutoConfiguration
@ComponentScan("fundraisingapp")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(IUserRepository userRepository,
                                               PasswordEncoder passwordEncoder,
                                               IRoleRepository roleRepository,
                                               IPrivilegeRepository privilegeRepository,
                                               IFundraiserRepository fundraiserRepository,
                                               ICategoryRepository categoryRepository,
                                               ICompanyRepository companyRepository) {
        return args -> {
            User user = new User();
//            Role role2 = new Role("user");
//            roleRepository.save(role2);
//            Role role3 = new Role("company");
//            roleRepository.save(role3);
//            Collection<Role> roles = new ArrayList<>();
//            roles.add(role1);
//            roles.add(role2);
//            roles.add(role3);
            Privilege privilege1 = new Privilege("WRITE_PRIVILEGE");
            privilegeRepository.save(privilege1);
            Privilege privilege2 = new Privilege("READ_PRIVILEGE");
            privilegeRepository.save(privilege2);

            Role role1 = new Role("ADMIN");
            role1.addPrivilege(privilege1);
            role1.addPrivilege(privilege2);
            roleRepository.save(role1);

            Role role2 = new Role("FUNDRAISER");
            role2.addPrivilege(privilege1);
            role2.addPrivilege(privilege2);
            roleRepository.save(role2);

            Role role3 = new Role("USER");
            role3.addPrivilege(privilege1);
            role3.addPrivilege(privilege2);
            roleRepository.save(role3);

            Role role4 = new Role("COMPANY");
            role4.addPrivilege(privilege1);
            role4.addPrivilege(privilege2);
            roleRepository.save(role4);

            user.setId(1L);
            user.setName("Ionel");
            user.setEmail("ionel@smecher.ro");
            user.setPassword(passwordEncoder.encode("ionelsmecherel"));
            user.setEnabled(true);
            user.setRole(role1);
            userRepository.save(user);

            User user1 = new User();
            user1.setId(2L);
            user1.setName("Testulet");
            user1.setEmail("test@test.com");
            user1.setPassword(passwordEncoder.encode("parola"));
            user1.setEnabled(true);
            user1.setRole(role3);
            userRepository.save(user1);

            User user2 = new User();
            user2.setId(3L);
            user2.setName("RandomUser");
            user2.setEmail("user@user.com");
            user2.setPassword(passwordEncoder.encode("parola"));
            user2.setEnabled(true);
            user2.setRole(role4);
            userRepository.save(user2);

            Company company = new Company();
            company.setId(1L);
            company.setName("Random Company");
            company.setAddress("Str. Palat nr. 10");
            company.setContact_email("email@domain.com");
            company.setPhone_number("0755555555");
            company.setUser(user2);
            companyRepository.save(company);

            Category category = new Category();
            category.setId(1L);
            category.setName("Medical causes");
            categoryRepository.save(category);

            Category category1 = new Category();
            category1.setId(2L);
            category1.setName("Environment");
            categoryRepository.save(category1);

            Category category2 = new Category();
            category2.setId(3L);
            category2.setName("Disasters");
            categoryRepository.save(category2);

            Category category3 = new Category();
            category3.setId(4L);
            category3.setName("Social causes");
            categoryRepository.save(category3);

            Fundraiser fundraiser = new Fundraiser();
            fundraiser.setId(1L);
            fundraiser.setTitle("First fundraiser ever");
            fundraiser.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
            fundraiser.setPhone_number("074555876");
            fundraiser.setContact_email("contact123@domain.com");
            fundraiser.setAddress("114  Still Pastures Drive, Columbia");
            fundraiser.setUser(user);
            fundraiser.setMaximumAmount(1000);
            fundraiser.setActualAmount(500);
            fundraiser.setActive(true);
            fundraiser.setCategory(category);

            fundraiserRepository.save(fundraiser);

            Fundraiser fundraiser1 = new Fundraiser();
            fundraiser1.setId(2L);
            fundraiser1.setTitle("Second fundraiser ever");
            fundraiser1.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ");
            fundraiser1.setPhone_number("0743495555");
            fundraiser1.setContact_email("contact098@domain.com");
            fundraiser1.setAddress("483  Parrill Court, Indiana");
            fundraiser1.setUser(user);
            fundraiser1.setMaximumAmount(10000);
            fundraiser1.setActualAmount(700);
            fundraiser1.setActive(true);
            fundraiser1.setCategory(category1);

            fundraiserRepository.save(fundraiser1);

            Fundraiser fundraiser2 = new Fundraiser();
            fundraiser2.setId(3L);
            fundraiser2.setTitle("First fundraiser ever");
            fundraiser2.setDescription("This is not so long description");
            fundraiser2.setPhone_number("0745555555");
            fundraiser2.setContact_email("contact@domain.com");
            fundraiser2.setAddress("this is a very random adress");
            fundraiser2.setUser(user);
            fundraiser2.setMaximumAmount(1570);
            fundraiser2.setActualAmount(300);
            fundraiser2.setActive(true);
            fundraiser2.setCategory(category3);

            fundraiserRepository.save(fundraiser2);

            Fundraiser fundraiser3 = new Fundraiser();
            fundraiser3.setId(4L);
            fundraiser3.setTitle("First fundraiser ever");
            fundraiser3.setDescription("This is not so long description");
            fundraiser3.setPhone_number("0745555555");
            fundraiser3.setContact_email("contact@domain.com");
            fundraiser3.setAddress("this is a very random adress");
            fundraiser3.setUser(user);
            fundraiser3.setMaximumAmount(5000);
            fundraiser3.setActualAmount(0);
            fundraiser3.setActive(true);
            fundraiser3.setCategory(category2);

            fundraiserRepository.save(fundraiser3);
        };
    }
}
