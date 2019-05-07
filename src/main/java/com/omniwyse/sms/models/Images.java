package com.omniwyse.sms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="images")
public class Images {
	
	private Long image_id ,image_for_id ;
	private String image_name, image_path,image_class;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getImage_id() {
		return image_id;
	}
	public void setImage_id(Long image_id) {
		this.image_id = image_id;
	}
	public Long getImage_for_id() {
		return image_for_id;
	}
	public void setImage_for_id(Long image_for_id) {
		this.image_for_id = image_for_id;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	public String getImage_class() {
		return image_class;
	}
	public void setImage_class(String image_class) {
		this.image_class = image_class;
	}
	
	
	
	
}
