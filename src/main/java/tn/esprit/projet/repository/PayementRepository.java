package tn.esprit.projet.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.projet.modal.Payement;

@Repository
public interface PayementRepository extends CrudRepository<Payement , Long> {

}
