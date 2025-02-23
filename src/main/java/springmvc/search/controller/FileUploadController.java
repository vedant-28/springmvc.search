package springmvc.search.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

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
	public String fileupload(@RequestParam("profile") MultipartFile file,
							 HttpSession session,
							 Model model) throws IOException {
		
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		
		byte[] data = file.getBytes();
		String path = session.getServletContext().getRealPath("/") 
							 + "WEB-INF" 
							 + File.separator 
							 + "resources"
							 + File.separator
							 + "images"
							 + File.separator
							 + file.getOriginalFilename();
		System.out.println(path);
		
		try {
			// Storing uploaded file in server
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();
			System.out.println("File uploaded...");
			
			// Sending uploaded file name to view for showing on success page
			model.addAttribute("filename", file.getOriginalFilename());
			model.addAttribute("message", "Uploaded successfully...");
			
		} catch (IOException e) {
			System.out.println("Uploading error...");
			model.addAttribute("message", "Something went wrong...");
			e.printStackTrace();
		}
		
		return "filesuccess";
	}
	
}
