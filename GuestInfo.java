package hotel;

import java.io.IOException;

public class GuestInfo {
	private int ID;

	public GuestInfo(int iD, String firstName, String lastName, String email, String phone) {
		ID = iD;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Phone = phone;
	}

	private String FirstName;
	private String LastName;
	private String Email;
	private String Phone;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}
}
