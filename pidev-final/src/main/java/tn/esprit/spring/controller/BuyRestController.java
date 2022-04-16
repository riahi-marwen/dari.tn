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

import tn.esprit.spring.entities.Buy;
import tn.esprit.spring.services.IBuyService;




@RestController
public class BuyRestController {
	@Autowired
	IBuyService ibuy ; 
	
	@PostMapping("/addBuy")
	public String AjouterProperty(@RequestBody Buy buy) {
		return ibuy.AjouterBuy(buy);
}
	//        retourner list Buy 
	@GetMapping("/retrieve-all-Buy")
	@ResponseBody
	public List<Buy> getBuy() {
	List<Buy> list = ibuy.getAllContrats(); 
	return list;
	}
	//        supprimer Buy 
	@DeleteMapping("/deleteBuyById/{iddept}") 
	@ResponseBody
	public void deletePropertyById(@PathVariable("iddept") int depId) {
		ibuy.deletePropertyById(depId);
	}
		
}
