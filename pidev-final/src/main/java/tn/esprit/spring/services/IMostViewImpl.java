package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.MostView;
import tn.esprit.spring.entities.Property;
import tn.esprit.spring.repository.IMostViewRepositry;
import tn.esprit.spring.repository.IPropertyRepository;



@Service
public class IMostViewImpl  implements IMostViewService
{
 
	@Autowired
	IMostViewRepositry imost; 
	@Autowired
	IPropertyService  iprop ; 
	@Autowired
	IPropertyRepository  proprep ;
	
	
	@Override
	/* ajout de MostView */
	public int  AjouterMostView(MostView mostView)
	{
		imost.save(mostView);
	return mostView.getId_MostView();
		
	}
	
	/* supprimer MostView by id   */
	public void deleteMostViewById(int id_MostView) {
		MostView mostManagedEntity = imost.findById(id_MostView).get();
		imost.delete(mostManagedEntity);
	}
	
	/* supprimer liste de MostView */
	
	public void deleteMostView() {
		
		imost.deleteAll();
	}
	/* retourner liste de mostView   */
	public List<MostView> getAllMostView() {
		return (List<MostView>) imost.findAll();
	}
	/* affecter mostview to property*/
	public void affecterMostViewAProperty(int Id_Property, int id_MostView) {
		Property propertyManagedEntity = proprep.findById(Id_Property).get();
		MostView mostview = imost.findById(id_MostView).get();
		mostview.setProperty(propertyManagedEntity);
		imost.save(mostview);
		
	}
	/* remplir la liste de mostview automatiquement */
	public List<MostView> remplirMostView()
	{
		deleteMostView(); 
		List<Property> list = iprop.triNbVue(); 
		for (int i=0; i<list.size(); i++)
		{
			Date a = new Date(); 
			MostView most = new MostView(a); 
			int id_MostView= AjouterMostView(most); 
			affecterMostViewAProperty(list.get(i).getId_Property(),  id_MostView); 
			
		}
		return (List<MostView>) imost.findAll();
	}
	
	
}
