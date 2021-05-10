package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Pattern;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;




import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IEmployeService;


@Scope(value = "session")
@Controller(value = "employeController")
@ELBeanName(value = "employeController")
@Join(path = "/", to = "/login.jsf")
public class ControllerEmployeImpl  {

	@Autowired
	IEmployeService employeService;

	private String login; 
	private String password; 
	private Boolean loggedIn;

	private User authenticatedUser = null; 
	private String prenom; 
	private String nom; 
	private String email;
	private boolean actif;
	private Role role;  
	public Role[] getRoles() { return Role.values(); }

	private List<User> employes; 

	private Integer employeIdToBeUpdated; // getter et setter

	public String  navigToProperty()
	{
		String navigateTo = "null";
		navigateTo = "/pages/admin/property.xhtml";
		return navigateTo;	
		
	}
	
	public String  navigTobuy()
	{
		String navigateTo = "null";
		navigateTo = "/pages/admin/buy.xhtml";
		return navigateTo;	
		
	}

	public String doLogin() {

		String navigateTo = "null";
		authenticatedUser=employeService.authenticate(login, password);
		if (authenticatedUser != null && authenticatedUser.getRole() == Role.ADMINISTRATEUR) {
			navigateTo = "/pages/admin/welcome.xhtml?faces-redirect=true";
			loggedIn = true;
		}		

		else
		{
			if (authenticatedUser != null && authenticatedUser.getRole() == Role.USER)
			{
			
				navigateTo = "/pages/users/property.xhtml";
				loggedIn = true;
				
			}
			else
			{
				FacesMessage facesMessage =
						new FacesMessage("Login Failed: Please check your username/password and try again.");
				FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
			}
			
			
			
		}
		return navigateTo;	
	}

	public String doLogout()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	
	return "/login.xhtml?faces-redirect=true";
	}


	public String addEmploye() {

		if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

		employeService.addOrUpdateEmploye(new User(nom, prenom, email, password, actif, role)); 
		return "null"; 
	}  

	public String removeEmploye(int employeId) {
		String navigateTo = "null";
		if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

		employeService.deleteEmployeById(employeId);
		return navigateTo; 
	} 

	public String displayEmploye(User empl) 
	{
		String navigateTo = "null";
		if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";


		this.setPrenom(empl.getPrenom());
		this.setNom(empl.getNom());
		this.setActif(empl.isActif()); 
		this.setEmail(empl.getEmail());
		this.setRole(empl.getRole());
		this.setPassword(empl.getPassword());
		this.setEmployeIdToBeUpdated(empl.getId());

		return navigateTo; 

	} 

	public String updateEmploye() 
	{ 
		String navigateTo = "null";
		
		if (authenticatedUser==null || !loggedIn) return "/login.xhtml?faces-redirect=true";

		employeService.addOrUpdateEmploye(new User(employeIdToBeUpdated, nom, prenom, email, password, actif, role)); 

		return navigateTo; 

	} 


	// getters and setters 

	public IEmployeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(IEmployeService employeService) {
		this.employeService = employeService;
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


	public List<User> getAllEmployes() {
		return employeService.getAllEmployes();
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public int ajouterEmploye(User employe)
	{
		employeService.addOrUpdateEmploye(employe);
		return employe.getId();
	}

	public void mettreAjourEmailByEmployeId(String email, int employeId) {
		employeService.mettreAjourEmailByEmployeId(email, employeId);

	}







	public String getEmployePrenomById(int employeId) {
		return employeService.getEmployePrenomById(employeId);
	}

	public void deleteEmployeById(int employeId) {
		employeService.deleteEmployeById(employeId);

	}
	

	public int getNombreEmployeJPQL() {

		return employeService.getNombreEmployeJPQL();
	}

	public List<String> getAllEmployeNamesJPQL() {

		return employeService.getAllEmployeNamesJPQL();
	}

	
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public List<User> getEmployes() {
		employes = employeService.getAllEmployes(); 
		return employes;
	}

	public void setEmployes(List<User> employes) {
		this.employes = employes;
	}

	public Integer getEmployeIdToBeUpdated() {
		return employeIdToBeUpdated;
	}

	public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) {
		this.employeIdToBeUpdated = employeIdToBeUpdated;
	}

	public User getAuthenticatedUser() {
		return authenticatedUser;
	}

	public void setAuthenticatedUser(User authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}

}
