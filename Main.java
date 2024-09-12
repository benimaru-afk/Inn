package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Staffs.readFromCSV();
		Guests.readFromCSV();
		Bookings.readFromCSV();
		Rooms.readFromCSV();

		while (true) {

			// login sequence
			System.out.println("Please Login to your Account:");
			System.out.println("Enter Your Username:");
			System.out.print(">> ");
			String U = scanner.nextLine().trim();
			//
			System.out.println("Enter Your Password:");
			System.out.print(">> ");
			String P = scanner.nextLine().trim();

			//
			System.out.println("Enter Your Role:");
			System.out.print(">> ");
			String R = scanner.nextLine().trim();
			// user input

			int Log = Staffs.Login(U, P, R);

			switch (Log) {
			case 1:
				// owner
				if (ownerChoices()) {
					return;
				}
				break;
			case 2:
				// reception
				if (receptionistChoices()) {
					return;
				}
				break;
			case 3:
				// service staff
				if (serviceStaffChoices()) {
					return;
				}
				break;
			default:
				break;
			}
		}

	}

	public static boolean ownerChoices() {
		while (true) {
			System.out.println("Please select an option:");
			System.out.println("1 - Print Reports");
			System.out.println("2 - View Availability");
			System.out.println("3 - Exit");
			System.out.println("4 - Shut Down and Save Data");
			System.out.print(">> ");
			try {
				switch (scanner.nextInt()) {
				case 1:
					scanner.nextLine();
					Owner.printRecords();
					break;
				case 2:
					scanner.nextLine();
					System.out.println("Please insert a date to check availability DD/MM/YYYY");
					String date = scanner.nextLine().trim();
					Scanner datescan = new Scanner(date);
					datescan.useDelimiter("/");
					int day = datescan.nextInt();
					int month = datescan.nextInt();
					int year = datescan.nextInt();
					Owner.viewAvailability(LocalDate.of(year, month, day));
					break;
				case 3:
					scanner.nextLine();
					return false;
				case 4:
					Guests.writeToCSV();
					Rooms.writeToCSV();
					Bookings.writeToCSV();
					return true;
				default:
					scanner.nextLine();
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Input did not match expected type");
			}
		}

	}

	public static boolean receptionistChoices() {
		while (true) {
			System.out.println("Please select an option:");
			System.out.println("1 - Book Rooms");
			System.out.println("2 - Check In");
			System.out.println("3 - Check Out");
			System.out.println("4 - Show Status of Room");
			System.out.println("5 - Add Guest Info");
			System.out.println("6 - Exit");
			System.out.println("7 - Shut Down and Save Data");
			System.out.print(">> ");
			try {
				switch (scanner.nextInt()) {
				case 1:
					scanner.nextLine();
					Bookings.addBooking();
					break;
				case 2:
					scanner.nextLine();
					System.out.println("Enter your booking ID");
					int BookingId = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter your guest ID");
					int GuestId = scanner.nextInt();
					scanner.nextLine();
					// for b in booking , checks id u enter vs entered list
					// for g in guests, checks guest id,
					BookingInfo booking = null;
					for (BookingInfo b : Bookings.Bookings) {
						if (b.getID() == BookingId) {
							booking = b;
							break;
						}
					}
					if (booking == null) {
						System.out.println("Invalid booking ID");
						break;
					}
					GuestInfo guest = null;
					for (GuestInfo g : Guests.Guests) {
						if (g.getID() == GuestId) {
							guest = g;
							break;
						}
					}
					if (guest == null) {
						System.out.println("Invalid guest ID");
						break;
					}
					Receptionist.CheckIn(booking, guest);
					break;
				case 3:
					scanner.nextLine();
					System.out.println("Enter your booking ID");
					BookingId = scanner.nextInt();
					scanner.nextLine();
					booking = null;
					for (BookingInfo b : Bookings.Bookings) {
						if (b.getID() == BookingId) {
							booking = b;
							break;
						}
					}
					if (booking == null) {
						System.out.println("Invalid booking ID");
						break;
					}
					Receptionist.CheckOut(booking);
					guest = null;
					for (GuestInfo g : Guests.Guests) {
						if (g.getID() == booking.getGuestID()) {
							guest = g;
							break;
						}
					}
					if (guest == null) {
						System.out.println("Invalid guest ID");
						break;
					}
					Receptionist.PrintReciept(guest);
					break;
				case 4:
					scanner.nextLine();
					System.out.println("Enter the room ID");
					int RoomId = scanner.nextInt();
					scanner.nextLine();
					Receptionist.RoomStatus(RoomId);
					break;
				case 5:
					scanner.nextLine();
					Receptionist.addGuestInfo();
					break;
				case 6:
					scanner.nextLine();
					return false;
				case 7:
					Guests.writeToCSV();
					Rooms.writeToCSV();
					Bookings.writeToCSV();
					return true;
				default:
					scanner.nextLine();
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Input did not match expected type");
			}
		}
	}

	public static boolean serviceStaffChoices() {
		while (true) {
			System.out.println("Please select an option:");
			System.out.println("1 - View Clean Status");
			System.out.println("2 - Change Clean Status");
			System.out.println("3 - Exit");
			System.out.println("4 - Shut Down and Save Data");
			System.out.println(">> ");
			try {
				switch (scanner.nextInt()) {
				case 1:
					scanner.nextLine();
					System.out.println("Enter the room ID");
					int RoomId = scanner.nextInt();
					scanner.nextLine();
					ServiceStaff.viewCleanStatus(RoomId);
					break;
				case 2:
					scanner.nextLine();
					System.out.println("Enter the room ID");
					RoomId = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter the new status");
					String Status = scanner.nextLine().trim();
					ServiceStaff.changeCleanStatus(RoomId, Status);
					break;
				case 3:
					scanner.nextLine();
					return false;
				case 4:
					Guests.writeToCSV();
					Rooms.writeToCSV();
					Bookings.writeToCSV();
					return true;
				default:
					scanner.nextLine();
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Input did not match expected type");
			}

		}
	}

}
