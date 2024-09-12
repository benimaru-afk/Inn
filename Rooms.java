package hotel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Rooms {
	public static ArrayList<RoomInfo> Rooms = new ArrayList<>();

	public static RoomInfo searchRoomInfo(int ID) {
		for (RoomInfo r : Rooms)
			if (r.getRoomNumber() == ID)
				return r;
		System.out.println("Couldn't find the room");
		return null;
	}

	public static void changeCleanStatus(int roomID, String cleanStatus) {
		for (RoomInfo r : Rooms)
			if (r.getRoomNumber() == roomID)
				r.setCleanStatus(cleanStatus);
	}

	public static void readFromCSV() {
		Scanner csv;
		try {
			csv = new Scanner(new java.io.File("src/hotel/Rooms.csv"));
			csv.useDelimiter(",");
			while (csv.hasNextLine()) {
				int ID = csv.nextInt();
				int FloorNumber = csv.nextInt();
				String CleanStatus = csv.next().trim();
				int RoomNumber = csv.nextInt();
				String RoomClass = csv.next().trim();
				float price = csv.nextFloat();
				if (csv.hasNextLine()) {
					csv.nextLine();
				}
				RoomInfo r = new RoomInfo(ID, FloorNumber, CleanStatus, RoomNumber, RoomClass, price);
				Rooms.add(r);
			}
			csv.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void writeToCSV() {
		java.io.File file = new java.io.File("src/hotel/Rooms.csv");
		try {
			if (!file.createNewFile()) {
				file.delete();
				file.createNewFile();
			}
			file.setReadable(true);
			file.setWritable(true);
			java.io.FileWriter writer = new java.io.FileWriter(file);
			for (RoomInfo r : Rooms) {
				writer.write(r.getID() + "," + r.getFloorNumber() + "," + r.getCleanStatus() + "," + r.getRoomNumber()
						+ "," + r.getRoomClass() + "," + r.getPrice() + ",\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
