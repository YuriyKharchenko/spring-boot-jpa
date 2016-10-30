package ua.home.springboot.sample.jpaRepositories;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ua.home.springboot.Application;
import ua.home.springboot.sample.model.Contact;
import ua.home.springboot.sample.model.User;
import ua.home.springboot.sample.repository.ContactRepository;
import ua.home.springboot.sample.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class JpaTest {


    @Autowired
    ContactRepository contactRepository;
    @Autowired
    UserRepository userRepository;

    Contact ivan;
    Contact anna;
    Contact tom;

    User manager;
    User intern;

    @Before
    public void setUp() {

        ivan = new Contact("Ivan", "Ivanov","qqqq","+3801234567","(044)325789","qq","qq@i.ua",1L);
        anna = new Contact("Anna", "Petrova","wwww","+3801234567","(044)325789","ww","ww@i.ua",1L);
        tom = new Contact("Tom", "Jerry","eeee","eeee","+3801234567","(044)325789","ee@i.ua",2L);

        intern = new User("intern","111","AAA");
        intern.setId(1L);
        manager = new User("manager","222","AAA");
        manager.setId(2L);

        contactRepository.deleteAll();
        contactRepository.save(Arrays.asList(ivan));
        contactRepository.save(Arrays.asList(anna));

        userRepository.save(Arrays.asList(intern));
        userRepository.save(Arrays.asList(manager));


    }
    @After
    public void cleanAll(){
        contactRepository.deleteAll();
        userRepository.deleteAll();
    }


    @Test
    public void testFindByUserId() {
        List<Contact> expected = Arrays.asList(ivan,anna);
        List<Contact> actual = contactRepository.findByUserId(1L);

        Assert.assertEquals(expected, actual);

    }
    @Test
    public void findByLastName() {
        String expected = "Ivanov";

        String actual = contactRepository.findByLastName("Ivanov").getLastname();
        Assert.assertEquals("NOT equal", expected, actual);

    }
    @Test
    public void findByUsername(){
        String expected = "manager";
        User actualUser = userRepository.findByUsername("manager");
        String actual = actualUser.getUsername();

        Assert.assertEquals(expected,actual);
    }



}


