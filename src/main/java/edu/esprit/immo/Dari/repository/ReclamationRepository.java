package edu.esprit.immo.Dari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.esprit.immo.Dari.entities.Reclamation;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation,Long> {
	
	//@Query("select DISTINCT b from reclamations b where b.codepostal = :codepostal")
	//public List<Reclamation> getReclamationByCode(@Param("codepostal") String codepostal );
	
	//@Query("SELECT r FROM reclamations r WHERE r.nom LIKE %:nom%")
	//List<Reclamation> getReclamationByCode(@Param("nom") String nom);
	
	//@Query("select * from Reclamation")
	//List<Reclamation> getReclamationByCode();

	//@Query("SELECT u FROM Reclamation u WHERE u.nom= ?1")
	//List<Reclamation> getReclamationByCode(Reclamation reclamation);
	
	@Query(value = "SELECT * FROM Reclamations u WHERE u.codepostal= :codepostal " , nativeQuery =true)
	List<Reclamation> getReclamationByCode(@Param("codepostal") String codepostal);
}
