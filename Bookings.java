package hotel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bookings {
	private static Scanner scanner = new Scanner(System.in);
	public static ArrayList<BookingInfo> Bookings = new ArrayList<>();

	public static void checkAvailability(BookingInfo booking) {
		for (BookingInfo b : Bookings) {
			if (b.getRoomID() == booking.getRoomID() && ((b.getCheckOut().plusHours(2).isAfter(booking.getCheckIn())
					&& b.getCheckOut().plusHours(2).isBefore(booking.getCheckOut()))
					|| (b.getCheckIn().minusHours(2).isBefore(booking.getCheckOut())
							&& b.getCheckIn().minusHours(2).isAfter(booking.getCheckIn())))) {
				System.out.println("Date and/or Room are Unavailable.");
				booking.setCheckIn(null);
			}
		}
		System.out.println("Date and Room are Available!");
	}

	public static void addBooking() {
		try {
			System.out.println("Please Enter ID: ");
			int ID = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Please Enter Guest ID: ");
			int GuestID = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Please Enter Payment Status: ");
			String payment = scanner.nextLine().trim();
			System.out.println("Please Enter Room ID: ");
			int RoomID = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Please Enter Check In Date: DD/MM/YYYY");
			String date = scanner.nextLine().trim();
			Scanner datescan = new Scanner(date);
			datescan.useDelimiter("/");
			int day = datescan.nextInt();
			int month = datescan.nextInt();
			int year = datescan.nextInt();
			datescan.close();
			System.out.println("Please Enter Check In Time: HH:MM (24 time)");
			String time = scanner.nextLine().trim();
			Scanner timescan = new Scanner(time);
			timescan.useDelimiter(":");
			int hour = timescan.nextInt();
			int minute = timescan.nextInt();
			timescan.close();
			java.time.LocalDateTime checkIn = java.time.LocalDateTime.of(year, month, day, hour, minute, 0);
			System.out.println("Please Enter Check Out Date: DD\\MM\\YYYY");
			date = scanner.nextLine().trim();
			datescan = new Scanner(date);
			datescan.useDelimiter("/");
			day = datescan.nextInt();
			month = datescan.nextInt();
			year = datescan.nextInt();
			datescan.close();
			System.out.println("Please Enter Check Out Time: HH\\MM (24 time)");
			time = scanner.nextLine().trim();
			timescan = new Scanner(time);
			timescan.useDelimiter(":");
			hour = timescan.nextInt();
			minute = timescan.nextInt();
			timescan.close();
			java.time.LocalDateTime checkOut = java.time.LocalDateTime.of(year, month, day, hour, minute, 0);
			System.out.println("Please Enter Number of Adults: ");
			int adults = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Please Enter Number of Children");
			int children = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Please Enter Booking Cost: ");
			float cost = scanner.nextFloat();
			scanner.nextLine();
			BookingInfo booking = new BookingInfo(ID, GuestID, payment, RoomID, checkIn, checkOut, adults, children,
					cost, false);
			Bookings.add(booking);
		} catch (InputMismatchException e) {
			System.out.println("Input did not match expected type");
//			e.printStackTrace();
			return;
		}
		
	}

	public static void removeBooking(int ID) {
		for (BookingInfo b : Bookings) {
			if (b.getID() == ID)
				Bookings.remove(b);
		}
	}

	public static void readFromCSV() {
		Scanner csv;
		try {
			csv = new Scanner(new java.io.File("src/hotel/Bookings.csv"));
			csv.useDelimiter(",");
			while (csv.hasNextLine()) {
				int ID = csv.nextInt();
				int guestID = csv.nextInt();
				String paymentStatus = csv.next().trim();
				int roomID = csv.nextInt();
				int day = csv.nextInt();
				int month = csv.nextInt();
				int year = csv.nextInt();
				int hour = csv.nextInt();
				int minute = csv.nextInt();
				java.time.LocalDateTime checkIn = java.time.LocalDateTime.of(year, month, day, hour, minute, 0);
				day = csv.nextInt();
				month = csv.nextInt();
				year = csv.nextInt();
				hour = csv.nextInt();
				minute = csv.nextInt();
				java.time.LocalDateTime checkOut = java.time.LocalDateTime.of(year, month, day, hour, minute, 0);
				int numAdults = csv.nextInt();
				int numChildren = csv.nextInt();
				float bookingAmount = csv.nextFloat();
				boolean CheckOutStatus = csv.nextBoolean();
				if (csv.hasNextLine()) {
					csv.nextLine();
				}
				BookingInfo b = new BookingInfo(ID, guestID, paymentStatus, roomID, checkIn, checkOut, numAdults,
						numChildren, bookingAmount, CheckOutStatus);
				Bookings.add(b);
			}
			csv.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeToCSV() {
		java.io.File file = new java.io.File("src/hotel/Bookings.csv");
		try {
			if (!file.createNewFile()) {
				file.delete();
				file.createNewFile();
			}
			file.setReadable(true);
			file.setWritable(true);
			java.io.FileWriter writer = new java.io.FileWriter(file);
			for (BookingInfo b : Bookings) {
				writer.write(b.getID() + "," + b.getGuestID() + "," + b.getPaymentStatus() + "," + b.getRoomID() + ","
						+ b.getCheckIn().getDayOfMonth() + "," + b.getCheckIn().getMonthValue() + ","
						+ b.getCheckIn().getYear() + "," + b.getCheckIn().getHour() + "," + b.getCheckIn().getMinute()
						+ "," + b.getCheckOut().getDayOfMonth() + "," + b.getCheckOut().getMonthValue() + ","
						+ b.getCheckOut().getYear() + "," + b.getCheckOut().getHour() + ","
						+ b.getCheckOut().getMinute() + "," + b.getNumAdults() + "," + b.getNumChildren() + ","
						+ b.getBookingAmount() + "," + b.getCheckedOut() + ",\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
