package tn.esprit.spring.control;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.service.EmployeService;

@Scope(value = "session")
@Controller(value = "employeController")
@ELBeanName(value = "employeController")
@Join(path = "/", to = "/login.jsf")
public class ControllerEmployeImpl {

	@Autowired
	EmployeService employeService;

	private String login;
	private String password;
	private Employe employe;
	private String prenom;
	private String nom;
	private String email;
	private boolean actif;
	private Role role;
	private Boolean loggedIn;
	private Employe authenticatedUser;
	private Contrat contrat;
	private Date dateDebut;
	private float Salaire;
	private String typeContrat;

	private List<Employe> employes;

	private List<Contrat> contrats;

	private Integer employeIdToBeUpdated;

	public Integer getEmployeIdToBeUpdated() {
		return employeIdToBeUpdated;
	}

	public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) {
		this.employeIdToBeUpdated = employeIdToBeUpdated;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public List<Contrat> getContrats() {
		contrats = employeService.getAllContrats();
		return contrats;
	}

	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public float getSalaire() {
		return Salaire;
	}

	public void setSalaire(long salaire) {
		Salaire = salaire;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Employe getAuthenticatedUser() {
		return authenticatedUser;
	}

	public void setAuthenticatedUser(Employe authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Employe> getEmployes() {
		employes = employeService.getAllEmployes();
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public String doLogin() {
		String navigateTo = "null";
		Employe authenticatedUser = employeService.authenticate(login, password);
		if (authenticatedUser != null && authenticatedUser.getRole() == Role.ADMINISTRATEUR) {
			navigateTo = "/pages/admin/welcome.xhtml?faces-redirect=true";
			loggedIn = true;
		} else {
			FacesMessage facesMessage =

					new FacesMessage("Login Failed: please check your username/password and try again.");

			FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		}
		return navigateTo;
	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}

	public void addEmploye() {
		//String navigateTo ="null";
		//if (authenticatedUser==null || !loggedIn) return "/login.xhtml";
		employeService.addOrUpdateEmploye(new Employe(nom, prenom, email, password, actif, role));
		//return navigateTo;
	}

	public void addContrat() {
		employeService.addOrUpdateContrat(new Contrat(employe, dateDebut, Salaire, typeContrat));
	}

	public Role[] getRoles() {
		return Role.values();
	}

	public void removeEmploye(int employeId) {
		employeService.deleteEmployeById(employeId);
	}

	public void displayEmploye(Employe empl) {
		this.setPrenom(empl.getPrenom());
		this.setNom(empl.getNom());
		this.setActif(empl.isActif());
		this.setEmail(empl.getEmail());
		this.setRole(empl.getRole());
		this.setPassword(empl.getPassword());
		this.setEmployeIdToBeUpdated(empl.getId());
	}

	public void updateEmploye() {
		employeService.addOrUpdateEmploye(new Employe(employeIdToBeUpdated, nom, prenom, email, password, actif, role));
	}

}
