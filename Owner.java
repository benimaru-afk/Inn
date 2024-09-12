package hotel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Owner {

	static Scanner scanner = new Scanner(System.in);

	public static void printRecords() {
		System.out.println("Do you want to print the yearly, monthly, or weekly report?");
		System.out.println("1. Year, 2. Month, 3. Week");
		try {

			switch (scanner.nextInt()) {

			case 1:
				scanner.nextLine();
				System.out.println("Insert the year you would like printed");
				int year = scanner.nextInt();
				scanner.nextLine();
				printYear(year);
				// printYear
				break;
			case 2:
				scanner.nextLine();
				System.out.println("Insert the year you would like printed");
				year = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Insert the month you would like printed (1-12)");
				int month = scanner.nextInt();
				scanner.nextLine();
				// printMonth
				printMonth(LocalDate.of(year, month, 1));
				break;
			case 3:
				scanner.nextLine();
				System.out.println("Insert the Year you would like printed");
				year = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Insert the Month you would like printed (1-12)");
				month = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Insert the Day of the month you would like printed (1-31)");
				int day = scanner.nextInt();
				scanner.nextLine();
				// printMonth
				printWeek(LocalDate.of(year, month, day));
				// printWeek
				break;
			case 4:
				scanner.nextLine();
				// exit
				return;
			default:
				scanner.nextLine();
				break;

			}
		} catch (InputMismatchException e) {
			System.out.println("Input did not match expected type");
			return;
		}

	}

	public static void printYear(int year) {
		LocalDate yearstart = LocalDate.of(year, 1, 1);
		LocalDate yearend = LocalDate.of(year, 12, 31);
		for (BookingInfo b : Bookings.Bookings) {
			if (b.getCheckOut().isAfter(LocalDateTime.of(yearstart, LocalTime.MIN))
					&& b.getCheckIn().isBefore(LocalDateTime.of(yearend, LocalTime.MAX))) {
				System.out.println("\n\tBooking Id: " + b.getID() + " Room Id: " + b.getRoomID() + " Guest Id: "
						+ b.getGuestID() + " Payment Status: " + b.getPaymentStatus() + " Check In Date DD\\MM\\YYYY: "
						+ b.getCheckIn().getDayOfMonth() + "\\" + b.getCheckIn().getMonthValue() + "\\"
						+ b.getCheckIn().getYear() + " Check In Time(24hr) HH\\MM: " + b.getCheckIn().getHour() + "\\"
						+ b.getCheckIn().getMinute() + "\n\tCheck Out Date DD\\\\MM\\\\YYYY: "
						+ b.getCheckOut().getDayOfMonth() + "\\" + b.getCheckOut().getMonthValue() + "\\"
						+ b.getCheckOut().getYear() + " Check Out Time(24hr) HH\\\\MM: " + b.getCheckOut().getHour()
						+ "\\" + b.getCheckOut().getMinute() + " Number of Adults: " + b.getNumAdults()
						+ "Number of Children: " + b.getNumChildren() + " Booking Amount: " + b.getBookingAmount());
			}
		}

	}

	public static void printMonth(LocalDate t) {
		LocalDate monthstart = t.minusDays(t.getDayOfMonth() - 1);
		LocalDate monthend = t.plusDays(31 - (t.getDayOfMonth() - 1));
		for (BookingInfo b : Bookings.Bookings) {
			if (b.getCheckOut().isAfter(LocalDateTime.of(monthstart, LocalTime.MIN))
					&& b.getCheckIn().isBefore(LocalDateTime.of(monthend, LocalTime.MAX))) {
				System.out.println("\n\tBooking Id: " + b.getID() + " Room Id: " + b.getRoomID() + " Guest Id: "
						+ b.getGuestID() + " Payment Status: " + b.getPaymentStatus() + " Check In Date DD\\MM\\YYYY: "
						+ b.getCheckIn().getDayOfMonth() + "\\" + b.getCheckIn().getMonthValue() + "\\"
						+ b.getCheckIn().getYear() + " Check In Time(24hr) HH\\MM: " + b.getCheckIn().getHour() + "\\"
						+ b.getCheckIn().getMinute() + "\n\tCheck Out Date DD\\\\MM\\\\YYYY: "
						+ b.getCheckOut().getDayOfMonth() + "\\" + b.getCheckOut().getMonthValue() + "\\"
						+ b.getCheckOut().getYear() + " Check Out Time(24hr) HH\\\\MM: " + b.getCheckOut().getHour()
						+ "\\" + b.getCheckOut().getMinute() + " Number of Adults: " + b.getNumAdults()
						+ "Number of Children: " + b.getNumChildren() + " Booking Amount: " + b.getBookingAmount());
			}
		}
	}

	public static void printWeek(LocalDate t) {
		LocalDate weekstart = t.minusDays(t.getDayOfWeek().getValue() - 1);
		LocalDate weekend = t.plusDays(7 - (t.getDayOfWeek().getValue() - 1));
		for (BookingInfo b : Bookings.Bookings) {
			if (b.getCheckOut().isAfter(LocalDateTime.of(weekstart, LocalTime.MIN))
					&& b.getCheckIn().isBefore(LocalDateTime.of(weekend, LocalTime.MAX))) {
				System.out.println("\n\tBooking Id: " + b.getID() + " Room Id: " + b.getRoomID() + " Guest Id: "
						+ b.getGuestID() + " Payment Status: " + b.getPaymentStatus() + " Check In Date DD\\MM\\YYYY: "
						+ b.getCheckIn().getDayOfMonth() + "\\" + b.getCheckIn().getMonthValue() + "\\"
						+ b.getCheckIn().getYear() + " Check In Time(24hr) HH\\MM: " + b.getCheckIn().getHour() + "\\"
						+ b.getCheckIn().getMinute() + "\n\tCheck Out Date DD\\\\MM\\\\YYYY: "
						+ b.getCheckOut().getDayOfMonth() + "\\" + b.getCheckOut().getMonthValue() + "\\"
						+ b.getCheckOut().getYear() + " Check Out Time(24hr) HH\\\\MM: " + b.getCheckOut().getHour()
						+ "\\" + b.getCheckOut().getMinute() + " Number of Adults: " + b.getNumAdults()
						+ "Number of Children: " + b.getNumChildren() + " Booking Amount: " + b.getBookingAmount());
			}
		}
	}

	public static void viewAvailability(java.time.LocalDate day) {
		for (RoomInfo r : Rooms.Rooms) {
			ArrayList<BookingInfo> unavailable = new ArrayList<>();
			for (BookingInfo b : Bookings.Bookings) {
				if (b.getRoomID() == r.getID()
						&& (b.getCheckOut().isAfter(java.time.LocalDateTime.of(day, java.time.LocalTime.of(0, 0))))
						&& (b.getCheckIn().isBefore(java.time.LocalDateTime.of(day, java.time.LocalTime.of(23, 59))))) {
					unavailable.add(b);
				}
			}
			System.out.println("Room Number " + r.getRoomNumber());
			if (unavailable.isEmpty()) {
				System.out.println("\tAvailable all day");
			} else {
				for (BookingInfo b : unavailable) {
					System.out.println("\tBooking Id: " + b.getID() + " Guest Id: " + b.getGuestID()
							+ " Payment Status: " + b.getPaymentStatus() + " Check In Date DD\\MM\\YYYY: "
							+ b.getCheckIn().getDayOfMonth() + "\\" + b.getCheckIn().getMonthValue() + "\\"
							+ b.getCheckIn().getYear() + " Check In Time(24hr) HH\\MM: " + b.getCheckIn().getHour()
							+ "\\" + b.getCheckIn().getMinute() + "\n\tCheck Out Date DD\\\\MM\\\\YYYY: "
							+ b.getCheckOut().getDayOfMonth() + "\\" + b.getCheckOut().getMonthValue() + "\\"
							+ b.getCheckOut().getYear() + " Check Out Time(24hr) HH\\\\MM: " + b.getCheckOut().getHour()
							+ "\\" + b.getCheckOut().getMinute() + " Number of Adults: " + b.getNumAdults()
							+ "Number of Children: " + b.getNumChildren() + " Booking Amount: " + b.getBookingAmount());
				}
			}
		}

	}

}
