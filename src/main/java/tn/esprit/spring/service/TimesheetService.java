package tn.esprit.spring.service;

import java.util.Date;

import tn.esprit.spring.entity.Mission;

public interface TimesheetService {
	public int ajouterMission(Mission mission);

	public void affecterMissionADepartement(int missionId, int depId);

	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin);
}
