package project.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import project.Entities.Category;
import project.Entities.Photo;

public interface CategoryService {

	public Iterable<Category> findAll();

	public void add(Category category);
	
	public Iterable<Photo> findAllFirstImage();
	
	public Iterable<Photo> findPhotos(long id);
}
	
	
