package com.esprit.pi.repository;

import com.esprit.pi.entities.ConfirmationToken;
import com.esprit.pi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
    Optional<ConfirmationToken> findConfirmationTokensByConfirmationToken(String s);
    @Query("select c from ConfirmationToken c where c.user.id = ?1")
    Optional<ConfirmationToken> findConfirmationTokensByUserID(Long id);
}