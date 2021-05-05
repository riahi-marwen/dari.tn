package tn.esprit.spring.controller;

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

import tn.esprit.spring.entities.Property;
import tn.esprit.spring.services.IPropertyService;




@RestController
public class PropertyRestController {
@Autowired
IPropertyService propserv;

//        ajout property                 
@PostMapping("/addproperty")
public String AjouterProperty(@RequestBody Property property) 
{ 
	return propserv.AjouterProperty(property);
}
//        affiche property by id         
@GetMapping(value = "getpropertyById/{id}")
@ResponseBody
public Property affichePropertyById(@PathVariable("id")int Id_Property)
{
	    propserv.incrementeVue(Id_Property);
	    return propserv.affichePropertyById(Id_Property); 
}

//        retourner list property        
@GetMapping("/retrieve-all-property")
@ResponseBody
public List<Property> getProperty() {
List<Property> list = propserv.getAllContrats(); 
return list;
}
//        supprimer property       
@DeleteMapping("/deletePropertyById/{iddept}") 
@ResponseBody
public void deletePropertyById(@PathVariable("iddept") int depId) {
	propserv.deletePropertyById(depId);
}
	
//         modifier price          
	@PutMapping(value = "/modifyPrice/{id}/{newpricel}") 
	@ResponseBody
	public void mettreAjourEmailByEmployeId(@PathVariable("newpricel") float  price, @PathVariable("id") int Id_Property) {
	propserv.mettreAjourEmailByEmployeId( price, Id_Property);	
	}

//       ApproximationProperty surface && typeproperty
	
	@PutMapping(value = "/ApproximationProperty/{surface}/{typeProperty}") 
	@ResponseBody
	public void ApproximationProperty(@PathVariable("surface") float  surface, @PathVariable("typeProperty") String typeProperty)
	{
	propserv.ApproximationProperty(surface, typeProperty);	
	}
	
	



}
