package com.omniwyse.sms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="images")
public class Images {
	
	private Long image_id ,Image_for_id ;
	private String image_name, Image_path,Image_class;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getImage_id() {
		return image_id;
	}
	public void setImage_id(Long image_id) {
		this.image_id = image_id;
	}
	public Long getImage_for_id() {
		return Image_for_id;
	}
	public void setImage_for_id(Long image_for_id) {
		Image_for_id = image_for_id;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public String getImage_path() {
		return Image_path;
	}
	public void setImage_path(String image_path) {
		Image_path = image_path;
	}
	public String getImage_class() {
		return Image_class;
	}
	public void setImage_class(String image_class) {
		Image_class = image_class;
	}
	
	
	
}
