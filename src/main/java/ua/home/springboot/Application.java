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

//    @Autowired
//    ContactRepository contactRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        Contact one = new Contact("Anna", "First", "Mid", "132456", "32164", "clinton", "i1@ua");
//        Contact two = new Contact("Anna", "Second", "Mid", "132456", "32164", "clinton", "i2@ua");
//        Contact three = new Contact("Anna", "Third", "Mid", "132456", "32164", "clinton", "i3@ua");
//        Contact four = new Contact("Anna", "Fourth", "Mid", "132456", "32164", "clinton", "i4@ua");

//        contactRepository.save(one);
//        contactRepository.save(two);
//        contactRepository.save(three);
//        contactRepository.save(four);

//        List<User> users = new LinkedList<>();
//        users.add(new User("user1","111","fio",
//                Arrays.asList(new Contact[]{one,three})));
//        users.add(new User("user2","222","fio",
//                Arrays.asList(new Contact[]{two,one,four})));
//        users.add(new User("user3","333","fio",
//                Arrays.asList(new Contact[]{one,two,three,four})));
//
//        userRepository.save(users);


        Role user = new Role("ROLE_USER");
        roleRepository.save(user);
//        Set<Role> tomRoles = new HashSet<>();
//        tomRoles.add(user);
//
//        User tom = new User("Tomson","11111111");
//        tom.setRoles(tomRoles);
//        userRepository.save(tom);


    }

}