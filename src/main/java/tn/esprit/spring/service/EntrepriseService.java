package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Entreprise;

public interface EntrepriseService {
	public int ajouterEntreprise(Entreprise entreprise);

	public int ajouterDepartement(Departement dep);

	void affecterDepartementAEntreprise(int depId, int entrepriseId);

	List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);
	
	public Entreprise getEntrepriseById(int entrepriseId);
	
	
}
