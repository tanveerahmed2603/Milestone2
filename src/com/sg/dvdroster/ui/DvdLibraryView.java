package com.sg.dvdroster.ui;

import java.util.List;

import com.sg.dvdroster.dto.Dvd;

public class DvdLibraryView {
	
//private UserIO io = new UserIOConsoleImpl();
	private UserIO io;
	
	public DvdLibraryView(UserIO io) {
		this.io = io;
	}
	
	public int printMenuAndGetSelection  () {
		
		
		
			io.print("Main Menu");
			io.print("1. Add DVD in the Collection ");
			io.print("2. Remove DVD from Collection");
			io.print("3. Edit DVD Information");
			io.print("4. List DVD Collection");
			io.print("5. View a DVD");
			io.print("6. Search DVD by Title");
			io.print("7. Exit!!");
			
			return io.readInt("Please select from the Choice. ", 1,7);
}
	
	
	public Dvd getNewDvdInfo() {
		String dvdID = io.readString("Please enter Dvd ID");
		String title = io.readString("Please enter Dvd Title");
		String releaseDate = io.readString("Please enter Dvd Release Date");
		String MPAARating = io.readString("Please enter Dvd MPAA Rating");
		String directorName = io.readString("Please enter Director's name");
		String studio = io.readString("Please enter studio");
		String userRating = io.readString("Please enter User Rating");
		
		Dvd currentDvd = new Dvd(dvdID);
		currentDvd.setTitle(title);
		currentDvd.setReleaseDate(releaseDate);
		currentDvd.setMPAARating(MPAARating);
		currentDvd.setDirectorName(directorName);
		currentDvd.setStudio(studio);
		currentDvd.setUserRating(userRating);
		
		return currentDvd;
	}
	
	public Dvd editDvdInfo(Dvd currentDvd) {
		
		String title = io.readString("Please enter Dvd Title");
		String releaseDate = io.readString("Please enter Dvd Release Date");
		String MPAARating = io.readString("Please enter Dvd MPAA Rating");
		String directorName = io.readString("Please enter Director's name");
		String studio = io.readString("Please enter studio");
		String userRating = io.readString("Please enter User Rating");
		
		
		currentDvd.setTitle(title);
		currentDvd.setReleaseDate(releaseDate);
		currentDvd.setMPAARating(MPAARating);
		currentDvd.setDirectorName(directorName);
		currentDvd.setStudio(studio);
		currentDvd.setUserRating(userRating);
		
		return currentDvd;
	}
	
	                                                                                              
	public void displayAddDvdBanner() {
	    io.print("=== Adding Dvd ===");
	}
	
	
	public void displayCreateSuccessBanner() {
	    io.readString(
	            "Dvd successfully Added.  Please hit enter to continue");
	}
	
	
	public void displayDvdList(List<Dvd> dvdsList) {
	    for (Dvd currentDvd : dvdsList) {
	        String dvdInfo = String.format("%s : %s %s %s %s %s %s",
	        	  currentDvd.getDvdID(),
	              currentDvd.getTitle(),
	              currentDvd.getReleaseDate(),
	              currentDvd.getMPAARating(),
	        	  currentDvd.getDirectorName(),
	        	  currentDvd.getStudio(),
	        	  currentDvd.getUserRating());
	        	  
	        
	        io.print(dvdInfo);
	    }
	    io.readString("Please hit enter to continue.");
	}
	
	public void displayDisplayAllBanner() {
	    io.print("=== Display All DVD Collection ===");
	}
	
	
	public void displayDisplayDvdBanner () {
	    io.print("=== Displaying A perticular DVD ===");
	}

	public String getDvdIDChoice() {
	    return io.readString("Please enter the Dvd ID.");
	}
	
	public String getDvdTitleChoice() {
	    return io.readString("Please enter the Dvd Title.");
	}

	public void displayDvd(Dvd dvdList) {
	    if (dvdList != null) {
	    	io.print("ID: "+ dvdList.getDvdID());
	    	io.print("Title: "+dvdList.getTitle());
	    	io.print("Release Date: "+dvdList.getReleaseDate());
	    	io.print("MPAA Rating: "+dvdList.getMPAARating());
	    	io.print("Director's Name: "+dvdList.getDirectorName());
	    	io.print("Studio: "+dvdList.getStudio());
	    	io.print("User Rating"+dvdList.getUserRating());
	        io.print("");
	    	
	    	
	    } else {
	        io.print("No such DVD on Collection.");
	    }
	    io.readString("Please hit enter to continue.");
	}
	
	

	public void displayRemovedDvdBanner () {
	    io.print("=== Removing Dvd ===");
	}

	

	public void displayRemoveResult(Dvd dvdRecord) {
	    if(dvdRecord != null){
	      io.print("Dvd successfully removed.");
	    }else{
	      io.print("No such DVD.");
	    }
	    io.readString("Please hit enter to continue.");
	}
	
	public void displaySearchDvdBanner () {
	    io.print("=== Searching Dvd ===");
	}
	
	public void searchDvd(Dvd dvd) {
	    if (dvd != null) {
	    	io.printSameLine("ID: "+ dvd.getDvdID());
	    	io.printSameLine("Title: "+dvd.getTitle());
	    	io.printSameLine("Release Date: "+dvd.getReleaseDate());
	    	io.printSameLine("MPAA Rating: "+dvd.getMPAARating());
	    	io.printSameLine("Director's Name: "+dvd.getDirectorName());
	    	io.printSameLine("Studio: "+dvd.getStudio());
	    	io.printSameLine("User Rating"+dvd.getUserRating());
	        io.print("");
	    } else {
	        io.print("No such DVD on Collection.");
	    }
	    io.readString("Please hit enter to continue.");
	}
	
	public void displayExitBanner() {
		io.print("Good Bye!!!");
	}
	
	public void displayUnknownCommandBanner() {
		io.print("Unknown Command!!");
	}
	
	public void editDvdBanner() {
		io.print("Editing Dvd info");
	}
	public void displayErrorMessage(String errorMsg) {
		io.print("========ERROR=======");
		io.print(errorMsg);
	}
	
	
	
	
		
	}

