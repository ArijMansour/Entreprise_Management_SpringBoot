package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.service.EmployeService;

//@RestController
public class EmployeRestController {

	@Autowired
	EmployeService employeService;

	// http://localhost:8081/SpringMVC/servlet/all-employes-names
	@GetMapping("/all-employes-names")
	@ResponseBody
	public List<String> getEmployes_Names() {
		List<String> list = employeService.getAllEmployeNamesJPQL();
		return list;
	}
	
	// http://localhost:8081/SpringMVC/servlet/Nombre-employes
	@GetMapping("/Nombre-employes")
	@ResponseBody
	public Long getNombreEmploye() {
		return employeService.getNombreEmployeJPQL();
	}
	
	// http://localhost:8081/SpringMVC/servlet/employe-prenom/{Employer-id}
	@GetMapping("/employe-prenom/{Employer-id}")
	@ResponseBody
	public String getEmployePrenomById(@PathVariable("Employer-id") String id) {
		return employeService.getEmployePrenomById(Integer.valueOf(id));
	}
	
	// http://localhost:8081/SpringMVC/servlet/add-Contrat
	@PostMapping("/add-Contrat")
	@ResponseBody
	public int ajouterContrat(@RequestBody Contrat contrat) {
		return employeService.ajouterContrat(contrat);
	}
	
	// http://localhost:8081/SpringMVC/servlet/add-Employe
	@PostMapping("/add-Employe")
	@ResponseBody
	public int ajouterEmploye(@RequestBody Employe employe) {
	  return employeService.ajouterEmploye(employe);
	}
	
	// http://localhost:8081/SpringMVC/servlet/Affecter-Contrat-Employer/{Contrat-id}/{Employer-id}
	@PutMapping("/Affecter-Contrat-Employer/{Contrat-id}/{Employer-id}")
	@ResponseBody 
	public void affecterContratAEmploye(@PathVariable("Employer-id") String employeId, @PathVariable("Contrat-id") String contratId)
	{
	  employeService.affecterContratAEmploye(Integer.valueOf(contratId), Integer.valueOf(employeId));
	}
	
	// http://localhost:8081/SpringMVC/servlet/Affecter-Employe-Departement/{Departement-id}/{Employer-id}
	@PostMapping("/Affecter-Employe-Departement/{Departement-id}/{Employer-id}")
	@ResponseBody 
	public void affecterEmployeADepartement(@PathVariable("Employer-id")String employeId,@PathVariable("Departement-id") String depId){
	  employeService.affecterEmployeADepartement(Integer.valueOf(employeId),
	  Integer.valueOf(depId)); 
	}
	
	//http:// localhost:8081/SpringMVC/servlet/employe-entreprise/{Entreprise}
	@GetMapping("/employe-entreprise/{Entreprise}")
	@ResponseBody
	public List<Employe> getEmployesByEntreprise(@PathVariable("Entreprise") Entreprise e) {
	  return employeService.getAllEmployeByEntreprise(e);
	}

}
