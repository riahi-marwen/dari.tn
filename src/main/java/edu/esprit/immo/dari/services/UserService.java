package edu.esprit.immo.dari.services;

import edu.esprit.immo.dari.entities.RoleType;
import edu.esprit.immo.dari.entities.User;
import edu.esprit.immo.dari.entities.forms.AccountRegistrationForm;
import edu.esprit.immo.dari.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private EmailService emailService;

	public void updateUserAccountPassword(HttpServletRequest request, RedirectAttributes redirectAttr, String email) {
		String currentPassword = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!newPassword.equals(confirmPassword)) {
			redirectAttr.addFlashAttribute("ERROR", "Error! Your password did not match. Please try again.");
		} else {
			if (isCurrentPasswordValid(currentPassword, email)) {
				updateUserPassword(newPassword, email);
				redirectAttr.addFlashAttribute("SUCCESS", "Success! Your password has been updated.");
			} else {
				redirectAttr.addFlashAttribute("ERROR", "Error! Your current password is invalid. Please try again.");
			}
		}
	}

	private void updateUserPassword(String newPassword, String email) {
		User user = getCurrentUserByEmail(email);
		user.setPassword(passwordEncoder.encode(newPassword));
		userRepository.save(user);
	}

	public void updateUserPassword(String newPassword, Long userId) {
		User user = getUserByUserId(userId);
		user.setPassword(passwordEncoder.encode(newPassword));
		userRepository.save(user);
	}

	public User getUserByUserId(Long userId) {
		return userRepository.findById(userId).get();
	}

	public boolean isCurrentPasswordValid(String password, String email) {
		System.out.println(passwordEncoder.matches(password, getPasswordByEmail(email)));
		if (passwordEncoder.matches(password, getPasswordByEmail(email))) {
			return true;
		} else {
			return false;
		}
	}

	public String getPasswordByEmail(String email) {
		return userRepository.findByEmail(email).getPassword();
	}

	public User getCurrentUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public void updateUserAccountEmail(HttpServletRequest request, RedirectAttributes redirectAttr, String email) {
		String currentEmail = request.getParameter("currentEmail");
		String newEmail = request.getParameter("newEmail");
		String confirmEmail = request.getParameter("confirmEmail");

		if (!newEmail.equals(confirmEmail)) {
			redirectAttr.addFlashAttribute("ERROR", "Error! Your email did not match. Please try again.");
		} else {
			if (currentEmail.equals(email)) {
				if (updateUserEmail(newEmail, currentEmail)) {
					redirectAttr.addFlashAttribute("SUCCESS", "Success! Your email has been updated.");
					redirectAttr.addFlashAttribute("newEmail", newEmail);
				} else {
					redirectAttr.addFlashAttribute("ERROR",
							"Error! The provided new email already exists. Please choose a different email.");
				}
			} else {
				redirectAttr.addFlashAttribute("ERROR", "Error! The provided email does not exist. Please try again.");
			}
		}

	}

	public boolean updateUserEmail(String newEmail, String currentEmail) {
		User user = getCurrentUserByEmail(newEmail);
		if (user == null) {
			User user2 = getCurrentUserByEmail(currentEmail);
			user2.setEmail(newEmail);
			userRepository.save(user2);
			return true;
		} else {
			return false;
		}

	}

	public String createNewAccount(@Valid AccountRegistrationForm accountRegistrationForm, ModelMap modelMap,
			RedirectAttributes redirectAttr) {
		if (!accountRegistrationForm.getPassword().equals(accountRegistrationForm.getConfirmPassword())) {
			modelMap.put("ERROR", "Error! Your password does not match. Please try again.");
			return "register";
		} else {
			if (userRepository.findByEmail(accountRegistrationForm.getEmail()) != null) {
				modelMap.put("ERROR", "Error! The email provided already exists. Please try again.");
				return "register";
			} else {
				createNewUser(accountRegistrationForm);
				redirectAttr.addFlashAttribute("REGISTRATION_SUCCESSFUL_MESSAGE",
						"Success! You have successfully registered for an account.");
				sendNewUserEmailWelcome(accountRegistrationForm);
				return "redirect:/login";
			}
		}
	}

	private void sendNewUserEmailWelcome(@Valid AccountRegistrationForm accountRegistrationForm) {
		String to = accountRegistrationForm.getEmail();
		String from = "riadh@esprit.tn <riadh@esprit.tn>";
		String subject = accountRegistrationForm.getFirstName() + ", welcome to Dari.tn!";
		String body = accountRegistrationForm.getFirstName() + ", welcome to OnlineBookstore!\r\n" + "\r\n"
				+ "Browse your favorite books, our editorial picks, bestsellers, or customer favorites.\r\n" + "\r\n";
		emailService.sendSimpleMessage(to, from, subject, body);
	}

	private void createNewUser(@Valid AccountRegistrationForm accountRegistrationForm) {
		User user = new User();
		user.setFirstName(accountRegistrationForm.getFirstName());
		user.setLastName(accountRegistrationForm.getLastName());
		user.setEmail(accountRegistrationForm.getEmail());
		user.setPassword(passwordEncoder.encode(accountRegistrationForm.getPassword()));
		user.setUserRole(RoleType.CUSTOMER);
		user.setDateCreated(new Date());
		userRepository.save(user);
	}


}
