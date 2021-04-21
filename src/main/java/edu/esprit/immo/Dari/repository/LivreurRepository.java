package edu.esprit.immo.Dari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.esprit.immo.Dari.entities.Livreur;

@Repository
public interface LivreurRepository extends JpaRepository<Livreur,Integer>{

}
