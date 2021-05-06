package tn.esprit.projet.service;

import tn.esprit.projet.modal.Facture;

import java.util.List;

public interface FactureService {


    Facture addFacture(Facture facture );
    String DeleteFacture(long id);
    Facture updateFacture(Facture facture);
    List<Facture> retrieveAllFacture();
    Facture findById(long id);

}
