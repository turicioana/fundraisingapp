package fundraisingapp;

import fundraisingapp.Base.Model.User;
import fundraisingapp.Base.Repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("fundraisingapp")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(IUserRepository userRepository) {
        return args -> {
            User user = new User();
            user.setId(1L);
            user.setName("Ionel");
            user.setEmail("ionel@smecher.ro");
            user.setPassword("ionelsmecherel");
            userRepository.save(user);
        };
    }
}
