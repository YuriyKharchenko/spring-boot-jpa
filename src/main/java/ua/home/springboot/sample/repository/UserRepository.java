package ua.home.springboot.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.home.springboot.sample.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
