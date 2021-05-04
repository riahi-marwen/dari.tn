package edu.esprit.immo.dari.repository;

import edu.esprit.immo.dari.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);
}