package com.sg.dvdroster.dto;

public class Dvd {
	private String dvdID;
	private String title;
	private String releaseDate;
	private String MPAARating;
	private String directorName;
	private String studio;
	private String userRating;
	
	
	
	
	public Dvd (String dvdID) {
		this.dvdID = dvdID;
	}




	public String getDvdID() {
		return dvdID;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getReleaseDate() {
		return releaseDate;
	}




	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}




	public String getMPAARating() {
		return MPAARating;
	}




	public void setMPAARating(String mPAARating) {
		MPAARating = mPAARating;
	}




	public String getDirectorName() {
		return directorName;
	}




	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	
	
	




	public String getStudio() {
		return studio;
	}




	public void setStudio(String studio) {
		this.studio = studio;
	}




	public String getUserRating() {
		return userRating;
	}




	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}
	
	
	
	
	
	
	
	

}
