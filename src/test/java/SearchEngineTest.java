import static org.junit.Assert.assertEquals;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import org.junit.*;
import Search.ApiResponse;
import Search.Ride;
import Search.SearchEngine;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class SearchEngineTest {
	
	private SearchEngine searchEngineTest;
	private SearchEngine searchEngine = new SearchEngine();
	private ApiResponse apiResponse;
	private Map<String, Ride> map;

	@Before
	public void setUp() {
		searchEngineTest = mock(SearchEngine.class);
		apiResponse = new ApiResponse();
	}
	
	@Test
	public void testMakeApiCallFalse() throws Exception {
		String wrongUrl = "https://techtest.rideways.com/dave?pickup=2,2";
	  assertEquals(null, searchEngine.makeApiCall(new URL(wrongUrl)));
	}
	
	@Test
	public void testMakeApiCallTrue() throws MalformedURLException, Exception {
		String correctUrl = "https://techtest.rideways.com/dave?pickup=2,2&dropoff=2,2";
		
    doReturn(apiResponse).when(searchEngineTest).makeApiCall(new URL(correctUrl));
	}

	@Test
	public void testGetMap() throws MalformedURLException, Exception {		
    doReturn(map).when(searchEngineTest).getMap();
	}
}