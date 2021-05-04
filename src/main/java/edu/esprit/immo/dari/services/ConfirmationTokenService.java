package edu.esprit.immo.dari.services;

import edu.esprit.immo.dari.entities.ConfirmationToken;
import edu.esprit.immo.dari.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ConfirmationTokenService {
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    public  void saveConfirmationToken(ConfirmationToken confirmationToken) {

        confirmationTokenRepository.save(confirmationToken);
    }

    public void deleteConfirmationToken(Long id){

        confirmationTokenRepository.deleteById(id);
    }

    public Optional<ConfirmationToken> findConfirmationTokensByToken(String s){
        return confirmationTokenRepository.findConfirmationTokensByConfirmationToken(s);
    }
}
