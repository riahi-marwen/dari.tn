package edu.esprit.immo.Dari.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.esprit.immo.Dari.entities.Reclamation;
import edu.esprit.immo.Dari.service.ReclamationService;

//@Scope(value = "session")
@Controller(value = "reclamationController")
@ELBeanName(value = "reclamationController")
@Join(path = "/", to = "/reclamation.jsf")
public class ReclamationControllerImpl {
	 @Autowired
	 ReclamationService reclamationService; 
	 public List<Reclamation> reclamations; 
	 public List<Reclamation> getReclamations(){ return reclamationService.retieveAllReclamation(); }
	 
     public Long id; 
	 private String civilite;
	 private String nom; 
	 private String prenom;
	 private String email;
	 private String tele;
	 private String address;
	 private String codepostal;
	 private String ville;
	 private String description;
	 private String comments;
	 
	 
	 
	 public ReclamationService getReclamationService() {
		return reclamationService;
	}



	public void setReclamationService(ReclamationService reclamationService) {
		this.reclamationService = reclamationService;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCivilite() {
		return civilite;
	}



	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTele() {
		return tele;
	}



	public void setTele(String tele) {
		this.tele = tele;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCodepostal() {
		return codepostal;
	}



	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}



	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getComments() {
		return comments;
	}



	public void setComments(String comments) {
		this.comments = comments;
	}


	/*CRUD -----------*/
	
	public void addReclamation() {
		// reclamationService.addOrUpdateReclamation(new Reclamation(id, civilite, nom, prenom, Email, tele, address, codepostal, ville, reclamation, comments));
        try {
       String gRecaptchaResponse = FacesContext.getCurrentInstance().
       getExternalContext().getRequestParameterMap().get("g-recaptcha-response");
       boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
       if(verify){
  		 reclamationService.addReclamation(new Reclamation(id, civilite, nom, prenom, email, tele, address, codepostal, ville, description, comments));
       }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage( null, new FacesMessage( "Select Captcha") );
         }
        } catch (Exception e) {
            System.out.println(e);
        }

        
	}
	 
	public void updateReclamation()
	{
		 reclamationService.addReclamation(new Reclamation(id, civilite, nom, prenom, email, tele, address, codepostal, ville, description, comments));
	}
	
	public void RemoveReclamation(String id)
	{
		reclamationService.deleteReclamation(id); 
	}
	
	public void DisplayReclamation(Reclamation reclamation)
	{
		this.setCivilite(reclamation.getCivilite());
		this.setNom(reclamation.getNom());
		this.setPrenom(reclamation.getPrenom());
		this.setEmail(reclamation.getEmail());
		this.setTele(reclamation.getTele());
		this.setAddress(reclamation.getAddress());
		this.setCodepostal(reclamation.getCodepostal());
		this.setVille(reclamation.getVille());
		this.setDescription(reclamation.getDescription());
		this.setComments(reclamation.getComments());
	}
	
	
	public void setReclamations(List<Reclamation> reclmations) {
		this.reclamations = reclamations;
	}
	
	
	//---------captcha------------
	
	 public String captcha(){
         try {
        String gRecaptchaResponse = FacesContext.getCurrentInstance().
        getExternalContext().getRequestParameterMap().get("g-recaptcha-response");
        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
        if(verify){
             return "Success";
        }else{
             FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage( null, new FacesMessage( "Select Captcha") );
             return null;
          }
         } catch (Exception e) {
             System.out.println(e);
         }
        return null;
     }    

}
