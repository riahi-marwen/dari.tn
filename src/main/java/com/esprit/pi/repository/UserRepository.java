package com.esprit.pi.repository;

import com.esprit.pi.entities.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>  {
    Optional<User> findByUsername(String username);
    User findUserByUsernameAndPassword(String username,String password);
    User findByUsernameAndPassword(String username,String password);
    @Query("SELECT e FROM users e WHERE e.username=:username and e.password=:password")
	public User getUsersByEmailAndPassword(@Param("username") String username, @Param("password") String password);

    
}