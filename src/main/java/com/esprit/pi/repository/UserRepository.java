package com.esprit.pi.repository;

import com.esprit.pi.entities.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
    Optional<User> findByUsername(String username);
    User findOneByUsernameAndPassword(String username,String password);
    User findByUsernameAndPassword(String username,String password);
    @Query("SELECT e FROM users e WHERE e.username=:username and e.password=:password")
	public User getUsersByUserNameAndPassword(@Param("username") String username, @Param("password") String password);


    Optional<User> findUserByEmail(String email);
}