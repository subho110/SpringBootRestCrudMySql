package com.SpringBoot.EmployeeHub.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "Employee")
public class EmployeeBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@NotNull
	String name;

	@NotNull
	float Salary;

}
