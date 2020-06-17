package com.SpringBoot.EmployeeHub.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.EmployeeHub.Exception.RecordNotFoundException;
import com.SpringBoot.EmployeeHub.Model.EmployeeBean;
import com.SpringBoot.EmployeeHub.Service.EmployeeService;

@RestController
@RequestMapping("/EmpCompany")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	/* Save an employee into db */
	@PostMapping("/addEmpployees")
	public EmployeeBean createEmployee(@RequestBody EmployeeBean emp) throws RecordNotFoundException {
		return employeeService.addEmployee(emp);
	}

	/* Save an employee into db */
	@PutMapping("/updateEmployee")
	public EmployeeBean updateEmployee(@RequestBody EmployeeBean emp) throws RecordNotFoundException {
		return employeeService.updateEmployee(emp);
	}

	@GetMapping("/getAllEmployees")
	public List<EmployeeBean> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/getOneEmployee/{id}")
	public EmployeeBean getEmployeeById(@PathVariable int id) throws RecordNotFoundException {
		// EmployeeBean emp = employeeService.getEmployeeById(id);
		return employeeService.getEmployeeById(id);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public HttpStatus deleteEmployee(@PathVariable int id) throws RecordNotFoundException {
		employeeService.deleteEmployeeById(id);
		return HttpStatus.FORBIDDEN;
	}
}
