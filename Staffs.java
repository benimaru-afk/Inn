package hotel;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Staffs {
	public static ArrayList<Staff> StaffList = new ArrayList<>();
	
	public static int Login(String Username, String Password, String Role) {
		for(Staff s: StaffList) {
			if(s.getUsername().equals(Username) && s.getPassword().equals(Password) && s.getRole().equals(Role)) {
				if(Role.equals("Service"))
					return 3;
				else if(Role.equals("Receptionist"))
					return 2;
				else if(Role.equals("Owner"))
					return 1;
			}
		}
		return 4;
	}
	
	public static void readFromCSV() {
		Scanner csv;
		try {
			csv = new Scanner(new java.io.File("src/hotel/Staffs.csv"));
			while (csv.hasNextLine()) {
				csv.useDelimiter(",");
				String Username = csv.next().trim();
				String Password = csv.next().trim();
				String Role = csv.next().trim();
				Staff s = new Staff(Username, Password, Role);
				Staffs.StaffList.add(s);
				if (csv.hasNextLine()) {
					csv.nextLine();
				}
			}
			csv.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
