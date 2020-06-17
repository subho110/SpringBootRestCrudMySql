package com.SpringBoot.EmployeeHub.Service;

import java.util.List;
import com.SpringBoot.EmployeeHub.Exception.RecordNotFoundException;
import com.SpringBoot.EmployeeHub.Model.EmployeeBean;

public interface EmployeeService {

	public EmployeeBean addEmployee(EmployeeBean employeeBean) throws RecordNotFoundException;

	public EmployeeBean updateEmployee(EmployeeBean employeeBean) throws RecordNotFoundException;

	List<EmployeeBean> getAllEmployees();

	public void deleteEmployeeById(int id) throws RecordNotFoundException;

	public EmployeeBean getEmployeeById(int id) throws RecordNotFoundException;

}
