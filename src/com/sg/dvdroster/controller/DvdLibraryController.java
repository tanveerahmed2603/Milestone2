package com.sg.dvdroster.controller;





import java.util.List;

import com.sg.dvdroster.dao.DvdLibraryDao;
import com.sg.dvdroster.dao.DvdLibraryDaoException;
import com.sg.dvdroster.dto.Dvd;
import com.sg.dvdroster.ui.DvdLibraryView;

public class DvdLibraryController {
	private DvdLibraryView view;
	private DvdLibraryDao dao;
	

	
	public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
		
		this.dao=dao;
		this.view=view;
		
	}
	
	
	
	public void run () {
		boolean keepGoing = true;
		int menuSelection = 0;
		
		
		while(keepGoing) {
			
			
			menuSelection =  getMenuSelection();
			
			try{
				switch(menuSelection) {
				case 1: 
					addDvd();
					break;
				case 2: 
					removeDvd();
					break;
				case 3: 
					editDvd();
					break;
				case 4: 
					listDvd();
					break;
				case 5: 
					viewDvd();
					break;
				case 6: 
					searchDvd();
					break;
				case 7: 
					keepGoing = false;
					break;
				default: 
					unknownCommand();
					
				}
			} catch(DvdLibraryDaoException e) {
				view.displayErrorMessage(e.getMessage());
			}
		}
		exitMessage();
	
	}
	
	
	
	private int getMenuSelection() {
		return view.printMenuAndGetSelection();
	}
	
	
	private void addDvd() throws DvdLibraryDaoException {
		view.displayAddDvdBanner();
		Dvd newDvd = view.getNewDvdInfo();
		dao.addDvd(newDvd.getDvdID(),newDvd);
		view.displayCreateSuccessBanner();
	}
	
	private void editDvd() throws DvdLibraryDaoException {
		view.editDvdBanner();
		String dvdID = view.getDvdIDChoice();
		Dvd dvd = dao.viewDvd(dvdID);
		dvd = view.editDvdInfo(dvd);
		dao.editDvd(dvd);
		view.displayCreateSuccessBanner();
	}
	
	private void listDvd() throws DvdLibraryDaoException {
	    view.displayDisplayAllBanner();
	    List<Dvd> dvdList = dao.getAllDvd();
	    view.displayDvdList(dvdList);
	}
	
	private void viewDvd() throws DvdLibraryDaoException {
	    view.displayDisplayDvdBanner();
	    String dvdID = view.getDvdIDChoice();
	    Dvd dvdList = dao.viewDvd(dvdID);
	    view.displayDvd(dvdList);
	}

	
	private void removeDvd() throws DvdLibraryDaoException {
	    view.displayRemovedDvdBanner();
	    String dvdID = view.getDvdIDChoice();
	    Dvd removeDvd = dao.removeDvd(dvdID);
	    view.displayRemoveResult(removeDvd);
	}
	
	private void searchDvd() throws DvdLibraryDaoException {
		
		view.displaySearchDvdBanner();
	    String title = view.getDvdTitleChoice();
	    Dvd dvd = dao.searchDvd(title);
	    view.displayDvd(dvd);
		
	}
	
	private void unknownCommand() {
		view.displayUnknownCommandBanner();
	}
	
	private void exitMessage() {
		view.displayExitBanner();
	}
	
	
	
	
	
	
}
