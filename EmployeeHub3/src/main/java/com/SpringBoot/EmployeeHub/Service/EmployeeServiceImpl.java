package com.SpringBoot.EmployeeHub.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.EmployeeHub.Exception.RecordNotFoundException;
import com.SpringBoot.EmployeeHub.Model.EmployeeBean;
import com.SpringBoot.EmployeeHub.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeeBean> getAllEmployees() {
		List<EmployeeBean> employeeList = employeeRepository.findAll();

		if (employeeList.size() > 0)
			return employeeList;
		else
			return new ArrayList<EmployeeBean>();

	}

	public EmployeeBean getEmployeeById(int id) throws RecordNotFoundException {
		Optional<EmployeeBean> employeeToBeRetrieved = employeeRepository.findById(id);

		if (employeeToBeRetrieved.isPresent())
			return employeeToBeRetrieved.get();
		else
			throw new RecordNotFoundException("Invalid id or no employee");

	}

	public void deleteEmployeeById(int id) throws RecordNotFoundException {
		Optional<EmployeeBean> employeeToBeDeleted = employeeRepository.findById(id);

		if (employeeToBeDeleted.isPresent())
			employeeRepository.deleteById(id);
		else
			throw new RecordNotFoundException("Invalid id or no employee");

	}
	
	public EmployeeBean updateEmployee(EmployeeBean employeeBean) throws RecordNotFoundException {

		Optional<EmployeeBean> existingEmployee = employeeRepository.findById(employeeBean.getId());
		
		EmployeeBean updatedEmployee = null;
		
		if (existingEmployee.isPresent()) {
			updatedEmployee = existingEmployee.get();
			//empUpdate.setId(employeeBean.getId());
			updatedEmployee.setName(employeeBean.getName());
			updatedEmployee.setSalary(employeeBean.getSalary());

			updatedEmployee = employeeRepository.save(updatedEmployee);
			}
		return updatedEmployee;
	}


	public EmployeeBean addEmployee(EmployeeBean employeeBean) throws RecordNotFoundException {

		Optional<EmployeeBean> employeeToBeAdded = employeeRepository.findById(employeeBean.getId());

		if (!employeeToBeAdded.isPresent()){
			employeeBean = employeeRepository.save(employeeBean);
			}
		return employeeBean;
		
	}

}
