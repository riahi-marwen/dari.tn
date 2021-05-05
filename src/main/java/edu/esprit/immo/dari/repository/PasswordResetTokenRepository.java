package edu.esprit.immo.dari.repository;

import edu.esprit.immo.dari.entities.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    public PasswordResetToken findFirstByUserIdOrderByExpirationDateDesc(Long id);

    public PasswordResetToken findFirstByToken(String token);

}