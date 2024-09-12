package hotel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Guests {
	public static ArrayList<GuestInfo> Guests = new ArrayList<>();

	public static GuestInfo searchGuest(int ID) {
		for (GuestInfo g : Guests) {
			if (g.getID() == ID)
				return g;
		}
		System.out.println("Could not find the guest");
		return null;
	}

	public static void addGuest() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter GuestID: ");
			int ID = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Please enter First Name: ");
			String FirstName = scanner.nextLine().trim();
			System.out.println("Please enter Last Name: ");
			String LastName = scanner.nextLine().trim();
			System.out.println("Please enter Email: ");
			String Email = scanner.nextLine().trim();
			System.out.println("Please enter Phone: ");
			String Phone = scanner.nextLine().trim();
			GuestInfo g = new GuestInfo(ID, FirstName, LastName, Email, Phone);
			Guests.add(g);
		} catch (InputMismatchException e) {
			System.out.println("Input did not match expected type");
			return;
		}
	}

	public static void readFromCSV() {
		Scanner csv;
		try {
			csv = new Scanner(new java.io.File("src/hotel/Guests.csv"));
			csv.useDelimiter(",");
			while (csv.hasNextLine()) {
				int ID = csv.nextInt();
				String FirstName = csv.next().trim();
				String LastName = csv.next().trim();
				String Email = csv.next().trim();
				String Phone = csv.next().trim();
				if (csv.hasNextLine()) {
					csv.nextLine();
				}
				GuestInfo g = new GuestInfo(ID, FirstName, LastName, Email, Phone);
				Guests.add(g);
			}
			csv.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeToCSV() {
		java.io.File file = new java.io.File("src/hotel/Guests.csv");
		try {
			if (!file.createNewFile()) {
				file.delete();
				file.createNewFile();
			}
			file.setReadable(true);
			file.setWritable(true);
			java.io.FileWriter writer = new java.io.FileWriter(file);
			for (GuestInfo g : Guests) {
				writer.write(g.getID() + "," + g.getFirstName() + "," + g.getLastName() + "," + g.getEmail() + ","
						+ g.getPhone() + ",\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
