package edu.esprit.immo.dari.repository;

import edu.esprit.immo.dari.entities.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
    Optional<ConfirmationToken> findConfirmationTokensByConfirmationToken(String s);
}