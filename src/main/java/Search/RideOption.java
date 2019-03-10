package Search;

public class RideOption {
	private String car_type;
	private int price;
	
	public void setCarType(String car_type) {
		this.car_type = car_type;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public String getCarType() {
		return car_type;
	}
	
	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "(" + car_type + "," + price + ")";
	}
}