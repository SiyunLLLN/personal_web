package project.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import project.utilities.PhotoUtil;

@Entity
@Table(name = "photos")
public class Photo {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(nullable = false, unique = false)
    @NotEmpty(message = "The title cannot be empty.")
    private String title;
    
    
    @Transient
    PhotoUtil photoUtil = new PhotoUtil();
    
//    signifies that the annotated field should be represented as BLOB (binary data) in the DataBase.
    @Lob
    @Column(nullable = false)
    @NotEmpty(message = "The image file cannot be empty.")
    private byte[] imageData;
    
    
    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

	public Photo() {
		// TODO Auto-generated constructor stub
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public byte[] getImageData() {
		return this.imageData;
	}
	
	
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
	
	public String getTrueImag() {
		return photoUtil.getImgData(imageData);
	}
	
	public Category getCategory() {
		return this.category;
	}
	
	public long getCategoryId() {
		return this.category.getCategory_id();
	}



}
