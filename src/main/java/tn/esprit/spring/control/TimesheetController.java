package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.entity.Timesheet;
import tn.esprit.spring.service.TimesheetServiceImpl;

@RestController
public class TimesheetController {
	@Autowired
	TimesheetServiceImpl timesheetService;

	// http://localhost:8083/SpringMVC/servlet/add-Mission
	@PostMapping("/add-Mission")
	@ResponseBody
	public int ajouterMission(@RequestBody Mission mission) {

		return timesheetService.ajouterMission(mission);

	}

	// http://localhost:8083/SpringMVC/servlet/add-Mission
	@PostMapping("/add-Timesheet")
	@ResponseBody
	public void ajouterTimesheet(@RequestBody Timesheet Timesheet) {

		timesheetService.ajouterTimesheet(Timesheet.getMission().getId(), Timesheet.getEmployes().getId(),
				Timesheet.getDateDebut(), Timesheet.getDateFin());

	}

	// http://localhost:8083/SpringMVC/servlet/Affecter-Mission-Departement/{Departement-id}/{Mission-id}
	@PutMapping("/Affecter-Mission-Departement/{Departement-id}/{Mission-id}")
	@ResponseBody
	public void affecterMissionADepartement(@PathVariable("Mission-id") String missionId,
			@PathVariable("Departement-id") String depId) {
		timesheetService.affecterMissionADepartement(Integer.valueOf(missionId), Integer.valueOf(depId));

	}
}
