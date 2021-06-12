package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Entreprise;

public interface EntrepriseRepository  extends CrudRepository<Entreprise,Integer> {
	
	@Query("Select " + "DISTINCT emp from Employe emp " + "join emp.departements dps " + "join dps.entreprise entrep "
			+ "where entrep=:entreprise")
	public List<Employe> getAllEmployeByEntreprisec(@Param("entreprise") Entreprise entreprise);

	@Query("Select " + "DISTINCT AVG(cont.Salaire) from Contrat cont " + "join cont.employe emp "
			+ "join emp.departements deps " + "where deps.id=:depId")
	public Double getSalaireMoyenByDepartementId(@Param("depId") int departementId);

}
