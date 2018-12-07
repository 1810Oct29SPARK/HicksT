package com.wolfe.transport;

public class Kayak extends Boat{

	
	
	public Kayak(String color, double hullLengthInMeters, boolean hasHoleinHull, int numSeats,
			double paddleLengthInMeters) {
		super(color, hullLengthInMeters, hasHoleinHull);
		this.numSeats = numSeats;
		this.paddleLengthInMeters = paddleLengthInMeters;
		System.out.println("kayak args constructor completed");
	}
	public Kayak() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private int numSeats;
	private double paddleLengthInMeters;
	public int getNumSeats() {
		return numSeats;
	}
	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}
	public double getPaddleLengthInMeters() {
		return paddleLengthInMeters;
	}
	public void setPaddleLengthInMeters(double paddleLengthInMeters) {
		this.paddleLengthInMeters = paddleLengthInMeters;
	}
	@Override
	public String toString() {
		return "Kayak [numSeats=" + numSeats + ", paddleLengthInMeters=" + paddleLengthInMeters + ", color=" + color
				+ ", hullLengthInMeters=" + hullLengthInMeters + ", hasHoleinHull=" + hasHoleinHull + "]";
	}
	
	
	
}
