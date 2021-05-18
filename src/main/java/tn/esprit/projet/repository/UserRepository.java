package tn.esprit.projet.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.projet.modal.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	User findByUserName(String userName);
public User getUserByEmailAndPassword(String login, String password);



/*@Query("SELECT e FROM Employe e WHERE e.email=:email and e.password=:password")
public User getEmployeByEmailAndPassword(@Param("email")String login,
@Param("password")String password);*/

/*@Query("SELECT e FROM User e WHERE e.email=:email and e.password=:password")
public User getUserByEmailAndPassword(@Param("email")String login, @Param("password")String password);
@Query("SELECT count(*) FROM User")
public int countuser();

@Query("SELECT nom FROM User")
public List<String> userNames();*/
}
