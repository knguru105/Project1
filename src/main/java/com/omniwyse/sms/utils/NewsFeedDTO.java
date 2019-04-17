package com.omniwyse.sms.utils;


public class NewsFeedDTO {

    private long id;
	private String headline;
    private Long releasedate;
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

    public Long getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Long releasedate) {
        this.releasedate = releasedate;
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
