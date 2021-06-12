package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Timesheet implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;

	private int isValide;
	@JsonIgnore
	@ManyToOne
	Employe employes;
	
	@JsonIgnore
	@ManyToOne
	Mission mission;

	public Timesheet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Timesheet(Date dateDebut, Date dateFin, int isValide) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.isValide = isValide;
	}

	public Timesheet(Date dateDebut, Date dateFin, int isValide, Employe employes, Mission mission) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.isValide = isValide;
		this.employes = employes;
		this.mission = mission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getIsValide() {
		return isValide;
	}

	public void setIsValide(int isValide) {
		this.isValide = isValide;
	}

	public Employe getEmployes() {
		return employes;
	}

	public void setEmployes(Employe employes) {
		this.employes = employes;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

}
