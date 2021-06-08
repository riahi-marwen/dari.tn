package com.esprit.dari.services;

import com.esprit.dari.entities.DemandeCredit;

import java.util.List;

public interface IDemandeCreditService {
public int AjouterDemandeC(DemandeCredit demandeC);

public DemandeCredit ModifierDemandeC(int IddemandeC,DemandeCredit dc);
public List<DemandeCredit> getAllDemandes();

    void SupprimerDemandeC(int IdDemande);
public DemandeCredit getDemandeCById(int Id);
public String MeilleurBanque(int idDemande);

}
