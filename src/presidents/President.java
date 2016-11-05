package presidents;

import java.io.Serializable;

public class President implements java.io.Serializable{

	private int termNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private int startDate;
	private int endDate;
	private String party;
	private String funFact;
	private String photo;
	
	public President() {
	}
	
	public President(int termNumber, String firstName, String middleName, String lastName, int startDate, int endDate,
			String party, String funFact, String photo) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.termNumber = termNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.party = party;
		this.funFact = funFact;
		this.photo = photo;
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getTermNumber() {
		return termNumber;
	}

	public void setTermNumber(int termNumber) {
		this.termNumber = termNumber;
	}

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getFunFact(){
		return this.funFact;
	}
	
	public void setFunFact(String funFact){
		this.funFact = funFact;
	}
	
	@Override
	public String toString() {
		return "President [termNumber=" + termNumber + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", startDate=" + startDate + ", endDate=" + endDate + ", party=" + party
				+ ", funFact=" + funFact + ", photo=" + photo + "]";
	}

}
