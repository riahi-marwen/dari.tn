package tn.esprit.projet.modal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String firstname;
	private String lastname;
	private String birthday;
	private int postalCode;
	private String city;
	private String email;
	private long phone;
	private String userName;
	private String password;
	private String location;
	//private String role;
	@Enumerated(EnumType.STRING)
	//@NotNull
	private Role role;
	private boolean actif;
	
	

	public User() {
		super();
	}
	
	public User(int id, String firstName, String lastName, String email, String password, Role role, boolean actif) {
		super();
		this.id = id;
		this.firstname = firstName;
		this.lastname = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.actif = actif;
	}

	public User(String firstName, String lastName, String email,  Role role, boolean actif) {
		super();
		this.firstname = firstName;
		this.lastname = lastName;
		this.email = email;
		this.role = role;
		this.actif = actif;
	}

	public User(String firstName, String lastName, String email, String password, Role role, boolean actif) {
		super();
		this.firstname = firstName;
		this.lastname = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.actif = actif;
	}


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

}
