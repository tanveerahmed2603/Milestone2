package com.sg.dvdroster;

import com.sg.dvdroster.controller.DvdLibraryController;
import com.sg.dvdroster.dao.DvdLibraryDao;
import com.sg.dvdroster.dao.DvdLibraryDaoFileImpl;
import com.sg.dvdroster.ui.DvdLibraryView;
import com.sg.dvdroster.ui.UserIO;
import com.sg.dvdroster.ui.UserIOConsoleImpl;

public class App {
	public static void main(String[] args) {
		
		UserIO myIo = new UserIOConsoleImpl();
		DvdLibraryView myView = new DvdLibraryView(myIo);
		DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
		DvdLibraryController controller = new DvdLibraryController(myDao,myView);
		controller.run();
	}
}
