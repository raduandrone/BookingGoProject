import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import Search.RideOption;

public class RideOptionTest {
	RideOption testRideOption;
	
	@Before 
	public void setUp() {
		testRideOption = new RideOption();
	}
	
	@Test
	public void testSetCarType() {
		String carType = "testCar";
		
		testRideOption.setCarType(carType);
		
		assertEquals(carType, testRideOption.getCarType());
	}
	
	@Test
	public void testSetPrice() {
	  int price = 1;
		
		testRideOption.setPrice(price);
		
		assertEquals(price, testRideOption.getPrice());
	}
}