package edu.esprit.immo.Dari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.esprit.immo.Dari.entities.Livraison;
import edu.esprit.immo.Dari.entities.Livreur;
import edu.esprit.immo.Dari.entities.Secteur;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison,Integer> {
	@Query("SELECT u FROM Livreur u WHERE u.secteur= ?1 AND u.disponnible=1 ")
	 Livreur getcode(Secteur adresse  );

}
