package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Buy;


@Repository
public interface IBuyRepositry extends CrudRepository<Buy, Integer>
{

}
