package com.esprit.pi.repository;

import com.esprit.pi.entities.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    public PasswordResetToken findFirstByUserIdOrderByExpirationDateDesc(Long id);

    public PasswordResetToken findFirstByToken(String token);

}