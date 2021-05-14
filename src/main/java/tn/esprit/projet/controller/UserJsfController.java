package tn.esprit.projet.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.projet.modal.Role;
import tn.esprit.projet.modal.User;
import tn.esprit.projet.service.IUserService;
import tn.esprit.projet.service.ProduitServiceImpl;

@Scope(value = "session")
@Controller(value = "usermaroController") // Name of the bean in Spring IoC
@ELBeanName(value = "usermaroController") // Name of the bean used by JSF
@Join(path = "/", to = "/login.jsf")
public class UserJsfController {
	@Autowired
	IUserService userService;
	private static final Logger l = LogManager.getLogger(ProduitServiceImpl.class);

	private String login;
	private String password;
	private String name;
	private User user;
	private Boolean loggedIn;
	private Role role;
	public IUserService getUserService() {
		return userService;
	}
	
	
	public String displayUser(User user) {
		// String navigateTo = "null";
		this.setName(user.getUserName());
		this.setLogin(user.getEmail());
		this.setPassword(user.getPassword());
		this.setRole(user.getRole());
		return "/Login/modifUsers.xhtml?faces-redirect=true";

	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	/*public String doLogin() {
		String navigateTo = "null";
		User u=userService.authenticate(login, password);
		if (u != null && u.getRole() == Role.ADMIN) {
		navigateTo = "/pages/admin/welcome.xhtml?faces-redirect=true";
		loggedIn = true; }
		else {
		FacesMessage facesMessage =

		new FacesMessage("Login Failed: please check your username/password and try again.");

		FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
		}*/
	
		public String doLogin() {
		String navigateTo = "null";
		User u = userService.authenticate(login, password);
		if (u != null && user.getRole() == Role.USER) {

			navigateTo = "/Vente/affichevente.xhtml?faces-redirect=true";
			loggedIn = true;
		}
		if (u != null && user.getRole() == Role.ADMIN) {

			navigateTo = "/Login/dashbordvente.xhtml?faces-redirect=true";
			loggedIn = true;
		}

		else {
			FacesMessage facesMessage =

					new FacesMessage("Login Failed: please check your username/password and try again.");

			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		}
		return navigateTo;
	}

		public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/Login/signin.xhtml?faces-redirect=true";
	}

		//public String doLogout() {
		//FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		//return "/login.xhtml?faces-redirect=true";
		//}
}
