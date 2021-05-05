package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Warranty;

@Repository
public interface IWarrantyRepositry extends CrudRepository<Warranty, Integer> {

}
