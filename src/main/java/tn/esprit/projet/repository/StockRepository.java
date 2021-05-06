package tn.esprit.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.projet.modal.Stock;



@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
