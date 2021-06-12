package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Departement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Dep_Emps", joinColumns = { @JoinColumn(name = "departement_id") }, inverseJoinColumns = {
			@JoinColumn(name = "employe_id") })
	private Set<Employe> employes = new HashSet<>();
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	Entreprise entreprise;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "departement")
	private Set<Mission> Missions;

	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departement(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Set<Mission> getMissions() {
		return Missions;
	}

	public void setMissions(Set<Mission> missions) {
		Missions = missions;
	}

}
