package springmvc.search.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {
	
	@RequestMapping("/user/{userId}")
	public String getUserDetails(@PathVariable("userId") int userId) {
		System.out.println(userId);		
		return "home";
	}
	
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("home view loaded...");
		return "home";
	}
	
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("querybox") String query) {
		RedirectView redirectView = new RedirectView();
		String redirectUrl = "https://www.google.com/search?q=" + query;
		
		if(query.isBlank()) {
			redirectView.setUrl("home");
		} else {
			redirectView.setUrl(redirectUrl);
		}
		
		return redirectView;
	}
	
	// Controller level exception handling
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	public String exceptionHandler(Model model) {
		model.addAttribute("message", "Generic exception");
		return "exception";
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	public String nullPointerExceptionHandler(Model model) {
		model.addAttribute("message", "Null pointer exception...");
		return "exception";
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	public String numberFormatExceptionHandler(Model model) {
		model.addAttribute("message", "Number format exception...");
		return "exception";
	}
}
