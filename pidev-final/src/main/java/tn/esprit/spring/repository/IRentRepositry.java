package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Rent;





@Repository
public interface IRentRepositry extends CrudRepository<Rent, Integer> 
{
	
	@Query("select DISTINCT b from Rent b where b.date_start between :d1 and :d2")
	public List<Rent> getallRentbetwendate( @Param("d1")Date d1, @Param("d2")Date d2);
	
	@Query("select DISTINCT b from Rent b where b.date_start=:dreglmt")
	public List<Rent> findByDatereglement(@Param("dreglmt") Date datereglmt);
	
	@Query("select DISTINCT b from Rent b where b.price >= :pricee")
	public List<Rent> getRentlBytotalfinalsup(@Param("pricee") Integer pricee );
	
	/* retourner le nombre de Rent */
	@Query("select count(p) from Rent p ")
	public long count();

	//la moyenne de Rent  par jour 
		 @Query("select HOUR(s.date_start) , coalesce(avg(s.price),0) from Rent s where  YEAR(s.date_start)=:a and MONTH(s.date_start)=:m and DAY(s.date_start)=:j group by HOUR(s.date_start)")
		 public List<Object[]> getMoyenRentJour(@Param("a")Integer a, @Param("m")Integer m, @Param("j")Integer j);
	//la moyenne de rent   par mois
		@Query("select DAY(s.date_start) , coalesce(avg(s.price),0) from Rent s where YEAR(s.date_start)=:a and MONTH(s.date_start)=:m group by DAY(s.date_start)")
		public List<Object[]> getMoyenRentMonth( @Param("a")Integer a, @Param("m")Integer m); 
	//la moyenne de location  par année
		@Query("select MONTH(s.date_start) , coalesce(avg(s.price),0) from Rent s where YEAR(s.date_start)=:a group by MONTH(s.date_start)")
		public List<Object[]> getMoyenRentyear( @Param("a")Integer a);
	
}
