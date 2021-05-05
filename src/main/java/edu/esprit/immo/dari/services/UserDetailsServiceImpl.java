package edu.esprit.immo.dari.services;

import edu.esprit.immo.dari.entities.User;
import edu.esprit.immo.dari.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// A USER uses their EMAIL & password to login. Thus, here email address will be
		// used as username.
		User user = userRepository.findByEmail(username);

		if (user == null) {
			throw new UsernameNotFoundException("The provided email " + username + " does not exit!");
		}

		log.info("loadUserByUsername() : {}", username);

		return new UserDetailsImpl(user);
	}
}
