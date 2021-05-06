package tn.esprit.projet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projet.modal.Facture;

@Repository
public interface FactureRepository extends CrudRepository<Facture,Long> {


}
