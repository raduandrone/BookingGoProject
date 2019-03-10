package Search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SearchEngine {
	 	Map<String, Ride> cheapestRides;
	 	
	 public SearchEngine() {
		 
	 		cheapestRides = new HashMap<>();
	 }

	 public void getRides(ApiResponse apiResponse, int passangers) {
		 for (RideOption option : apiResponse.getRideOptions()) {
			 Ride ride = new Ride(option.getCarType(), option.getPrice(), apiResponse.getSupplierId());

			 if (passangers != 0 && ride.getPassangers() >= passangers) {
				 if (cheapestRides.containsKey(ride.getRideType())) {
					 Ride prevRide = cheapestRides.get(ride.getRideType());
	    	    	  
	    	   if (prevRide.getPrice() > ride.getPrice())
	    	  	 cheapestRides.put(ride.getRideType(), ride);
	    		 }
	    		 else cheapestRides.put(ride.getRideType(), ride);
	    	 }
	   }  
	 }
	 
	 public ApiResponse makeApiCall(URL url) throws Exception {
		 HttpURLConnection con = (HttpURLConnection) url.openConnection();
	      
	   con.setConnectTimeout(2000);
	      
	   int responseCode = con.getResponseCode();
	      
	   if (responseCode != 200) {
	     System.err.println("Skipped supplier");
	     System.err.println("Error code " + responseCode);
	    	  
	     return null;
	   }

	   BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	   String inputLine;
	   StringBuffer response = new StringBuffer();

	   while ((inputLine = in.readLine()) != null) {
	  	 response.append(inputLine);
	   }
	   in.close();

	   GsonBuilder builder = new GsonBuilder();
	   Gson gson = builder.create();
	   String strRep = response.toString();
	   ApiResponse apiResponse = gson.fromJson(strRep, ApiResponse.class);
	   return apiResponse;
	 }	
	  
	 public Map<String, Ride> getMap() {
	   return cheapestRides;
	 }
}