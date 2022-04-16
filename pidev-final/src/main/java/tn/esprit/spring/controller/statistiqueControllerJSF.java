package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Rent;
import tn.esprit.spring.entities.TypeRent;
import tn.esprit.spring.services.IRentService;

@Scope(value = "session")
@Controller(value = "statistiqueControlle")
@ELBeanName(value = "statistiqueControlle")
@Join(path = "/rent.jsf", to = "/statistique.jsf")
public class statistiqueControllerJSF 
{
	

	private Date date_start;
	private Date date_end; 
	private float price ; 
	private String name_renter ; 
	private String name_owner ; 
	private TypeRent type_rent ;
	private int rentId; 
	private float averageAN; 
	private int year ; 
	
	
	
	
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public float getAverageAN() {
		return averageAN;
	}
	public void setAverageAN(float averageAN) {
		this.averageAN = averageAN;
	}
	public int getRentId() {
		return rentId;
	}
	public void setRentId(int rentId) {
		this.rentId = rentId;
	}
	
	public Date getDate_start() {
		return date_start;
	}
	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}
	public Date getDate_end() {
		return date_end;
	}
	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getName_renter() {
		return name_renter;
	}
	public void setName_renter(String name_renter) {
		this.name_renter = name_renter;
	}
	public String getName_owner() {
		return name_owner;
	}
	public void setName_owner(String name_owner) {
		this.name_owner = name_owner;
	}
	public TypeRent getType_rent() {
		return type_rent;
	}
	public void setType_rent(TypeRent type_rent) {
		this.type_rent = type_rent;
	}
	public IRentService getRentService() {
		return rentService;
	}
	public void setRentService(IRentService rentService) {
		this.rentService = rentService;
	}
	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}
	@Autowired
	IRentService rentService;
public List<Rent> rents; 
	
	public List<Rent> getRents()
	{
		return rentService.getAllRent(); 
	}
	public String AddRent()
	{	
		
		rentService.AjouterRent(new Rent(date_start, date_end, price, name_renter, name_owner, type_rent));
		return "null"; 
	}
	public void RemoveRent(int rentId)
	{
		rentService.deleteRentById(rentId);
	}
	public void DisplayRent(Rent rent)
	{
		this.setDate_start(rent.getDate_start());
		this.setDate_end(rent.getDate_end());
		this.setName_owner(rent.getName_owner());
		this.setName_renter(rent.getName_renter());
		this.setPrice(rent.getPrice());
		this.setType_rent(rent.getType_rent());
		this.setRentId(rent.getId_Rent());
	}

	public void updateRent ()
	{
		rentService.AjouterRent(new Rent(rentId, date_start, date_end, price, name_renter, name_owner, type_rent));

	}
	
	public void  Average(int year)
	{
		List<Object[]> liste; 
		double average; 

		
		liste = rentService.getMoyenRentyear(year); 
		
		
		Object[] object = liste.get(0); 
		average = (double) object[1]; 
		
		if (object.length==0)
		{
			average=0 ; 
		}
		else
		{
			
			this.setAverageAN((float) average);
		}
		 

					
	}
	
	
	
	
	

}
