package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
public class MissionExterne extends Mission implements Serializable {

	private String emailFacturation;
	private String tauxJournalierMoyen;

	public MissionExterne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MissionExterne(int id, String name, String description, Departement departement, Set<Timesheet> timesheets) {
		super(id, name, description, departement, timesheets);
		// TODO Auto-generated constructor stub
	}

	public MissionExterne(String name, String description, Departement departement, Set<Timesheet> timesheets) {
		super(name, description, departement, timesheets);
		// TODO Auto-generated constructor stub
	}

	public MissionExterne(String name, String description, String emailFacturation, String tauxJournalierMoyen) {
		super(name, description);
		this.emailFacturation = emailFacturation;
		this.tauxJournalierMoyen = tauxJournalierMoyen;
	}

	public MissionExterne(String emailFacturation, String tauxJournalierMoyen) {
		super();
		this.emailFacturation = emailFacturation;
		this.tauxJournalierMoyen = tauxJournalierMoyen;
	}

	public String getEmailFacturation() {
		return emailFacturation;
	}

	public void setEmailFacturation(String emailFacturation) {
		this.emailFacturation = emailFacturation;
	}

	public String getTauxJournalierMoyen() {
		return tauxJournalierMoyen;
	}

	public void setTauxJournalierMoyen(String tauxJournalierMoyen) {
		this.tauxJournalierMoyen = tauxJournalierMoyen;
	}

}
