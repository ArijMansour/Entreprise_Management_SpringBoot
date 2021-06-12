package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Departement;

@Repository
public interface DepartementRepository extends CrudRepository<Departement,Integer>{
	
	/*@Query("SELECT "
			+ " AVG(cont.salaire) FROM Contrat cont "
			+ " join cont.Employe e "
			+ " join e.Departement dep "
			+ " WHERE dep.id=: depId")*/

}
