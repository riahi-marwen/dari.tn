package edu.esprit.immo.Dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.esprit.immo.Dari.entities.Reclamation;
import edu.esprit.immo.Dari.service.ReclamationService;

@RestController
public class ReclamationRestController {
	
	@Autowired
	ReclamationService reclamationService;
	
	// http://localhost:8088/Dari/reclamation/retieveAllReclamation
	@GetMapping("/retieveAllReclamation")
	@ResponseBody
	public List<Reclamation> getReclamation() {
	List<Reclamation> list = reclamationService.retieveAllReclamation();
	return list;
	}
	
	// http://localhost:8088/Dari/reclamation/retieveReclamation/{id}
	@GetMapping("/retieveReclamation/{id}")
	@ResponseBody
	public Reclamation retieveReclamation(@PathVariable("id") String id) {
	return reclamationService.retieveReclamation(id);
	}
	
	// http://localhost:8088/Dari/reclamation/addReclamation
	@PostMapping("/addReclamation")
	@ResponseBody
	public Reclamation addReclamation (@RequestBody Reclamation Reclamation) {
	Reclamation reclamation = reclamationService.addReclamation(Reclamation);
	return reclamation;
	}
	
	// http://localhost:8088/Dari/reclamation/deleteReclamation/{id}
	@DeleteMapping("/deleteReclamation/{id}")
	@ResponseBody
	public void deleteReclamation(@PathVariable("id") String id) {
		reclamationService.deleteReclamation(id);
	}
	
	// http://localhost:8088/Dari/reclamation/updateReclamation
	@PutMapping("/updateReclamation")
	@ResponseBody
	public Reclamation updateReclamation(@RequestBody Reclamation rec) {
	return reclamationService.updateReclamation(rec);
	}
	
	
/*	@PutMapping( "/updateReclamation/{id}/{ncivilite}/{nnom}/{nprenom}/{nemail}/{ntele}/{naddress}/{ncodepostal}/{nville}/{ndescription}/{ncomments}/")
	@ResponseBody
	public void updateReclamation(@PathVariable("id") String id,
			@PathVariable("ncivilite") String civilite, @PathVariable("nnom") String nom,
			@PathVariable("nprenom") String prenom,@PathVariable("nemail") String email,@PathVariable("ntele") String tele,
			@PathVariable("naddress") String address,@PathVariable("ncodepostal") String codepostal,
			@PathVariable("nville") String ville,@PathVariable("ndescription") String description,
			@PathVariable("ncomments") String comments) {
	 reclamationService.updateReclamation(id,civilite, nom, prenom, email, tele, address, codepostal, ville, description, comments);
	}*/
}

