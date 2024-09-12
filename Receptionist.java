package hotel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Receptionist extends Staff {
	private static Scanner scanner = new Scanner(System.in);

	public Receptionist(String username, String password, String role) {
		super(username, password, role);
	}

	public static void CheckIn(BookingInfo booking, GuestInfo guest) {
		System.out.println("Booking ID: " + booking.getID() + "\nGuest ID: " + booking.getGuestID()
				+ "\nPayment Status: " + booking.getPaymentStatus() + "\nRoom ID: " + booking.getRoomID()
				+ "\nCheck In Time: " + booking.getCheckIn().getDayOfMonth() + "/"
				+ booking.getCheckIn().getMonthValue() + "/" + booking.getCheckIn().getYear() + " , "
				+ booking.getCheckIn().getHour() + ":" + booking.getCheckIn().getMinute() + "\nCheck Out Time: "
				+ booking.getCheckOut().getDayOfMonth() + "/" + booking.getCheckOut().getMonthValue() + "/"
				+ booking.getCheckOut().getYear() + " , " + booking.getCheckOut().getHour() + ":"
				+ booking.getCheckOut().getMinute() + "\nNumber of Adults: " + booking.getNumAdults()
				+ "\nNumber of Children: " + booking.getNumChildren() + "\nBooking Amount: "
				+ booking.getBookingAmount() + "\n");
		System.out.println("Is this information correct? Type yes or no");
		String choice = scanner.nextLine().trim();
		if (choice.equals("yes"))
			System.out.println("Thank you for confirming!");
		else {
			int flag = 0;
			while (flag == 0) {
				try {
					System.out.println(
							"Please enter what information you would like to change \n 1. ID \n 2. Guest ID \n 3. Payment Status \n"
									+ " 4. Room ID \n 5. Number of Adults \n 6. Number of Children \n 7. Booking Amount \n 8. Exit");
					int num = scanner.nextInt();
					scanner.nextLine();
					switch (num) {
					case 1:
						System.out.println("Enter the updated ID: ");
						int newID = scanner.nextInt();
						scanner.nextLine();
						booking.setID(newID);
						break;
					case 2:
						System.out.println("Enter the updated Guest ID: ");
						int newGuestID = scanner.nextInt();
						scanner.nextLine();
						booking.setGuestID(newGuestID);
						break;
					case 3:
						System.out.println("Enter the updated Payment Status: ");
						String newPaymentStatus = scanner.nextLine().trim();
						booking.setPaymentStatus(newPaymentStatus);
						break;
					case 4:
						System.out.println("Enter the updated Room ID: ");
						int newRoomID = scanner.nextInt();
						scanner.nextLine();
						booking.setRoomID(newRoomID);
						break;
					case 5:
						System.out.println("Enter the updated Number of Adults: ");
						int newAdults = scanner.nextInt();
						scanner.nextLine();
						booking.setNumAdults(newAdults);
						break;
					case 6:
						System.out.println("Enter the updated Number of Children: ");
						int newChildren = scanner.nextInt();
						scanner.nextLine();
						booking.setNumChildren(newChildren);
						break;
					case 7:
						System.out.println("Enter the updated Booking Amount: ");
						float newBookingAmount = scanner.nextFloat();
						scanner.nextLine();
						booking.setBookingAmount(newBookingAmount);
						break;
					case 8:
						flag = 1;
					}
					
				} catch (InputMismatchException e){
					System.out.println("Input did not match expected type");
				}
			}
		}
		PrintReciept(guest);
		System.out.println("Pay the total amount listed on the screen");
		System.out.println("Did the user pay the full amount? Enter yes or no");
		String userChoice = scanner.nextLine().trim();
		if (userChoice.equals("yes")) {
			for (BookingInfo b : Bookings.Bookings) {
				if (b.getGuestID() == guest.getID()) {
					b.setPaymentStatus("Paid");
				}
			}
		} else {
			for (BookingInfo b : Bookings.Bookings) {
				if (b.getGuestID() == guest.getID()) {
					b.setPaymentStatus("Unpaid");
				}
			}
		}
	}

	public static void CheckOut(BookingInfo booking) {
		booking.setCheckedOut(true);
		System.out.println("Thank you for staying with us!");
	}

	public static void PrintReciept(GuestInfo guest) {
		System.out.println(guest.getID() + "," + guest.getFirstName() + "," + guest.getLastName() + ","
				+ guest.getEmail() + "," + guest.getPhone() + "\n");
		System.out.println("Is this information correct? Type yes or no");
		String choice = scanner.nextLine().trim();
		if (choice.equals("no")) {
			System.out.println(
					"Please enter what information you would like to change \n 1. ID \n 2. First Name \n 3. Last Name \n"
							+ "4. Email \n 5. Phone");
			try {
				int num = scanner.nextInt();
				scanner.nextLine();
				switch (num) {
				case 1:
					System.out.println("Enter the updated ID: ");
					int newID = scanner.nextInt();
					scanner.nextLine();
					guest.setID(newID);
					break;
				case 2:
					System.out.println("Enter the updated First Name: ");
					String newFirstName = scanner.nextLine().trim();
					guest.setFirstName(newFirstName);
					break;
				case 3:
					System.out.println("Enter the updated Last Name: ");
					String newLastName = scanner.nextLine().trim();
					guest.setLastName(newLastName);
					break;
				case 4:
					System.out.println("Enter the updated Email: ");
					String newEmail = scanner.nextLine().trim();
					guest.setEmail(newEmail);
					break;
				case 5:
					System.out.println("Enter the updated Phone: ");
					String newPhone = scanner.nextLine().trim();
					guest.setPhone(newPhone);
					break;
				}
				
			} catch (InputMismatchException e){
				System.out.println("Input did not match expected type");
			}
			PrintReciept(guest);
			return;
		}
		float total = 0;
		for (BookingInfo b : Bookings.Bookings) {
			if (b.getGuestID() == guest.getID()) {
				System.out.println("\n\tBooking Id: " + b.getID() + " Room Id: " + b.getRoomID() + " Payment Status: "
						+ b.getPaymentStatus() + " Check In Date DD\\MM\\YYYY: " + b.getCheckIn().getDayOfMonth() + "\\"
						+ b.getCheckIn().getMonthValue() + "\\" + b.getCheckIn().getYear()
						+ " Check In Time(24hr) HH\\MM: " + b.getCheckIn().getHour() + "\\" + b.getCheckIn().getMinute()
						+ "\n\tCheck Out Date DD\\\\MM\\\\YYYY: " + b.getCheckOut().getDayOfMonth() + "\\"
						+ b.getCheckOut().getMonthValue() + "\\" + b.getCheckOut().getYear()
						+ " Check Out Time(24hr) HH\\\\MM: " + b.getCheckOut().getHour() + "\\"
						+ b.getCheckOut().getMinute() + " Number of Adults: " + b.getNumAdults()
						+ "Number of Children: " + b.getNumChildren() + " Booking Amount: " + b.getBookingAmount());
				total = total + b.getBookingAmount();
				System.out.println("\nYour total is " + total);
			}
		}
	}

	public static void RoomStatus(int roomID) {
		boolean flag = false;
		for (BookingInfo b : Bookings.Bookings) {
			if (b.getRoomID() == roomID && b.getCheckedOut() == false) {
				flag = true;
				System.out.println(
						"\nUnavailable from: " + b.getCheckIn().getDayOfMonth() + "/" + b.getCheckIn().getMonthValue()
								+ "/" + b.getCheckIn().getYear() + " , " + b.getCheckIn().getHour() + ":"
								+ b.getCheckIn().getMinute() + "\nto:  " + b.getCheckOut().getDayOfMonth() + "/"
								+ b.getCheckOut().getMonthValue() + "/" + b.getCheckOut().getYear() + " , "
								+ b.getCheckOut().getHour() + ":" + b.getCheckOut().getMinute());
			}
		}
		if (flag == false) {
			System.out.println("Room is available");
		}
	}

	public static void addGuestInfo() {

		Guests.addGuest();
	}
}
