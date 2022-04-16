package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.MostView;



@Repository
public interface IMostViewRepositry extends CrudRepository<MostView, Integer>
{

}
