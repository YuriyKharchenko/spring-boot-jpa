package ua.home.springboot.sample.service;

public interface SecurityService {
    String findLoggedInUsername();
    String getName();
    void autologin(String username, String password);
}
