package com.assesment.emplmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.emplmanagement.entity.Employee;
import com.assesment.emplmanagement.repository.EmplRepo;

@Service
public class EmplServiceImpls implements EmployeeService{
	@Autowired
	private EmplRepo empRepo;
	

	@Override
	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		List<Employee> liemp = empRepo.findAll();
		return liemp;
	}

	@Override
	public Employee saveEmp(Employee emp) {
		// TODO Auto-generated method stub
		Employee emp1 = empRepo.save(emp);
		return emp1;
	}

	@Override
	public Employee updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		Employee empl = empRepo.findById(emp.getId()).get();
		empl.setFirstName(emp.getFirstName());
		empl.setLastName(empl.getLastName());
		empl.setEmail(emp.getEmail());
		empl.setDepartment(emp.getDepartment());
		empRepo.save(empl);
		return empl;
	}

	@Override
	public Employee getById(long id) {
		// TODO Auto-generated method stub
		Employee emp2 = empRepo.findById(id).get();
		return emp2;
	}

	@Override
	public String deleteEMp(long id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
		return "deleted id"+id;
		
	}

}
