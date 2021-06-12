package tn.esprit.spring.service;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.entity.Timesheet;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class TimesheetServiceImpl implements TimesheetService {
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository departementRepository;
	@Autowired
	EmployeRepository employeRepository;
	private static final Logger l = LogManager.getLogger(TimesheetServiceImpl.class);

	@Override
	public int ajouterMission(Mission mission) {
		missionRepository.save(mission);
		return 0;
	}

	@Override
	public void affecterMissionADepartement(int missionId, int depId) {
		Departement d = departementRepository.findById(depId).get();
		Mission m = missionRepository.findById(missionId).get();
		m.setDepartement(d);
		missionRepository.save(m);
		l.debug("Done");
	}

	@Override
	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		Employe e = employeRepository.findById(employeId).get();
		Mission m = missionRepository.findById(missionId).get();
		Timesheet t = new Timesheet(dateDebut, dateFin, 0, e, m);
		timesheetRepository.save(t);

	}

}
