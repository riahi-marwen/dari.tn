package edu.esprit.immo.Dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.esprit.immo.Dari.entities.Reclamation;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation,Long> {
	

}
