package Search;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;

@RestController
public class SearchController {
	@RequestMapping("/bookinggo")
	public String greeting(@RequestParam(value="pickup") String pickup, 
						   @RequestParam(value="dropoff") String dropoff, 
						   @RequestParam(required = false) String passangers) throws Exception {
		try {
			if (!checkPassangers(passangers)) {
				return "Invalid  number of passangers.";
			}
	
			SearchEngine searchEngine = new SearchEngine();
			
			URL daveUrl = new URL(constructURL("dave", pickup, dropoff, passangers));
			
			ApiResponse daveApiResponse = searchEngine.makeApiCall(daveUrl);
			
			if (daveApiResponse != null)
				searchEngine.getRides(daveApiResponse, Integer.valueOf(passangers));
			
			URL ericUrl = new URL(constructURL("eric", pickup, dropoff, passangers));
			ApiResponse ericApiResponse = searchEngine.makeApiCall(ericUrl);
			
			if (ericApiResponse != null)
				searchEngine.getRides(ericApiResponse, Integer.valueOf(passangers));
			
			URL jeffUrl = new URL(constructURL("jeff", pickup, dropoff, passangers));
			ApiResponse jeffApiResponse = searchEngine.makeApiCall(jeffUrl);
			
			if (jeffApiResponse != null)
				searchEngine.getRides(jeffApiResponse, Integer.valueOf(passangers));
			
			  ArrayList<Ride> finalList = new ArrayList<Ride>();
		      
		      for (String carType : searchEngine.getMap().keySet()) {
		    	  finalList.add(searchEngine.getMap().get(carType));
		      }
		      
		      finalList.sort(new SortByPrice());
			
			return new Gson().toJson(finalList);
		} catch (MalformedURLException e) {
			return "Invalid  parameter format. Correct format : 1.2345,6.7890";
		}

	}
	private String constructURL(String supplier, String pickup, String dropoff, String passangers) {
		StringBuilder stringBuilder = new StringBuilder("https://techtest.rideways.com/");
		
	  if (!checkLocation(pickup) || !checkLocation(dropoff)) {
	  	return null;
	  }
	  
		stringBuilder.append(supplier);
		stringBuilder.append("/");
		  
		stringBuilder.append("?pickup=");
	  stringBuilder.append(pickup);
		stringBuilder.append("&dropoff=");
	  stringBuilder.append(dropoff);     
	  return stringBuilder.toString();
	}	
	
	private boolean checkPassangers(String passangers) {
		try {
			int pass = Integer.valueOf(passangers);
			
			if (pass <= 0)
				return false;
			
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	private boolean checkLocation(String location) {
		try{
			String[] coordinates = location.split(",");

	  	Double.valueOf(coordinates[0]);
	  	Double.valueOf(coordinates[1]);
	 	  return true;

	   }
	   catch (Exception ex){
	  	 return false;
	   }
	}
}