package tn.esprit.projet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet.modal.Facture;
import tn.esprit.projet.repository.FactureRepository;

import java.util.List;

@Service
public class FactureServiceImpl implements FactureService {

    @Autowired
    FactureRepository factureRepository;

    @Override
    public Facture addFacture(Facture facture) {
        factureRepository.save(facture) ;
        return facture;
    }

    @Override
    public String DeleteFacture(long id) {
        factureRepository.delete(factureRepository.findById((long) id).get());
        return "Deleted";
    }

    @Override
    public Facture updateFacture(Facture facture) {
        factureRepository.save(facture);
        return facture;
    }

    @Override
    public List<Facture> retrieveAllFacture() {
        List<Facture> factures=(List<Facture>)factureRepository.findAll();
        return factures;
    }

    @Override
    public Facture findById(long id) {
        return this.factureRepository.findById(id).orElse(null);
    }
}
