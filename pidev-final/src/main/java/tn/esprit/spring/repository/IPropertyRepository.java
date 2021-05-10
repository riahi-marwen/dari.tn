package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Property;


@Repository
public interface IPropertyRepository extends CrudRepository<Property, Integer>
{
	@Query("select p from Property p order by nbVue DESC ")
	public List<Property> getTriNbvueProperty();
	@Query("select p from Property p order by price DESC ")
	public List<Property> getTripriceProperty();

}
