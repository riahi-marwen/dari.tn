package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Warranty;
import tn.esprit.spring.repository.IWarrantyRepositry;


@Service
public class IWarrantyImpl implements IWarrantyService
{
	@Autowired
	IWarrantyRepositry  iwarranty ; 
	
	@Override
	/* ajout warranty*/
	public String AjouterWarranty(Warranty warranty) 
	{
		iwarranty.save(warranty);
		return "the property is aded successfyly";	
	}
	
	/* supprimer warranty */
	public void deletePropertyById(int id_warranty) {
		Warranty warrantyManagedEntity = iwarranty.findById(id_warranty).get();
		iwarranty.delete(warrantyManagedEntity);
	}
	
	/* retourner liste de Warranty */
	public List<Warranty> getAllContrats() {
		return (List<Warranty>) iwarranty.findAll();
	}
	/* modifier le title de Warranty */
	public void mettreAjourTitleByWarrantyId(String title ,   int id_warranty) 
	{ 
		Warranty warranty = iwarranty.findById(id_warranty).get();
		warranty.setTitle(title);
		iwarranty.save(warranty);
	}
	
}
