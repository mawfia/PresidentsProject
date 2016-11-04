package presidents;

public class President {

	private String firstName;
	private String middleName;
	private String lastName;
	private int termNumber;
	private int startDate;
	private int endDate;
	private String party;
	private String photo;
	
	public President() {
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

	@Override
	public String toString() {
		return "President [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", termNumber=" + termNumber + ", startDate=" + startDate + ", endDate=" + endDate + ", party="
				+ party + ", photo=" + photo + "]";
	}
}
