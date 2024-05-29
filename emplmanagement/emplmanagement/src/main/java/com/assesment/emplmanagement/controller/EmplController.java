package com.assesment.emplmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assesment.emplmanagement.entity.Employee;
import com.assesment.emplmanagement.service.EmployeeService;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@Transactional
public class EmplController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getemp")
	public String getEmp(Model model) {
		model.addAttribute("employees", new Employee());
		return "Addemp";
	}
	@PostMapping("/employeeaction")
	public String getEmployee(@Valid @ModelAttribute("employees") Employee emp, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "Addemp";
		}
		employeeService.saveEmp(emp);
		model.addAttribute("msg", "employee added successfully..");
		return "Addemp";
	}
	@GetMapping("/allemps")
	public String getAllEmps(Model model) {
		List<Employee> ExistingEmp = employeeService.getAllEmp();
		model.addAttribute("employees", ExistingEmp);
		return "Existingemp";
	}
	@PostMapping("/employee/delete")
	public String deleteEmp(@RequestParam("id") long id) {
		employeeService.deleteEMp(id);
		return "redirect:/allemps";
	}
	@PostMapping("/employee/update")
	public String updateEmp(@RequestParam("id") long id,Model model) {
		Employee emp = employeeService.getById(id);
		model.addAttribute("employee", emp);
		return "update_emp";
	}
	@PostMapping("/employee/upedit")
	public String getEmpUpdate(@Valid @ModelAttribute("employee") Employee employee, BindingResult br, Model model) {
	    if (br.hasErrors()) {
	        return "update_emp";
	    }
	    employeeService.saveEmp(employee);
	    return "redirect:/allemps";
	}
}
