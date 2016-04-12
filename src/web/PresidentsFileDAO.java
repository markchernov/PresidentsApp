package web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

public class PresidentsFileDAO implements PresidentsDAO {
	private static final String filename = "WEB-INF/presidents.csv";
	private static final String filename2 = "WEB-INF/PresPhotoLinks2.csv";
	private ServletContext servletContext;
	private List<President> presidentsList;
	private List<String> picList;

	public PresidentsFileDAO(ServletContext context) {

		servletContext = context;

		presidentsList = new ArrayList<>();

		picList = new ArrayList<>();

		loadPresidentsFromFile();

		updatePresidentsFromFile();

		System.out.println("Size:   " + presidentsList.size());

		System.out.println(presidentsList.toString());

	}

	private void loadPresidentsFromFile() {
		// Retrieve an input stream from the servlet context
		// rather than directly from the file system
		InputStream is = servletContext.getResourceAsStream(filename);
		try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");

				Integer number = Integer.parseInt(tokens[0]);
				String fname = tokens[1];
				String mname = tokens[2];
				String lname = tokens[3];
				String term = tokens[4];
				String party = tokens[5];
				String photo = null;

				presidentsList.add(new President(number, fname, mname, lname, term, party, photo));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	private void updatePresidentsFromFile() {

		InputStream is = servletContext.getResourceAsStream(filename2);
		try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				Integer number = Integer.parseInt(tokens[0]);

				picList.add(tokens[1]);

				// String photo = tokens[1];
				//
				//
				//
				// presidentsList.get(index).setPhoto(photo);
				//
				//

			}

			for (President p : presidentsList) {

				

				p.setPhoto(picList.get((p.getNumber())-1));

				

			}
			
			
			//System.out.println(picList);

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	// ---------------------methods-----------------------------//

	@Override
	public President getPresident(Integer number) {
		President p = null;
		for (President president : presidentsList) {
			if (president.getNumber().equals(number)) {
				p = president;
				break;
			}
		}
		return p;
	}

	// overload

	public President getPresident(String name) {
		President p = null;
		for (President president : presidentsList) {
			if ((president.getFname() + president.getMname() + president.getLname()).equals(name)) {
				p = president;
				break;
			}
		}
		return p;
	}

	@Override
	public Integer getNumber(String name) {
		President president = getPresident(name);
		if (president != null) {
			return president.getNumber();
		} else {
			return -1;
		}
	}

	@Override
	public String getName(Integer number) {
		President president = getPresident(number);
		if (president != null) {
			return (president.getFname() + president.getMname() + president.getLname());
		} else {
			return null;
		}
	}

	@Override
	public String getDate(Integer number) {
		String date = null;
		for (President president : presidentsList) {
			if (president.getNumber().equals(number)) {
				date = president.getTerm();
				break;
			}
		}
		return date;
	}

	public String getParty(Integer number) {
		String party = null;
		for (President president : presidentsList) {
			if (president.getNumber().equals(number)) {
				party = president.getParty();
				break;
			}
		}
		return party;
	}

	public String getPhoto(Integer number) {
		String party = null;
		for (President president : presidentsList) {
			if (president.getNumber().equals(number)) {
				party = president.getPhoto();
				break;
			}
		}
		return party;
	}

	@Override
	public List<President> getAllPresidents() {
		return presidentsList;
	}

}
