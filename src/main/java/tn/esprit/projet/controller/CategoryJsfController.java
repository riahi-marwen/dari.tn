package tn.esprit.projet.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.projet.modal.Category;
import tn.esprit.projet.modal.Produit;
import tn.esprit.projet.service.CategoryService;
@Scope(value = "session")
@Controller(value = "catgControlle")
@ELBeanName(value = "catgControlle")
@Join(path = "/produit.jsf", to = "/category.jsf")
public class CategoryJsfController {
	@Autowired
	CategoryService categoryService;
	 private String nameCategory;
	 private List<Category> categorys;
	 private List<Category> catgs;
	 private Long categoryIdToBeUpdated;
	 private int  test  ;
	 public String  navigToCategory()
		{
			String navigateTo = "null";
			navigateTo = "/pages/admin/category.xhtml";
			return navigateTo;	
			
		}
	 
	 public String addCategory()
		{
		 categoryService.addCategory(new Category(nameCategory));
			return "null"; 
		}
	    
	    public void removeCategory(long categoryId) 
		{
			
	    	categoryService.DeleteCategory(categoryId); 	 
		}
		
		
		
		public void displayCategory (Category category)
		{
			this.setNameCategory(category.getNameCategory());
			
			
			this.setCategoryIdToBeUpdated(category.getIdCategory());
			
			
			
		}
		
		public void updateCategory()
		{
			categoryService.addCategory(new Category(categoryIdToBeUpdated,nameCategory));
		}
		

	 
	 
	 
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	public List<Category> getCategorys() {
		if (this.getTest()==1)
		{
			this.getCatgs(); 
		}
	
			return categoryService.retrieveAllCategory();
	}
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	public List<Category> getCatgs() {
		return catgs;
	}
	public void setCatgs(List<Category> catgs) {
		this.catgs = catgs;
	}
	public Long getCategoryIdToBeUpdated() {
		return categoryIdToBeUpdated;
	}
	public void setCategoryIdToBeUpdated(Long categoryIdToBeUpdated) {
		this.categoryIdToBeUpdated = categoryIdToBeUpdated;
	}
	public int getTest() {
		return test;
	}
	public void setTest(int test) {
		this.test = test;
	} 
	 
	 

}
