package project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.Entities.Category;
import project.Entities.Photo;
import project.Repository.CategoryRepository;



@Service
public class CategoryServiceImpl  implements CategoryService{
	
	
	@Autowired
    private CategoryRepository ctgRepo;
	


	public CategoryServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public Iterable<Category> findAll() {
		// TODO Auto-generated method stub
		return ctgRepo.findAll();
	}

	public void add(Category category) {
		// TODO Auto-generated method stub
		ctgRepo.save(category);
	}
	
	public Iterable<Photo> findAllFirstImage() {
		Iterable<Category> allCategories = findAll();
		List<Photo> photos = new ArrayList<Photo>();
		for (Category c: allCategories) {
			Photo first;
			
			if (c.getPhotos().iterator().hasNext() == false) {
				continue;
			}
			first =  c.getPhotos().iterator().next();
			photos.add(first);
		}
		return photos;
	
	}

}
