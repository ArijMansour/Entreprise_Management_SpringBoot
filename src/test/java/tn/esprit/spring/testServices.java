package tn.esprit.spring;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.entity.MissionExterne;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.service.EmployeService;
import tn.esprit.spring.service.EntrepriseService;
import tn.esprit.spring.service.TimesheetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testServices {

	@Autowired
	EmployeService employeService;
	@Autowired
	EntrepriseService entrepriseService;
	@Autowired
	TimesheetService timesheetService;
	@Autowired
	MissionRepository missionRepository;

	@Test
	public void testAddEmploye() throws ParseException {
		/*
		Employe e3 = new Employe("dana.jaziri@Visteon.tn", 1, "dana", "jaziri", Role.INGENIEUR);
		Employe e4 = new Employe("nourane.mansour@Visteon.tn", 1, "nourane", "mansour", Role.CHEF_DEPARTEMENT);*/
		Employe e = new Employe("arij@esprit.tn","12345678", true, "mansour", "arij", Role.ADMINISTRATEUR);

		employeService.ajouterEmploye(e);
		/*
		employeService.ajouterEmploye(e1);
		employeService.ajouterEmploye(e2);
		*/
	}

	@Test
	public void testAddEntreprise() throws ParseException {
		Entreprise entreprise = new Entreprise("Visteon", "El Ghazela");
		entrepriseService.ajouterEntreprise(entreprise);
	}

	@Test
	public void testAddDeparetment() throws ParseException {
		Departement dep = new Departement();
		dep.setName("RH");
		entrepriseService.ajouterDepartement(dep);
	}

	@Test
	public void testAddContrat() throws ParseException {
		Contrat c1 = new Contrat(new Date(), 1600, "CDI");
		Contrat c2 = new Contrat(new Date(), 2600, "CDI");
		Contrat c3 = new Contrat(new Date(), 900, "CDI");
		Contrat c4 = new Contrat(new Date(), 2000, "CDI");
		Contrat c5 = new Contrat(new Date(), 2700, "CDI");

		employeService.ajouterContrat(c1);
		employeService.ajouterContrat(c2);
		employeService.ajouterContrat(c3);
		employeService.ajouterContrat(c4);
		employeService.ajouterContrat(c5);
	}

	@Test
	public void testAddMission() throws ParseException {
		MissionExterne m1 = new MissionExterne("Developement", "",
				"facturationvis.tn", "1000");
		MissionExterne m2 = new MissionExterne("Fixation", "",
				"facturation@orange.tn", "475");
		Mission m3 = new Mission("Maintenance", "");

		missionRepository.save(m1);
		missionRepository.save(m2);
		missionRepository.save(m3);

	}

}
