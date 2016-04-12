package web;

public class President implements Comparable<President> {

	private Integer number;
	private String fname;
	private String mname;
	private String lname;
	private String term;
	private String party;
	private String photo;

	public President(Integer number, String fname, String mname, String lname, String term, String party,
			String photo) {
		super();
		this.number = number;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.term = term;
		this.party = party;
		this.photo = photo;
	}
	
	public String getName(){
		
		return (this.fname + " " + this.mname + " " + this.lname);
	}
	
	

	public Integer getNumber() {
		return number;
	}

	public String getFname() {
		return fname;
	}

	public String getMname() {
		return mname;
	}

	public String getLname() {
		return lname;
	}

	public String getTerm() {
		return term;
	}

	public String getParty() {
		return party;
	}

	public String getPhoto() {
		return photo;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "President [number=" + number + ", fname=" + fname + ", mname=" + mname + ", lname=" + lname + ", term="
				+ term + ", party=" + party + ", photo=" + photo + "]";
	}
	
	@Override
	public int compareTo(President n) {
		Integer presRank;
		presRank = number.compareTo(n.number);
		return presRank;
	}	
}
