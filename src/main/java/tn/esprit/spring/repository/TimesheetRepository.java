package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Timesheet;

public interface TimesheetRepository extends CrudRepository<Timesheet,Integer> {

}
