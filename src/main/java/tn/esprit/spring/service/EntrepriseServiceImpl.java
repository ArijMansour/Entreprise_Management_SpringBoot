package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {
	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Autowired
	DepartementRepository departementRepository;

	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);

	@Override
	public int ajouterEntreprise(Entreprise entreprise) {
		l.info("entreprise  : " + entreprise);
		entrepriseRepository.save(entreprise);
		return 1;
	}

	@Override
	public int ajouterDepartement(Departement dep) {
		l.info("Departement  : " + dep);
		departementRepository.save(dep);

		return 0;
	}

	@Override
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		Departement dep = departementRepository.findById(depId).get();
		Entreprise e = entrepriseRepository.findById(entrepriseId).get();
		l.info("Departement  : " + e);
		dep.setEntreprise(e);
		departementRepository.save(dep);

	}

	@Override
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		List<Departement> departments = (List<Departement>) departementRepository.findAll();

		List<String> names = new ArrayList<String>();
		for (Departement dep : departments) {

			if (dep.getEntreprise().getId() == entrepriseId) {
				names.add((String) dep.getName());

			}
		}
		return names;
	}

	//@Override
	public Entreprise getEntrepriseById(int entrepriseId) {
		return 	entrepriseRepository.findById(entrepriseId).get();
	}
	
	

}
