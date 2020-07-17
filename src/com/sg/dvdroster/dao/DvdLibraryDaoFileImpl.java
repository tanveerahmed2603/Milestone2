package com.sg.dvdroster.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import com.sg.dvdroster.dto.Dvd;

public class DvdLibraryDaoFileImpl implements DvdLibraryDao{
	
	public static final String DVD_FILE = "DvdFile.txt";
	public static final String DELIMITER = "::";
	
	
	
	
	private Map<String, Dvd> dvdList = new HashMap<>();
	

	@Override
	public Dvd addDvd(String dvdID, Dvd dvd) throws DvdLibraryDaoException{
		
		
		loadDvdCollection();
		if(dvdList.containsKey(dvdID)) {
			throw new DvdLibraryDaoException("Dvd Id already exist, try a different ID");
		}
		Dvd newDvd = dvdList.put(dvdID, dvd);
		
		writeDvdCollection();
		
		return newDvd;
	}

	@Override
	public Dvd removeDvd(String dvdID) throws DvdLibraryDaoException{
		loadDvdCollection();
		
		Dvd removeDvd = dvdList.remove(dvdID);
		
		writeDvdCollection();
		return removeDvd;
	}

	@Override
	public Dvd editDvd(Dvd dvd) throws DvdLibraryDaoException{
		loadDvdCollection();
		
		dvdList.put(dvd.getDvdID(), dvd);
		writeDvdCollection();
		return dvd;
	}
	
	@Override
	public List<Dvd> getAllDvd() throws DvdLibraryDaoException{
		
		loadDvdCollection();
		return new ArrayList<Dvd>(dvdList.values());
	}

	@Override
	public Dvd viewDvd(String dvdID)throws DvdLibraryDaoException {
		loadDvdCollection();
		return dvdList.get(dvdID);
	}

	@Override
	public Dvd searchDvd(String title) throws DvdLibraryDaoException{
		loadDvdCollection();
		
		for (Dvd dvd : dvdList.values()) {
			if(dvd.getTitle().equals(title)){
				return dvd;
			}
		}
		return null;
	}
	
	

	private String marshallDvd(Dvd dvd){
	    // Start with the dvd id, since that's supposed to be first.
	    String dvdAsText = dvd.getDvdID() + DELIMITER;

	    // add the rest of the properties in the correct order:

	    dvdAsText += dvd.getTitle() + DELIMITER;

	    dvdAsText += dvd.getReleaseDate() + DELIMITER;

	    dvdAsText += dvd.getMPAARating() + DELIMITER;

	    dvdAsText += dvd.getDirectorName() + DELIMITER;

	    dvdAsText += dvd.getStudio() + DELIMITER;

	    dvdAsText += dvd.getUserRating();

	    // We have now turned a student to text! Return it!
	    return dvdAsText;
	}
	
	
	
	private void writeDvdCollection() throws DvdLibraryDaoException {
	    PrintWriter out;

	    try {
	        out = new PrintWriter(new FileWriter(DVD_FILE));
	    } catch (IOException e) {
	        throw new DvdLibraryDaoException(
	                "Could not save dvd data.", e);
	    }

	    String dvdAsText;
	    for (Dvd dvd : dvdList.values()) {
	        dvdAsText = marshallDvd(dvd);
	        out.println(dvdAsText);
	        // force PrintWriter to write line to the file
	        out.flush();
	    }
	    // Clean up
	    out.close();
	}
	
	
	private Dvd unmarshallDvd(String dvdAsText){
	    
	    String[] dvdTokens = dvdAsText.split(DELIMITER);

	    
	    String dvdID = dvdTokens[0];

	    
	    Dvd dvdFromFile = new Dvd(dvdID);

	    
	    
	    dvdFromFile.setTitle(dvdTokens[1]);

	   
	    dvdFromFile.setReleaseDate(dvdTokens[2]);

	    
	    dvdFromFile.setMPAARating(dvdTokens[3]);
	    
	    dvdFromFile.setDirectorName(dvdTokens[4]);
	    
	    dvdFromFile.setStudio(dvdTokens[5]);
	    dvdFromFile.setUserRating(dvdTokens[6]);

	    
	    return dvdFromFile;
	}
	
	
	private void loadDvdCollection() throws DvdLibraryDaoException {
	    Scanner scanner;

	    try {
	        
	        scanner = new Scanner(
	                new BufferedReader(
	                        new FileReader(DVD_FILE)));
	    } catch (FileNotFoundException e) {
	        throw new DvdLibraryDaoException(
	                "-_- Could not load Dvd data into memory.", e);
	    }
	   
	    String currentLine;
	   
	    Dvd currentDvd;
	    
	    while (scanner.hasNextLine()) {
	        
	        currentLine = scanner.nextLine();
	       
	        currentDvd = unmarshallDvd(currentLine);

	       
	        dvdList.put(currentDvd.getDvdID(), currentDvd);
	    }
	    // close scanner
	    scanner.close();
	}

	
	
	

	
	

	
}
