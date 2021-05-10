package tn.esprit.projet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.esprit.projet.modal.User;
import tn.esprit.projet.repository.UserRepository;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<?> addUser(User user) {
		if (userRepository.findByEmail(user.getEmail()) != null) {
			return new ResponseEntity<>("Email already taken !", HttpStatus.FOUND);
		} else {
			if (userRepository.findByUserName(user.getUserName()) != null) {
				return new ResponseEntity<>("UserName already taken !", HttpStatus.FOUND);
			}
		}
		return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
	}

	public ResponseEntity<?> getUsers() {
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<?> getUser(Long id) {
		return new ResponseEntity<>(userRepository.findById(id).get(), HttpStatus.OK);
	}

	public ResponseEntity<?> updateUser(User user) {
		return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
	}

	public ResponseEntity<?> deleteUser(Long id) {
		userRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	public ResponseEntity<?> login(String login, String password) {
		User user = new User();
		try {
			user = userRepository.findByEmail(login);
			if (user.getPassword().equals(password)) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			}
		} catch (Exception e) {

		}
		try {
			user = userRepository.findByUserName(login);
			if (user.getPassword().equals(password)) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			}
		} catch (Exception e2) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

	}


	public User findUserById(long id) {
		return this.userRepository.findById(id).get();
	}

	@Override
	public User authenticate(String login, String password) {
		return userRepository.getUserByEmailAndPassword(login, password);
	}

}
