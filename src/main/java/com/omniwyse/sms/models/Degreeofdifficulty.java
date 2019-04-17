package com.omniwyse.sms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "degreeofdifficulty")
public class Degreeofdifficulty {

	private long id;
	private String degreeofdifficulty;

    @Id
    @GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDegreeofdifficulty() {
		return degreeofdifficulty;
	}

	public void setDegreeofdifficulty(String degreeofdifficulty) {
		this.degreeofdifficulty = degreeofdifficulty;
	}


}
