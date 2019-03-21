package org.employee.restController;

import java.util.List;

import org.employee.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ord.employee.model.Employee;

@RestController
public class MainEmployeeController {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@RequestMapping(value="/employee", method = RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> readEmployee(){
		
		List<Employee> emp = employeeDao.read();
		
		if(emp.isEmpty())
		{
			return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Employee>(HttpStatus.OK);	
		
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<Void> postEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder){
		System.out.println("CREATE EMPLOYEE" + employee.getFirstname());
		   
	 
		employeeDao.create(employee);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
	    
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	 @RequestMapping(value="/update/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
	 public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Employee employee){
	  employee.setId(id);
	  employeeDao.update(employee);
	  
	  HttpHeaders headers = new HttpHeaders();
	  return new ResponseEntity<Void>(headers, HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<Employee> deleteUser(@PathVariable("id") int id) {
			System.out.println("Fetching & Deleting User with id " + id);

			List<Employee> employee = employeeDao.findEmployeeById(id);
			if (employee == null) {
				System.out.println("Unable to delete. User with id " + id + " not found");
				return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
			}

			employeeDao.delete(id);
			return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		}
	
	

}
