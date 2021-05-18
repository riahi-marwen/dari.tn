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

	private String login;
	private String password;
	private Boolean loggedIn;
	private User authenticatedUser = null;
	private String lastname;
	private String firstname;
	private String email;
	private boolean actif;
	private Role role;
	public Role[] getRoles() { return Role.values(); }
	private Integer userIdToBeUpdated;
	private List<User> users;
	public void addUser() {
		userService.addOrUpdateUser(new User(lastname, firstname, email, password, role, actif));
		}
	public void removeUser(int UserId)
	{
		userService.deleteUserById(UserId);
	}
	/* methode navigate*/
	public String navigToexemple2()
	{
		String navigateTo = "null";
		navigateTo = "/pages/admin/exemple2.xhtml";
		return navigateTo;	
	}
	
	/*public String  navigToProduit()
	{
		String navigateTo = "null";
		navigateTo = "/pages/admin/produit.xhtml";
		return navigateTo;	
		
	}
	public String  navigToCategory()
	{
		String navigateTo = "null";
		navigateTo = "/pages/admin/category.xhtml";
		return navigateTo;	
		
	}*/
	public String doLogin() {
		String navigateTo = "null";
		authenticatedUser=userService.authenticate(login, password);
		if (authenticatedUser != null && authenticatedUser.getRole() == Role.ADMIN) {
		navigateTo = "/pages/admin/exemple.xhtml?faces-redirect=true";
		loggedIn = true; }
		else {
		FacesMessage facesMessage =

		new FacesMessage("Login Failed: please check your username/password and try again.");

		FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
		}
	    public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
		}
		/*public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/Login/signin.xhtml?faces-redirect=true";
	}*/
	  /*  public String addUser() {

			if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

			userService.addOrUpdateUser(new User(firstName, lastName, email, password, role, actif)); 
			return "null"; 
		}
	    public String removeUser(int userId) {
			String navigateTo = "null";
			if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

			userService.deleteUserById(userId);
			return navigateTo; 
		}*/
	    
	    public String displayUser(User user) 
		{
			String navigateTo = "null";
			if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";


			this.setFirstname(user.getFirstName());
			this.setLastname(user.getLastName());
			this.setActif(user.isActif());
			this.setEmail(user.getEmail());
			this.setRole(user.getRole());
			this.setPassword(user.getPassword());
			this.setUserIdToBeUpdated(user.getId());

			return navigateTo; 

		} 
	    
	    /*public void setUserIdToBeUpdated(int userIdToBeUpdated) {
			this.userIdToBeUpdated = userIdToBeUpdated;
		}*/
		public void updateUser() 
		{ 
		
			userService.addOrUpdateUser(new User(userIdToBeUpdated, lastname, firstname, email, password, role, actif)); 

		}
	  //getter && setter
		public IUserService getUserService() {
			return userService;
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
		public Boolean getLoggedIn() {
			return loggedIn;
		}
		public void setLoggedIn(Boolean loggedIn) {
			this.loggedIn = loggedIn;
		}
		public User getAuthenticatedUser() {
			return authenticatedUser;
		}
		public void setAuthenticatedUser(User authenticatedUser) {
			this.authenticatedUser = authenticatedUser;
		}
	
		public String getLastname() {
			return lastname;
		}




		public void setLastname(String lastname) {
			this.lastname = lastname;
		}




		public String getFirstname() {
			return firstname;
		}




		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}




		public void setUserIdToBeUpdated(int userIdToBeUpdated) {
			this.userIdToBeUpdated = userIdToBeUpdated;
		}




		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public boolean isActif() {
			return actif;
		}
		public void setActif(boolean actif) {
			this.actif = actif;
		}
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		public Integer getUserIdToBeUpdated() {
			return userIdToBeUpdated;
		}
		public void setUserIdToBeUpdated(Integer userIdToBeUpdated) {
			this.userIdToBeUpdated = userIdToBeUpdated;
		}
		
		public List<User> getUsers() {
			users=userService.getAllUsers();
			return users;
		}
		public void setUsers(List<User> users) {
			this.users = users;
		} 
	    
	    

		
}
