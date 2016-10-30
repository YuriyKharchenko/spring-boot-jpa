package ua.home.springboot.sample.service;


import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import ua.home.springboot.sample.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    // for test
    @Secured("authenticated")
    public void methodOne();

    @PreAuthorize("hasRole('ADMIN')")
    public void methodTwo(String msg);

    @PreAuthorize("#user.userName == authentication.name")
    public void methodThree(User user);


}
