package edu.esprit.immo.Dari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.esprit.immo.Dari.entities.Livraison;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison,Integer> {

}
