package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Rent;
import tn.esprit.spring.services.IRentService;




@RestController
public class RentRestController 
{
	@Autowired
	IRentService irent;
	// add rent 
	@PostMapping("/addRent")
	public String AjouterRent(@RequestBody Rent rent )
	{
		return irent.AjouterRent(rent);
	}
	// afficher rent
	@GetMapping("/retrieve-all-Rent")
	@ResponseBody
	public List<Rent> getProperty() {
	List<Rent> list = irent.getAllRent(); 
	return list;
	}
	// supprimer rent par id 
	@DeleteMapping("/deleteRentById/{iddept}") 
	@ResponseBody
	public void deletePropertyById(@PathVariable("iddept") int depId) {
		irent.deleteRentById(depId);
	}
	
	
	
	// get all Rent  between date bill d1 and d2
	@GetMapping(value = "/getallRentbetweendate/{d1}/{d2}")
	public List<Rent> getallRentbetwendate(@DateTimeFormat(pattern = "dd-MM-yyyy")  Date d1, @DateTimeFormat(pattern = "dd-MM-yyyy") Date d2) {
		return irent.getallRentbetwendate(d1, d2); 
	}
	//calculer la moyenne des achats par jour 
	@GetMapping(value = "/getmoyenRentbyday/annee/{a}/mois/{m}/jour/{j}")
	public List<Object[]> getMoyenRentJour(@PathVariable("a")Integer a, @PathVariable("m")Integer m, @PathVariable("j")Integer j){
		return irent.getMoyenRentJour(a, m, j);
	}
	
	//calculer la moyenne des achats par mois
	@GetMapping(value = "/getmoyenbillbymonth/annee/{a}/mois/{m}")
	public List<Object[]> getMoyenRentMonth(@PathVariable("p") int idcommand,@PathVariable("a")Integer a, @PathVariable("m")Integer m) {
		return irent.getMoyenRentMonth(a, m); 
	}

	//calculer la moyenne des rent  par annÃ©e
	@GetMapping(value = "/getmoyenbillbyyear/annee/{a}")
	public List<Object[]> getMoyenBillyear(@PathVariable("a")Integer a) {
	return irent.getMoyenRentyear(a); 	
	}

	//chercher rent  par date  

	@GetMapping(value = "/getrentbydatereglement/{datereglmt}")
	public List<Rent> getRentBydatereglement(@DateTimeFormat(pattern = "dd-MM-yyyy") Date datereglmt) {
		return irent.getAllRent(); 
	}
	// aficher la list de rent superieur a 1000 dt 
	@GetMapping(value = "/getrentsup1000/{a}")
	public List<Rent> getRentsup(@PathVariable("a") float a) {
		return irent.getRentlBytotalfinalsup(a); 
	}
	
	
	
	
}
