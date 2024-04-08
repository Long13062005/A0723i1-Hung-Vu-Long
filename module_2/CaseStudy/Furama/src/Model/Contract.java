package Model;

import java.util.Date;

public class Contract {
	 private String bookingCode;
	 private String contractNumber;
	 private double depositAmount;
	 private double totalPayment;
	public Contract(String bookingCode, String contractNumber, double depositAmount, double totalPayment) {
		super();
		this.bookingCode = bookingCode;
		this.contractNumber = contractNumber;
		this.depositAmount = depositAmount;
		this.totalPayment = totalPayment;
	}
	public Contract() {
		super();
	}
	@Override
	public String toString() {
		return "Contact [bookingCode=" + bookingCode + ", contractNumber=" + contractNumber + ", depositAmount="
				+ depositAmount + ", totalPayment=" + totalPayment + "]";
	}
	public String getBookingCode() {
		return bookingCode;
	}
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}
	public String getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public double getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}
	public String getInforToCSV() {
		// TODO Auto-generated method stub
		return this.bookingCode + " , " + this.contractNumber + " , " + this.depositAmount + " , " + this.totalPayment;
	}
	 
}
