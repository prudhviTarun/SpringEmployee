package org.employee.controller;

import java.io.IOException;

import org.employee.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteController {

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping(value = "/delete/{id}")
	public ModelAndView deleteStudentById(ModelAndView mv, @PathVariable("id") int id)
			throws IOException {

		int counter = employeeDao.delete(id);

		if (counter > 0) {
			mv.addObject("msg", "Student records deleted against student id: " + id);
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("delete");

		return mv;
	}

}
