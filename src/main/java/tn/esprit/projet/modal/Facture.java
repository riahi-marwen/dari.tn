package tn.esprit.projet.modal;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Facture {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idFacture;

    @ManyToOne
    private User user;

    private Date dateCreation ;

    private  double amount ;

    @ManyToOne
    private Produit idProduit;

    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Produit getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Produit idProduit) {
        this.idProduit = idProduit;
    }

    public Facture() {
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
