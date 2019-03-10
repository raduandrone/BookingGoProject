import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Search.ApiResponse;

public class ApiResponseTest {
	
	ApiResponse testApiResponse;
	
	@Before
	public void setUp() {
		testApiResponse = new ApiResponse();
	}
	
	@Test
	public void testSetSupplierId() {
		String id = "testID";
		testApiResponse.setSupplierId(id);
		
		assertEquals(id, testApiResponse.getSupplierId());
	}
	
	@Test
	public void testSetPickup() {
		String pickup = "1.0,2.0";
		testApiResponse.setPickUp(pickup);
		
		assertEquals(pickup, testApiResponse.getPickup());
	}
	
	@Test
	public void testSetDropoff() {
		String dropoff = "1.0,2.0";
		testApiResponse.setDropOff(dropoff);;
		
		assertEquals(dropoff, testApiResponse.getDropoff());
	}
	
	@Test
	public void testSetOptions() {
		testApiResponse.setOptions(null);
		
		assertEquals(null, testApiResponse.getRideOptions());
	}
}