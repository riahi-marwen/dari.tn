package com.esprit.pi.services;

import com.esprit.pi.entities.ConfirmationToken;
import com.esprit.pi.entities.User;
import com.esprit.pi.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
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
    public Optional<ConfirmationToken> findConfirmationTokensByUser(User user){
        return confirmationTokenRepository.findConfirmationTokensByUserID(user.getId());

    }
    	public Date getExirationDate() {
    		
    		final long ONE_MINUTE_IN_MILLIS = 60000; // milliseconds

    		Calendar date = Calendar.getInstance();
    		long t = date.getTimeInMillis();
    		Date afterAddingTenMins = new Date(t + (10 * ONE_MINUTE_IN_MILLIS));
    		return afterAddingTenMins;
    	}


    	public boolean verifyToken(String token) {
    		Optional<ConfirmationToken> confirmationToken = findConfirmationTokensByToken(token);
    		if (confirmationToken.isPresent() && getExirationDate().before(confirmationToken.get().getCreatedDate() )) {
    			return true;
    		} else {
    			return false;
    		}
    	}
}
