package com.assesment.emplmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assesment.emplmanagement.entity.Employee;

@Service 
public interface EmployeeService {
	public List<Employee> getAllEmp();
	public Employee saveEmp(Employee emp);
	public Employee updateEmp(Employee emop);
	public Employee getById(long id);
	public String deleteEMp(long id);
}
