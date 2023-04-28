package project.controllers;
import java.io.IOException;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import project.Entities.Category;
import project.Entities.Photo;
import project.services.BookService;
import project.services.CategoryService;
import project.utilities.PhotoUtil;

@Controller
public class CategoryController {
    String appName;
    
    
    @Autowired
    private CategoryService ctgService;

    @GetMapping("/category")
    public String homePage(Model model) {
    	model.addAttribute("categories", ctgService.findAll());
    	
        return "homePage/category";
    }
    
    @GetMapping("/test")
    public String album(Model model) {
    	
    	Iterable<Photo> allPhotos = ctgService.findAllFirstImage();
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
    	
        return "homePage/album";
    }
    
    @GetMapping("/category/add")
    public String uploadPage() {
    	return "category/add";
    }

	@PostMapping("category/upload")
	public String uploadImage(@ModelAttribute Category category) throws IOException{
		ctgService.add(category);
		return "homepage/photos";
	}
    

    
}