package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Entreprise;

public interface EmployeService {
	public int ajouterEmploye(Employe employe);

	public void affecterEmployeADepartement(int employeId, int depId);

	public int ajouterContrat(Contrat contrat);

	public void affecterContratAEmploye(int contratId, int employeId);

	public String getEmployePrenomById(int employeId);

	public long getNombreEmployeJPQL();

	public List<String> getAllEmployeNamesJPQL();
	
	public List<Employe> getAllEmployeByEntreprise(Entreprise e);

	Double getSalaireMoyen(int depId);
	
	public Employe authenticate(String login, String password) ;
	
	public int addOrUpdateEmploye(Employe employe) ;
	
	public List<Employe> getAllEmployes() ;
	
	public void deleteEmployeById(int employeId);
	
	public int addOrUpdateContrat(Contrat contrat) ;
	
	public List<Contrat> getAllContrats() ;

	
}
