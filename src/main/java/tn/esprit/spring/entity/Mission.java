package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Mission")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Mission implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	
	@JsonIgnore
	@ManyToOne
	Departement departement;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "mission")
	private Set<Timesheet> timesheets;

	public Mission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mission(int id, String name, String description, Departement departement, Set<Timesheet> timesheets) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.departement = departement;
		this.timesheets = timesheets;
	}

	public Mission(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Mission(String name, String description, Departement departement, Set<Timesheet> timesheets) {
		super();
		this.name = name;
		this.description = description;
		this.departement = departement;
		this.timesheets = timesheets;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Set<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(Set<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}

}
