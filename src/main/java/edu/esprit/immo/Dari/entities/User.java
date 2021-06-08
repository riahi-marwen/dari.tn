package edu.esprit.immo.Dari.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




 @Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(name = "User_Name")
	public String name;

	@Column(name = "usr_lastName")
	public String lastName;

	@Column(name = "Phone")
	public int phone;

	@Column(name = "Adress")
	public String adress;

	@Column(name = "Email")
	public String email;

	@Column(name = "Password")
	public String password;

	@Enumerated(EnumType.STRING)
	Role role;

	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
	private Set<Property> properties;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
	public Set<Commande> commandes ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
	public Set<Meuble> meubles ; 
	
	

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	public Set<Property> getProperties() {
		return properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
		
	}
	

	public Set<Meuble> getMeubles() {
		return meubles;
	}

	public void setMeubles(Set<Meuble> meubles) {
		this.meubles = meubles;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String name, String lastName, int phone, String adress, String email, String password,
			Role role, Set<Property> properties, Set<Commande> commandes,
			Set<Meuble> meubles) {
		super();
		this.userId = userId;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.adress = adress;
		this.email = email;
		this.password = password;
		this.role = role;
		
		this.properties = properties;
		this.commandes = commandes;
		this.meubles = meubles;
	}

	

	
}
