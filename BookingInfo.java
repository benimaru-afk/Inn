package hotel;

import java.io.IOException;

public class BookingInfo {
	private int ID;
	private int GuestID;
	private String PaymentStatus;
	private int RoomID;
	private boolean checkedOut;
	private java.time.LocalDateTime CheckIn;
	private java.time.LocalDateTime CheckOut;

	public BookingInfo(int iD, int guestID, String paymentStatus, int roomID, java.time.LocalDateTime checkIn, java.time.LocalDateTime checkOut,
			int numAdults, int numChildren, float bookingAmount, boolean checkedOut) {
		ID = iD;
		GuestID = guestID;
		PaymentStatus = paymentStatus;
		RoomID = roomID;
		CheckIn = checkIn;
		CheckOut = checkOut;
		NumAdults = numAdults;
		NumChildren = numChildren;
		BookingAmount = bookingAmount;
		checkedOut = false;
	}

	private int NumAdults;
	private int NumChildren;
	private float BookingAmount;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getGuestID() {
		return GuestID;
	}

	public void setGuestID(int guestID) {
		GuestID = guestID;
	}

	public String getPaymentStatus() {
		return PaymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		PaymentStatus = paymentStatus;
	}

	public int getRoomID() {
		return RoomID;
	}

	public void setRoomID(int roomID) {
		RoomID = roomID;
	}

	public java.time.LocalDateTime getCheckIn() {
		return CheckIn;
	}

	public void setCheckIn(java.time.LocalDateTime checkIn) {
		CheckIn = checkIn;
	}

	public java.time.LocalDateTime getCheckOut() {
		return CheckOut;
	}

	public void setCheckOut(java.time.LocalDateTime checkOut) {
		CheckOut = checkOut;
	}

	public int getNumAdults() {
		return NumAdults;
	}

	public void setNumAdults(int numAdults) {
		NumAdults = numAdults;
	}

	public int getNumChildren() {
		return NumChildren;
	}

	public void setNumChildren(int numChildren) {
		NumChildren = numChildren;
	}

	public float getBookingAmount() {
		return BookingAmount;
	}

	public void setBookingAmount(float bookingAmount) {
		BookingAmount = bookingAmount;
	}
	public boolean getCheckedOut() {
		return checkedOut;
	}
	public void setCheckedOut(boolean checkout) {
		checkedOut = checkout;
	}
}
