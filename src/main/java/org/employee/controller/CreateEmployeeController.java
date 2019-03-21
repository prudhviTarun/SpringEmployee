package org.employee.controller;

import org.employee.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ord.employee.model.Employee;

@Controller
public class CreateEmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createStudent(@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname , @RequestParam("email") String email,
			@RequestParam("hobby") String hobby,@RequestParam("phonenumber") Long phonenumber, ModelAndView mv) {
		
		System.out.println("in create controller");

		Employee employee = new Employee();
		employee.setFirstname(firstname);
		employee.setLastname(lastname);
		employee.setEmail(email);
		employee.setHobby(hobby);
		employee.setPhonenumber(phonenumber);

		int counter = employeeDao.create(employee);

		if (counter > 0) {
			mv.addObject("msg", "Student registration successful.");
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("create");

		return mv;
	}
}
