package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import tn.esprit.spring.entities.User;

@Repository
public interface EmployeRepository extends CrudRepository<User, Integer>  {
	
	@Query("SELECT e FROM User e WHERE e.email=:email and e.password=:password")
	public User getEmployeByEmailAndPassword(@Param("email")String login, @Param("password")String password);
	
	
	
	
	@Query("SELECT count(*) FROM User")
    public int countemp();
	
    @Query("SELECT nom FROM User")
    public List<String> employeNames();
    

    
    
    		
   

}
