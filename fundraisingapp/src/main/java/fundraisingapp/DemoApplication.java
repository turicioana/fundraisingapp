package fundraisingapp;

import fundraisingapp.Auth.Model.Privilege;
import fundraisingapp.Auth.Model.Role;
import fundraisingapp.Auth.Model.User;
import fundraisingapp.Auth.Repositories.IPrivilegeRepository;
import fundraisingapp.Auth.Repositories.IRoleRepository;
import fundraisingapp.Auth.Repositories.IUserRepository;
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
    public CommandLineRunner commandLineRunner(IUserRepository userRepository, PasswordEncoder passwordEncoder, IRoleRepository roleRepository, IPrivilegeRepository privilegeRepository) {
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

            Role role1 = new Role("admin");
            role1.addPrivilege(privilege1);
            role1.addPrivilege(privilege2);
            roleRepository.save(role1);

            user.setId(1L);
            user.setName("Ionel");
            user.setEmail("ionel@smecher.ro");
            user.setPassword(passwordEncoder.encode("ionelsmecherel"));
            user.setEnabled(true);
            user.setRole(role1);
            userRepository.save(user);
        };
    }
}
