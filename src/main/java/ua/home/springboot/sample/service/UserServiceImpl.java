package ua.home.springboot.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.home.springboot.sample.model.User;
import ua.home.springboot.sample.repository.RoleRepository;
import ua.home.springboot.sample.repository.UserRepository;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));

        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // for test

    @Override
    public void methodOne() {
        System.out.println("--Method One--");
    }

    @Override
    public void methodTwo(String msg) {
        System.out.println("Message:" + msg);
    }

    @Override
    public void methodThree(User user) {
        System.out.println("User Name:" + user.getUsername());
    }

}
