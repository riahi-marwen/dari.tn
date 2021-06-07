package tn.esprit.projet.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table (name="categories")

public class Category {

	
	
	@Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long idCategory;
	@NotBlank
    private String nameCategory;
    
    
    
	
	public Category(Long idCategory, @NotBlank String nameCategory) {
		super();
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
	}
	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", nameCategory=" + nameCategory + "]";
	}
	public Category(String nameCategory) {
		super();
		this.nameCategory = nameCategory;
	}
	public Category() {
		super();
	}
	public Long getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
    
    
    
    
    
    
}
