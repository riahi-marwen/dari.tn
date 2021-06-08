package com.esprit.dari.repository;


import com.esprit.dari.entities.userentity.UserDari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDariRepository extends JpaRepository<UserDari,Long> {
    public UserDari findByUsername (String userName);
}
