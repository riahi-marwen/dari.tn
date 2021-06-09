package tn.esprit.projet.modal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name="produits")
public class Produit {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long idProduit;
    
    @ManyToOne
    @JoinColumn(name="idCategory",referencedColumnName = "idCategory", updatable = false)
    private Category categoryProduit;
    
    private Double note;
    private Double priceProduit;
    private String nameProduit;
    
    private  String codeabarraProduit ;
    
    @OneToOne(mappedBy = "produit")
    private UploadFile image ;
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
    private Date dateCreation;
    
 
	private  int quantity;
    
   
	public Produit() {
		super();
		
	}

	public Produit(Double note, Double priceProduit, String nameProduit, Date dateCreation, int quantity) {
		super();
		this.note = note;
		this.priceProduit = priceProduit;
		this.nameProduit = nameProduit;
		this.dateCreation = dateCreation;
		this.quantity = quantity;
	}

	public Produit(Long produitIdToBeUpdated, Double note2, Double priceProduit2, String nameProduit2,
			Date dateCreation2, int quantity2) {
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", categoryProduit=" + categoryProduit + ", priceProduit="
				+ priceProduit + ", nameProduit=" + nameProduit + ", codeabarraProduit=" + codeabarraProduit + ", image="
				+ image + ", dateCreation=" + dateCreation + "]";
	}


	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public Category getCategoryProduit() {
		return categoryProduit;
	}
	public void setCategoryProduit(Category categoryProduit) {
		this.categoryProduit = categoryProduit;
	}

	public Double getPriceProduit() {
		return priceProduit;
	}

	public void setPriceProduit(Double priceProduit) {
		this.priceProduit = priceProduit;
	}

	public String getNameProduit() {
		return nameProduit;
	}

	public void setNameProduit(String nameProduit) {
		this.nameProduit = nameProduit;
	}

	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getCodeabarraProduit() {
		return codeabarraProduit;
	}
	public void setCodeabarraProduit(String codeabarraProduit) {
		this.codeabarraProduit = codeabarraProduit;
	}

	public UploadFile getImage() {
		return image;
	}

	public void setImage(UploadFile image) {
		this.image = image;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Double getNote() {
		return note;
	}



	public void setNote(Double note) {
		this.note = note;
	}
	
	}


