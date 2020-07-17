package com.sg.dvdroster.dao;

import java.util.List;

import com.sg.dvdroster.dto.Dvd;

public interface DvdLibraryDao {
	
	Dvd addDvd(String dvdID, Dvd dvd) throws DvdLibraryDaoException;
	
	Dvd removeDvd(String title) throws DvdLibraryDaoException;
	
	Dvd editDvd(Dvd dvd) throws DvdLibraryDaoException;
	
	List<Dvd> getAllDvd() throws DvdLibraryDaoException;
	
	Dvd viewDvd(String title) throws DvdLibraryDaoException;
	
	Dvd searchDvd(String title) throws DvdLibraryDaoException;

	

	
	
	

}
