package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Buy;
import tn.esprit.spring.repository.IBuyRepositry;


@Service
public class IBuyImpl implements IBuyService
{
	@Autowired
	IBuyRepositry ibuy ; 
	@Override
	/* ajout */
	public String AjouterBuy(Buy buy) 
	{
		ibuy.save(buy);
		return "the property is aded successfyly";
	}
	/* supprimer Buy  */
	public void deletePropertyById(int id_warranty) {
		Buy buyManagedEntity = ibuy.findById(id_warranty).get();
		ibuy.delete(buyManagedEntity);
	}
	
	/* retourner liste de Buy  */
	public List<Buy> getAllContrats() {
		return (List<Buy>) ibuy.findAll();
	}
	/* modifier le title de Buy  */
	public void mettreAjourPriceBuy(float  price ,   int id_buy) 
	{
		Buy buy  = ibuy.findById(id_buy).get();
		buy.setPrice(price);
		ibuy.save(buy);
	}
	
	

}
