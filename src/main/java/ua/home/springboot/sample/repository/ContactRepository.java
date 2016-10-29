package ua.home.springboot.sample.repository;//package ua.home.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.home.springboot.sample.model.Contact;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("select c from Contact c where c.userId = ?1")
    List<Contact> findByUserId(Long userId);

    @Query("select c from Contact c where c.lastname = ?1")
    Contact findByLastName(String lastname);

}
