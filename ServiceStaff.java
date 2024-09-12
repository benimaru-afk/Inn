package hotel;

public class ServiceStaff extends Staff {
	public static void changeCleanStatus(int roomID, String status) {
		Rooms.changeCleanStatus(roomID, status);
	}
	public static void viewCleanStatus(int roomID) {
		System.out.println(Rooms.searchRoomInfo(roomID).getCleanStatus());
	}
	public ServiceStaff(String username, String password, String role){
		super(username, password, role);
	}
}
