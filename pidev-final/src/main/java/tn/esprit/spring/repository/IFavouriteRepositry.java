package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Favourite;


@Repository
public interface IFavouriteRepositry extends CrudRepository<Favourite, Integer> 
{

}
