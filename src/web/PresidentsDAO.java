package web;

import java.util.List;

public interface PresidentsDAO {
	
	public President getPresident(String name);
	
	public President getPresident(Integer number);
	
	public Integer getNumber(String name);
	
	public String getName(Integer number);
	
	public String getDate(Integer number);
	
	public String getParty(Integer number);
	
	public String getPhoto(Integer number);
	
	public List<President> getAllPresidents();
	
	
}
