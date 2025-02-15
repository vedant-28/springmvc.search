package springmvc.search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.search.entity.Student;

@Controller
public class FormController {
	
	@RequestMapping("/complex")
	public String showForm() {
		return "complex_form";
	}
	
	@RequestMapping(path="/handleform", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute("student") Student student) {
		
		System.out.println(student);
		return "success";
	}
	
}
