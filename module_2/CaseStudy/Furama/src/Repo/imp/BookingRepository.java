package Repo.imp;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import Model.Booking;
import Repo.Interface.IBookingRepository;
import Util.ReadAndWriteFileCSV;

public class BookingRepository implements IBookingRepository<Booking> {
	private final String BOOKING_FILE = "src/Data/Booking.csv";

	@Override
	public Set<Booking> getAll() {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
		stringList = ReadAndWriteFileCSV.readFileCSV(BOOKING_FILE);
		Set<Booking> bookingList = new TreeSet<>();
		String[] arr;
		for(String string : stringList) {
			arr = string.split(",");
			Booking booking = new Booking(arr[0], arr[1], arr[2], arr[3], arr[4]);
			bookingList.add(booking);
		}
		return bookingList;
	}

	@Override
	public void add(Booking t) {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
        stringList.add(t.getInforToCSV());
        ReadAndWriteFileCSV.writeListStringToCSV(BOOKING_FILE, stringList, true);
	}

	@Override
	public void update(Set<Booking> bookingList) {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<>();
//      ReadAndWriteFileCSV.deleteDataFile(BOOKING_DATA);
      for (Booking booking:bookingList) {
          stringList.add(booking.getInforToCSV());
      }
      ReadAndWriteFileCSV.writeListStringToCSV(BOOKING_FILE, stringList, false);
	}


	

	

}
