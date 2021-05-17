package com.esprit.pi.controller;

import com.esprit.pi.entities.ConfirmationToken;

import com.esprit.pi.entities.User;
import com.esprit.pi.entities.UserRole;
import com.esprit.pi.payload.UserForm;
import com.esprit.pi.services.ConfirmationTokenService;
import com.esprit.pi.services.UserService;
import lombok.AllArgsConstructor;

import org.apache.log4j.Logger;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Scope(value = "session")
@Controller(value = "UsersController")
@ELBeanName(value = "UsersController")
@Join(path = "/", to = "/Login/signup.jsf?faces-redirect=true")
@AllArgsConstructor
public class UserController {
	@Autowired
    private  UserService userService;
	@Autowired
    private  ConfirmationTokenService confirmationTokenService;
	@Autowired
	private UserForm userform ;
	private User authenticatedUser = new User();
	private String usr;
	private String pass;
	private String Confirmationtoken;
    public String getConfirmationtoken() {
		return Confirmationtoken;
	}
	public void setConfirmationtoken(String confirmationtoken) {
		Confirmationtoken = confirmationtoken;
	}
	public String getUsr() {
		return usr;
	}
	public void setUsr(String usr) {
		this.usr = usr;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	final static Logger logger = Logger.getLogger(UserController.class);
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public ConfirmationTokenService getConfirmationTokenService() {
		return confirmationTokenService;
	}
	public void setConfirmationTokenService(ConfirmationTokenService confirmationTokenService) {
		this.confirmationTokenService = confirmationTokenService;
	}
	public User getAuthenticatedUser() {
		return authenticatedUser;
	}
	public void setAuthenticatedUser(User authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}
	private ConfirmationToken confirmationToken;
	public ConfirmationToken getConfirmationToken() {
		return confirmationToken;
	}
	public void setConfirmationToken(ConfirmationToken confirmationToken) {
		this.confirmationToken = confirmationToken;
	}
	public String signin() {

		System.out.println("test2");
		String navigateTo = null;


		System.out.println(usr);
		System.out.println(pass);
		authenticatedUser = userService.authenticate(usr,pass);
		System.out.println(authenticatedUser);
		if (authenticatedUser != null && authenticatedUser.getUserRole() == UserRole.CLIENT) {

			navigateTo = "/Login/login.xhtml?faces-redirect=true";
			authenticatedUser.setActive(true);
		}
		if (authenticatedUser != null && authenticatedUser.getUserRole() == UserRole.ADMINISTRATEUR) {

			navigateTo = "/Login/signup.jsf?faces-redirect=true";
			authenticatedUser.setActive(true);
		}

		else {
			FacesMessage facesMessage =

					new FacesMessage("Login Failed: please check your username/password and try again.");

			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		}
		return navigateTo;
	}
	public UserRole[] getUserRoles() {
		return UserRole.values();
	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/Login/signin.jsf?faces-redirect=true";
	}

	public String signup() {
		User user= new User(userform);
		userService.signUpUser(user);
		return "/Login/signin.jsf?faces-redirect=true";

	}
	public UserForm getUserform() {
		return userform;
	}
	public void setUserform(UserForm userform) {
		this.userform = userform;
	}
    @GetMapping("/sign-up/confirm")
    String confirmMail(@RequestParam("token") String token) {

        Optional<ConfirmationToken> optionalConfirmationToken = confirmationTokenService.findConfirmationTokensByToken(token);

        optionalConfirmationToken.ifPresent(userService::confirmUser);

        return "redirect:/Login/signin.jsf?faces-redirect=true";
    }
    @GetMapping("/resetPass")
    String RediractResetPass(@RequestParam("token") String token) {
    	Confirmationtoken = token;
        return "redirect:/Login/resetpassform.jsf?faces-redirect=true";
    }


	public String Sendresetpasswordemail() {
		authenticatedUser = userService.findUserByEmail(userform.getEmail());
		if(userService.SendRestpasswordemail(userform.getEmail())) {
			return "/Login/signup.jsf?faces-redirect=true";
		}
		else{
			return null;
		}
	}
	public String resetpassform() {
		userService.UpdateUserPassword(authenticatedUser, userform.getPassword());
		System.out.println("teset1");
		return "/Login/singin.jsf";
	}
}