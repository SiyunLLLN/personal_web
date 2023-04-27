package project.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import project.Entities.Photo;

public interface PhotoService {
	
	public void upload(MultipartFile file, String title) throws IOException;
	
	public byte[] download(String fileName);

	public Iterable findAll();
	
	

}
