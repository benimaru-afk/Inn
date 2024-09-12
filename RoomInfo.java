package hotel;

import java.io.IOException;

public class RoomInfo {
	private int ID;
	private int FloorNumber;
	private String CleanStatus;
	private int RoomNumber;
	private String RoomClass;
	private float price;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getFloorNumber() {
		return FloorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		FloorNumber = floorNumber;
	}

	public String getCleanStatus() {
		return CleanStatus;
	}

	public void setCleanStatus(String cleanStatus) {
		CleanStatus = cleanStatus;
	}

	public int getRoomNumber() {
		return RoomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		RoomNumber = roomNumber;
	}

	public String getRoomClass() {
		return RoomClass;
	}

	public void setRoomClass(String roomClass) {
		RoomClass = roomClass;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void show() {

	}

	public RoomInfo(int iD, int floorNumber, String cleanStatus, int roomNumber, String roomClass,
			float price) {
		ID = iD;
		FloorNumber = floorNumber;
		CleanStatus = cleanStatus;
		RoomNumber = roomNumber;
		RoomClass = roomClass;
		this.price = price;
	}
}
