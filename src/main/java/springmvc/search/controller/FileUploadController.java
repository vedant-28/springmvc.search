package springmvc.search.controller;

import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	@RequestMapping("/fileform")
	public String showUploadForm() {
		
		return  "fileform";
	}
	
	@RequestMapping(value = "/uploadimage", 
					method = RequestMethod.POST, 
					consumes = "multipart/form-data"
					)
	public String fileupload(@RequestParam("profile") MultipartFile file) {
		
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		
		return "filesuccess";
	}
	
}
