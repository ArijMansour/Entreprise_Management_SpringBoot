package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Entreprise implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String raisonSocial;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "entreprise")
	private Set<Departement> departements;

	public Entreprise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entreprise(int id, String name, String raisonSocial, Set<Departement> departements) {
		super();
		this.id = id;
		this.name = name;
		this.raisonSocial = raisonSocial;
		this.departements = departements;
	}

	public Entreprise(String name, String raisonSocial) {
		super();
		this.name = name;
		this.raisonSocial = raisonSocial;

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

	public String getRaisonSocial() {
		return raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}

	public Set<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(Set<Departement> departements) {
		this.departements = departements;
	}

	@Override
	public String toString() {
		return "Entreprise [id=" + id + ", name=" + name + ", raisonSocial=" + raisonSocial;
	}

}
