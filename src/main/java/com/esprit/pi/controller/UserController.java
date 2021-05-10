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

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Scope(value = "session")
@Controller(value = "UserController")
@ELBeanName(value = "UserController")
@Join(path = "/", to = "/Login/signin.jsf")
@AllArgsConstructor
public class UserController {
	@Autowired
    private  UserService userService;
	@Autowired
    private  ConfirmationTokenService confirmationTokenService;
	private UserForm userform = new UserForm();
	private boolean active;
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
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
	private User authenticatedUser;
	public String doLogin() {
		String navigateTo = "null";
		authenticatedUser = userService.authenticate(userform.getUsername(),userform.getPassword());
		if (authenticatedUser != null && authenticatedUser.getUserRole() == UserRole.CLIENT) {

			navigateTo = "/Vente/affichevente.xhtml?faces-redirect=true";
			authenticatedUser.setActive(true);
		}
		if (authenticatedUser != null && authenticatedUser.getUserRole() == UserRole.ADMINISTRATEUR) {

			navigateTo = "/Login/dashbordvente.xhtml?faces-redirect=true";
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
		return "/Login/signin.xhtml?faces-redirect=true";
	}

	public String addUsers() {
		logger.error("test2");
		return "/Login/signin.xhtml?faces-redirect=true";

	}
	public String signup() {
				return "/Login/signin.xhtml?faces-redirect=true";

	}
	public UserForm getUserform() {
		return userform;
	}
	public void setUserform(UserForm userform) {
		this.userform = userform;
	}
}