package ua.home.springboot.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.home.springboot.sample.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
