package com.esprit.pi.services;

import com.esprit.pi.entities.ConfirmationToken;
import com.esprit.pi.entities.User;
import com.esprit.pi.repository.ConfirmationTokenRepository;
import com.esprit.pi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.text.MessageFormat;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  ConfirmationTokenService confirmationTokenService;
    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder ;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final Optional<User> optionalUser = userRepository.findByUsername(s);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        else {
            throw new UsernameNotFoundException(MessageFormat.format("User with username {0} cannot be found.", s));
        }
    }
    public void signUpUser(User user) {

        System.out.println("test1");
        final String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        System.out.println("test2");
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        final ConfirmationToken confirmationToken = new ConfirmationToken(user);

        confirmationTokenService.saveConfirmationToken(confirmationToken);
        sendConfirmationMail(user.getEmail(), confirmationToken.getConfirmationToken());
    }
    public void confirmUser(ConfirmationToken confirmationToken) {

        final User user = confirmationToken.getUser();

        user.setEnabled(true);

        userRepository.save(user);

    }
    public void sendConfirmationMail(String userMail, String token) {

        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userMail);
        mailMessage.setSubject("Mail Confirmation Link!");
        mailMessage.setFrom("c7f79b6a12-3fcecc@inbox.mailtrap.io");
        mailMessage.setText(
                "Thank you for registering. Please click on the below link to activate your account." + "http://localhost:8081/Login/confirm?token="
                        + token);

        emailSenderService.sendEmail(mailMessage);
    }
    public User authenticate(String login,String password) {

    	Optional<User> user  = userRepository.findByUsername(password);
    	if(user.isPresent() && 
    			bCryptPasswordEncoder.matches(password, user.get().getPassword())  == true) {
    		return user.get();
    	}
    	else
    		return null;
    }
}
