package ua.home.springboot.sample.service;


import ua.home.springboot.sample.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
