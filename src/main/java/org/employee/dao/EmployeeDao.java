package org.employee.dao;

import java.util.List;

import ord.employee.model.Employee;

public interface EmployeeDao {

	
	public int create(Employee employee);

	public List<Employee> read();

	public List<Employee> findEmployeeById(int id);

	public int update(Employee employee);

	public int delete(int id);
}
