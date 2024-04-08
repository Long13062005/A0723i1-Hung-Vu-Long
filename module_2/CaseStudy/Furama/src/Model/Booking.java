package Model;

import java.util.Date;

public class Booking implements Comparable<Booking> {
	  private String idBooking, idCustomer, idService;
	    private String dateStart, dateEnd;
	    public Booking(String idBooking, String idCustomer, String idService, String dateStart, String dateEnd) {
	        this.idBooking = idBooking;
	        this.idCustomer = idCustomer;
	        this.idService = idService;
	        this.dateStart = dateStart;
	        this.dateEnd = dateEnd;
	    }

	    public String getIdBooking() {
	        return idBooking;
	    }

	    public void setIdBooking(String idBooking) {
	        this.idBooking = idBooking;
	    }

	    public String getIdCustomer() {
	        return idCustomer;
	    }

	    public void setIdCustomer(String idCustomer) {
	        this.idCustomer = idCustomer;
	    }

	    public String getIdService() {
	        return idService;
	    }

	    public void setIdService(String idService) {
	        this.idService = idService;
	    }

	    public String getDateStart() {
	        return dateStart;
	    }

	    public void setDateStart(String dateStart) {
	        this.dateStart = dateStart;
	    }

	    public String getDateEnd() {
	        return dateEnd;
	    }

	    public void setDateEnd(String dateEnd) {
	        this.dateEnd = dateEnd;
	    }

	    @Override
	    public String toString() {
	        return "idBooking= '" + idBooking + '\'' +
	                ", idCustomer= '" + idCustomer + '\'' +
	                ", idService= '" + idService + '\'' +
	                ", dateStart= " + dateStart +
	                ", dateEnd= " + dateEnd;
	    }
	    public String getInforToCSV(){
	        return idBooking+","+idCustomer+","+idService+","+dateStart+","+dateEnd;
	    }

	    @Override
	    public int compareTo(Booking booking) {
	        int dateCompare = booking.dateStart.compareTo(this.dateStart);
	        if (dateCompare == 0) {
	            return booking.dateEnd.compareTo(this.dateEnd);

	        }
	        return dateCompare;
	    }
}
