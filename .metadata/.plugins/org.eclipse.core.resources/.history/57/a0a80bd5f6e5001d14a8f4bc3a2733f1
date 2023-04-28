package project.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.Entities.Photo;
import project.Repository.PhotoRepository;
import project.utilities.PhotoUtil;


@Service
public class PhotoServiceImpl implements PhotoService{
	
	@Autowired
    private PhotoRepository imageRepo;
	
	public void upload(MultipartFile file,String title) throws IOException {
		Photo pImage = new Photo();
		pImage.setTitle(title);
		try {
			pImage.setImageData(PhotoUtil.compressImage(file.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imageRepo.save(pImage);
	}
	
	public byte[] download(String fileName){
        Optional<Photo> imageData = imageRepo.findByTitle(fileName);
        return PhotoUtil.decompressImage(imageData.get().getImageData());
    }

	public Iterable findAll() {
		return imageRepo.findAll();
	}

}
