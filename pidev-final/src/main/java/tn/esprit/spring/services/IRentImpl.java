package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Rent;
import tn.esprit.spring.repository.IRentRepositry;

@Service
public class IRentImpl implements IRentService 
{
	@Autowired
	IRentRepositry  iRent ; 
	

	/* ajout Rent */
	public String AjouterRent(Rent rent) 
	{
		iRent.save(rent);
		return "the property is aded successfyly";	
	}
	
	/* supprimer Rent */
	public void deleteRentById(int Id_Rent) {
		Rent rentManagedEntity = iRent.findById(Id_Rent).get();
		iRent.delete(rentManagedEntity);
	}
	
	/* retourner liste de rent  */
	public List<Rent> getAllRent() {
		return (List<Rent>) iRent.findAll();
	}
	
	/* modifier le title de rent  */
	public void mettreAjourTitleByWarrantyId(float  price ,   int Id_Rent) 
	{ 
		Rent rent  = iRent.findById(Id_Rent).get();
		rent.setPrice(price);
		iRent.save(rent);
	}
	/* retourner liste entre deux dates */
	public List<Rent> getallRentbetwendate(Date d1, Date d2) {
		
		return iRent.getallRentbetwendate(d1, d2); 
	}
	/* find  rent by date    */
	public List<Rent> findByDateRent(Date d1)
	{
		return iRent.findByDatereglement(d1); 
	}
	/* retourner list de rent sup en 1000 */
	public List<Rent> getRentlBytotalfinalsup(float a )
	{
		return iRent.getRentlBytotalfinalsup(a); 
	}
	
	/* retourner le nombre de rent */
	public int retournerListRent()
	{
		return (int) iRent.count(); 
	}
	/* retourner de rent par jour */
	 public List<Object[]> getMoyenRentJour(int a, int m, int j)
	 {
		 return iRent.getMoyenRentJour(a, m, j) ; 
	 }
	 /* retouner de rent par mois */
	 public List<Object[]> getMoyenRentMonth( int a, int m)
	 {
		return iRent.getMoyenRentMonth(a, m) ; 
	 }
	 /* retourner de rent par années */
	 public List<Object[]> getMoyenRentyear( int  a) 
	 {
		 return iRent.getMoyenRentyear(a);
	 }

	
	
}
