package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Rent;



public interface IRentService 
{
	public String AjouterRent(Rent rent) ; 
	public void deleteRentById(int Id_Rent) ; 
	public List<Rent> getAllRent() ; 
	public void mettreAjourTitleByWarrantyId(float  price ,   int Id_Rent) ; 
	public List<Rent> getallRentbetwendate(Date d1, Date d2); 
	public List<Rent> findByDateRent(Date d1); 
	public List<Rent> getRentlBytotalfinalsup(float a );
	public int retournerListRent(); 
	public List<Object[]> getMoyenRentJour(int a, int m, int j);
	public List<Object[]> getMoyenRentMonth( int a, int m); 
	public List<Object[]> getMoyenRentyear( int  a) ; 	



}
