import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import Search.Part1;

public class Part1Test {
	
	@Test
	public void testCheckDoubleTrue() {
		assertTrue(Part1.checkDouble("2.0"));
	}
	
	@Test
	public void testCheckDoubleFalse() {
		assertFalse(Part1.checkDouble("false"));
	}
	
	@Test
	public void testFewArguments() {
		String[] test = new String[1];
		assertFalse(Part1.validArguments(test));
	}
	
	@Test
	public void testFalsePassangerArgument() {
		String[] test = new String[5];
		test[4] = "0";
		assertFalse(Part1.validArguments(test));
	}
	
	@Test
	public void testFalseCoordinateArgument() {
		String[] test = new String[4];
		test[0] = "test";
		assertFalse(Part1.validArguments(test));
	}
	
	@Test
	public void testValidArguments() {
		String[] test = new String[4];
		test[0] = "1";
		test[1] = "1";
		test[2] = "1";
		test[3] = "1";
		assertTrue(Part1.validArguments(test));
	}
	
	@Test
	public void testConstructUrl() {
		String testUrl = "https://techtest.rideways.com/test/?pickup=1.0,1.0&dropoff=1.0,1.0";
		String[] test = new String[4];
		test[0] = "1";
		test[1] = "1";
		test[2] = "1";
		test[3] = "1";
		
		assertEquals(testUrl, Part1.constructURL(test, "test"));
	}
}