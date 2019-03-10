package Search;

public class Ride {
	private String rideType;
	private int price;
	private String supplier;
	private int passangers;
	
	public Ride(String rideType, int price, String supplier) {
		this.rideType = rideType;
		this.price = price;
		this.supplier = supplier;
		setPassangers(rideType);
	}
	
	private void setPassangers(String rideType) {
		switch(rideType) {
			case "STANDARD":
			case "EXECUTIVE":
			case "LUXURY":
				passangers = 4;
				break;
			case "PEOPLE_CARRIER":
			case "LUXURY_PEOPLE_CARRIER":
				passangers = 6;
				break;
			case "MINIBUS":
				passangers = 16;
				break;
		}
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getRideType() {
		return rideType;
	}
	
	public String getSupplier() {
		return supplier;
	}
	
	public int getPassangers() {
		return passangers;
	}
	
	public String toString() {
		return rideType + " - " + supplier + " - " + price;
	}
}