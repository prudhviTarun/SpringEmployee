package org.employee.controller;

import java.io.IOException;
import java.util.List;

import org.employee.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ord.employee.model.Employee;

@Controller
public class ReadEmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping(value = "/read")
	public ModelAndView readStudent(ModelAndView model) throws IOException {

		List<Employee> listEmployee = employeeDao.read();
		model.addObject("listEmployee", listEmployee);
		model.setViewName("read");

		return model;
	}
}
