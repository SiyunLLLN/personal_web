package project.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import project.Entities.Photo;
import project.services.PhotoService;
import project.utilities.PhotoUtil;

@Controller
@RequestMapping("/photos")
public class PhotoController {
	
	@Autowired 
	private PhotoService photoService;

    @GetMapping
    public String photoPage(Model model) {
    	
    	Iterable<Photo> allPhotos = photoService.findAll();
    	
    	ArrayList<Photo> usable = new ArrayList<Photo>();
    	ArrayList<String> images = new ArrayList<String>();
    	
    	
		for (Photo photo: allPhotos) {
			if (photo != null && photo.getImageData() != null) {
				usable.add(photo);
				images.add(photo.getTrueImag());
			} 
		}

    	model.addAttribute("photoUtil", new PhotoUtil());
    	model.addAttribute("photos", usable);
    	model.addAttribute("images", images);
        return "homePage/photos";
    }
    
    
    
    @GetMapping("/upload")
    public String uploadPage() {
    	return "photos/upload";
    }

	@PostMapping("/upload")
	public String uploadImage(@RequestParam("photo")MultipartFile file, @RequestParam("title")String title) throws IOException{
		photoService.upload(file, title);
		return "homepage/photos";
	}
}
