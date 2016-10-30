package ua.home.springboot.sample.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ua.home.springboot.Application;
import ua.home.springboot.sample.model.User;
import ua.home.springboot.sample.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)

@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class SecurityTest {
    @Autowired
    UserService userService;
    @Autowired
    UserDetailsService userDetailsService;


    @Test(expected = AuthenticationCredentialsNotFoundException.class)
    public void testOne() {
        userService.methodOne();
    }
    @Test
    @WithMockUser(roles={"ADMIN"})
    public void testTwo() {
        userService.methodTwo("This is Admin");
    }
    @Test
    @WithMockUser(username = "ravan")
    public void testThree() {
        User user = new User();
        user.setUsername("ravan");
        userService.methodThree(user);
    }

}
