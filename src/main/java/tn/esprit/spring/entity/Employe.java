package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Employe implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String Password;
	private boolean actif;
	private String nom;
	private String prenom;
	@Enumerated(EnumType.STRING)
	private Role role;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employes")
	private Set<Departement> departements = new HashSet<>();

	@JsonIgnore
	@OneToOne(mappedBy = "employe")
	private Contrat contrat;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employes")
	private Set<Timesheet> timesheets;

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe(int id, String email, String password, boolean actif, String nom, String prenom, Role role,
			Set<Departement> departements, Contrat contrat, Set<Timesheet> timesheets) {
		super();
		this.id = id;
		this.email = email;
		Password = password;
		this.actif = actif;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.departements = departements;
		this.contrat = contrat;
		this.timesheets = timesheets;
	}

	public Employe(String email, String password, boolean actif, String nom, String prenom, Role role) {
		super();
		this.email = email;
		Password = password;
		this.actif = actif;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
	}
	
	public Employe(String nom, String prenom, String email, String password, boolean actif, Role role) {
		super();
		this.email = email;
		Password = password;
		this.actif = actif;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
	}
	
	public Employe(int id, String nom, String prenom, String email, String password, boolean actif, Role role) {
		super();
		this.id = id;
		this.email = email;
		Password = password;
		this.actif = actif;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(Set<Departement> departements) {
		this.departements = departements;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public Set<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(Set<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}

}
