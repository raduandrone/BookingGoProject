import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import Search.Ride;

public class RideTest {
	private Ride testRide;
	private int price;
	private String rideType;
	private String supplier;
	
	@Before
	public void setUp() {
		rideType = "STANDARD";
	  price = 10;
		supplier = "testSupplier";
		
		testRide = new Ride(rideType, price, supplier);
	}
	
	@Test
	public void testGetPassangers() {
		assertEquals(4, testRide.getPassangers());
	}
	
	@Test
	public void testGetPrice() {
		assertEquals(price, testRide.getPrice());
	}
	
	@Test
	public void testGetRideType() {
		assertEquals(rideType, testRide.getRideType());
	}
	
	@Test
	public void testGetSupplier() {
		assertEquals(supplier, testRide.getSupplier());
	}
}