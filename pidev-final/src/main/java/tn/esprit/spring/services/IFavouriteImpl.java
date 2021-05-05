package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Favourite;
import tn.esprit.spring.entities.Property;
import tn.esprit.spring.repository.IFavouriteRepositry;
import tn.esprit.spring.repository.IPropertyRepository;


@Service
public class IFavouriteImpl  implements IFavouriteService
{
	@Autowired
	IFavouriteRepositry ifavourite ; 
	@Autowired
	IPropertyRepository iproperty; 
	
	/* remplir automatiquement favourite */
	public void  remplirAutomatiquement () 
	{
		
	}
	
	/* ajouut */
	@Override
	public String AjouterFavourite(Favourite favourite)
	{
		ifavourite.save(favourite);
		return "the property is aded successfyly";
	}
	
	/* supprimer favourite by id   */
	public void deletePropertyById(int id_fav) {
		Favourite favouriteManagedEntity = ifavourite.findById(id_fav).get();
		ifavourite.delete(favouriteManagedEntity);
	}
	
	/* supprimer liste de favourite */
	
	public void deleteFavourite() {
		
		ifavourite.deleteAll();
	}
	/* retourner liste de favourite   */
	public List<Favourite> getAllContrats() {
		return (List<Favourite>) ifavourite.findAll();
	}
	/* modifier la date  de favourite   */
	public void mettreAjourPriceBuy(String   date_fav  ,   int id_fav) 
	{
		Favourite favourite  = ifavourite.findById(id_fav).get();
		favourite.setDate_fav(date_fav);
		ifavourite.save(favourite);
	}
	
	/* affecter favourite a un property*/	
	public void affecterFavouriteAProperty(int id_fav, int Id_Property) {
		Favourite FavManagedEntity = ifavourite.findById(id_fav).get();
		Property  PropManagedEntity = iproperty.findById(Id_Property).get();

		if(FavManagedEntity.getPropertys() == null){

			List<Property> propertys = new ArrayList<>();
			propertys.add(PropManagedEntity);
			FavManagedEntity.setPropertys(propertys);
		}else{

			FavManagedEntity.getPropertys().add(PropManagedEntity);
		} 
     }
	
	/* desaffecter favourite a un property*/
	public void desaffecterFavouriteDuProperty(int id_fav, int Id_Property)
	{
		Favourite fav = ifavourite.findById(id_fav).get();

		int propertNB = fav.getPropertys().size();
		for(int index = 0; index < propertNB; index++){
			if(fav.getPropertys().get(index).getId_Property() == Id_Property){
				fav.getPropertys().remove(index);
				break;
			}
		}
	}
	
	
	

}
