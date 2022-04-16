package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Warranty;
import tn.esprit.spring.services.IWarrantyService;



@RestController
public class WarrantyRestController 
{

	@Autowired
	IWarrantyService iwarranty;
	@PostMapping("/addWarranty")
	public String AjouterWarranty(@RequestBody Warranty warranty ) {
		return iwarranty.AjouterWarranty(warranty);
    }
	/*        retourner list warranty        */
	@GetMapping("/retrieve-all-warranty")
	@ResponseBody
	public List<Warranty> getBuy() {
	List<Warranty> list = iwarranty.getAllContrats(); 
	return list;
	}
	/*        supprimer warranty       */
	@DeleteMapping("/deleteWarrantyById/{iddept}") 
	@ResponseBody
	public void deletePropertyById(@PathVariable("iddept") int depId) {
		iwarranty.deletePropertyById(depId);
	}
}
