package ua.home.springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ua.home.springboot.sample.model.Role;
import ua.home.springboot.sample.repository.RoleRepository;
import ua.home.springboot.sample.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories("ua.home.springboot.sample.repository.")
public class Application implements CommandLineRunner {


    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Role user = new Role("ROLE_USER");
        roleRepository.save(user);

    }

}