package tn.esprit.projet.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.projet.modal.OrderStatus;
import tn.esprit.projet.modal.Payement;
import tn.esprit.projet.modal.PayementType;
import tn.esprit.projet.modal.Produit;
import tn.esprit.projet.modal.User;
import tn.esprit.projet.service.FactureService;
import tn.esprit.projet.service.IUserService;
import tn.esprit.projet.service.PayementService;
import tn.esprit.projet.service.ProduitService;
@Scope(value = "session")
@Controller(value = "cartController") // Name of the bean in Spring IoC
@ELBeanName(value = "cartController") // Name of the bean used by JSF
@Join(path = "/produit.jsf", to = "/cart.jsf")
public class PayementJsfController {
	
	@Autowired
	PayementService payementService;
	@Autowired 
	ProduitService produitService;
	@Autowired
	FactureService factureService;
	@Autowired
	IUserService userService;

	
	private Date createDate;
	private Integer quantity;
	private Double amount;
	private User user ;
	private Produit product ;
	@Enumerated(EnumType.STRING)
	private OrderStatus status ;
	public OrderStatus[] getOrderStatuss() { return OrderStatus.values(); }
	@Enumerated(EnumType.STRING)
	private PayementType  payementType;
	public PayementType[] getPayementTypes() { return PayementType.values(); }
	private String referenceExterne;
	private List<Payement> pay;
	private Long cartIdToBeUpdated;
	private List<Payement> pys;
	private int  test  ; 
	
	public String navigToCart()
	{
		String navigateTo = "null";
		navigateTo = "/pages/admin/cart.xhtml";
		return navigateTo;	
	}
	public String  navigToProduit()
	{
		String navigateTo = "null";
		navigateTo = "/pages/admin/produit.xhtml";
		return navigateTo;	
		
	}
	
	public List<Payement> getPys() {
		return pys;
	}
	public void setPys(List<Payement> pys) {
		this.pys = pys;
	}
	public int getTest() {
		return test;
	}
	public void setTest(int test) {
		this.test = test;
	}
	public String addCart(){
		payementService.addPayement(new Payement(createDate, quantity, product, user, amount, createDate, quantity, payementType, status, referenceExterne));
		return "null";
	}
	public void removeProduit(Long id) 
	{
		
		produitService.DeleteProduit(id); 	 
	}
	
	
	public void displayProduit (Payement payement)
	{
		this.setPayementType(payement.getPayementType());
		this.setAmount(payement.getAmount());
		this.setCreateDate(payement.getCreateDate());
		this.setProduct(payement.getProduct());
		this.setQuantity(payement.getQuantity());
		this.setUser(payement.getUser());
		this.setStatus(payement.getStatus());
		this.setReferenceExterne(payement.getReferenceExterne());
		this.setCartIdToBeUpdated(payement.getId());
		
		
		
	}
	
	public void updatecart()
	{
		payementService.addPayement(new Payement(cartIdToBeUpdated, createDate, quantity, product, user, amount, createDate, quantity, payementType, status, referenceExterne));
	}
	
	
	
	
	public Long getCartIdToBeUpdated() {
		return cartIdToBeUpdated;
	}
	public void setCartIdToBeUpdated(Long cartIdToBeUpdated) {
		this.cartIdToBeUpdated = cartIdToBeUpdated;
	}
	public List<Payement> getPay() {
		if (this.getTest()==1)
		{
			this.getPys(); 
		}
	
			return payementService.retrievePayements(); 
	}
	public void setPay(List<Payement> pay) {
		this.pay = pay;
	}
	public PayementService getPayementService() {
		return payementService;
	}
	public void setPayementService(PayementService payementService) {
		this.payementService = payementService;
	}
	public ProduitService getProduitService() {
		return produitService;
	}
	public void setProduitService(ProduitService produitService) {
		this.produitService = produitService;
	}
	public FactureService getFactureService() {
		return factureService;
	}
	public void setFactureService(FactureService factureService) {
		this.factureService = factureService;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Produit getProduct() {
		return product;
	}
	public void setProduct(Produit product) {
		this.product = product;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public PayementType getPayementType() {
		return payementType;
	}
	public void setPayementType(PayementType payementType) {
		this.payementType = payementType;
	}
	public String getReferenceExterne() {
		return referenceExterne;
	}
	public void setReferenceExterne(String referenceExterne) {
		this.referenceExterne = referenceExterne;
	}
	
	
	
}
