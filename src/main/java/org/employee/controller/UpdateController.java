package org.employee.controller;

import java.io.IOException;
import java.util.List;

import org.employee.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ord.employee.model.Employee;

@Controller
public class UpdateController {

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping(value = "/update/{id}")
	public ModelAndView findStudentById(ModelAndView model, @PathVariable("id") int id)
			throws IOException {

		List<Employee> listEmployee = employeeDao.findEmployeeById(id);
		model.addObject("listEmployee", listEmployee);
		model.setViewName("update");

		return model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateStudent(@RequestParam("id") int id,@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname , @RequestParam("email") String email,
			@RequestParam("hobby") String hobby,@RequestParam("phonenumber") Long phonenumber, ModelAndView mv) {

		Employee employee = new Employee();
		
		employee.setId(id);
		employee.setFirstname(firstname);
		employee.setLastname(lastname);
		employee.setEmail(email);
		employee.setHobby(hobby);
		employee.setPhonenumber(phonenumber);
		int counter = employeeDao.update(employee);

		if (counter > 0) {
			mv.addObject("msg", "Student records updated against student id: " + employee.getId());
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("update");

		return mv;
	}
}
