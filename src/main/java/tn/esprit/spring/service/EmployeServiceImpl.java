package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EmployeServiceImpl implements EmployeService {
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository departementRepository;
	@Autowired
	ContratRepository contratRepository;
	@Autowired
	EntrepriseRepository entrepriseRepository;

	@Autowired
	EntrepriseService entrepriseService;

	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

	@Override
	public int ajouterEmploye(Employe employe) {
		l.info("employe user : " + employe);
		employeRepository.save(employe);
		return 1;
	}

	@Override
	public void affecterEmployeADepartement(int employeId, int depId) {
		Employe e = employeRepository.findById(employeId).get();
		Departement d = departementRepository.findById(depId).get();
		d.getEmployes().add(e);
		e.getDepartements().add(d);

		departementRepository.save(d);

	}

	@Override
	public int ajouterContrat(Contrat contrat) {
		contratRepository.save(contrat);
		return 0;
	}

	@Override
	public void affecterContratAEmploye(int contratId, int employeId) {
		Contrat c = contratRepository.findById(contratId).get();
		Employe e = employeRepository.findById(employeId).get();
		c.setEmploye(e);
		contratRepository.save(c);

	}

	@Override
	public String getEmployePrenomById(int employeId) {
		Employe e = employeRepository.findById(employeId).get();
		return e.getPrenom();
	}

	@Override
	public long getNombreEmployeJPQL() {
		// TODO Auto-generated method stub
		return Long.valueOf(employeRepository.getNombreEmployeJPQL());
	}

	@Override
	public List<String> getAllEmployeNamesJPQL() {

		return employeRepository.getAllEmployeNamesJPQL();
	}

	@Override
	public List<Employe> getAllEmployeByEntreprise(Entreprise e) {

		return entrepriseRepository.getAllEmployeByEntreprisec(e);
	}

	@Override
	public Double getSalaireMoyen(int depId) {
		return entrepriseRepository.getSalaireMoyenByDepartementId(depId);
	}

	@Override
	public Employe authenticate(String login, String password) {
		return employeRepository.getEmployeByEmailAndPassword(login, password);
	}

	@Override
	public int addOrUpdateEmploye(Employe employe) {
		employeRepository.save(employe);
		return employe.getId();
	}
	
	@Override
	public List<Employe> getAllEmployes() {
	return (List<Employe>) employeRepository.findAll();
	}

	@Override
	public void deleteEmployeById(int employeId) {
		employeRepository.deleteById(employeId);
		
	}

	@Override
	public List<Contrat> getAllContrats() {
		return (List<Contrat>) contratRepository.findAll();
	}

	@Override
	public int addOrUpdateContrat(Contrat contrat) {
		contratRepository.save(contrat);
		return contrat.getReference();
	}
	
	

}
