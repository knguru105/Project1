package com.omniwyse.sms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="multiplechoice_image")
public class MultipleChoice_Image 
{
	private long id, mcqid, imageid, imageorder;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMcqid() {
		return mcqid;
	}

	public void setMcqid(long mcqid) {
		this.mcqid = mcqid;
	}

	public long getImageid() {
		return imageid;
	}

	public void setImageid(long imageid) {
		this.imageid = imageid;
	}

	public long getImageorder() {
		return imageorder;
	}

	public void setImageorder(long imageorder) {
		this.imageorder = imageorder;
	}
}
