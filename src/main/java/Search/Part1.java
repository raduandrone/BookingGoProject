package Search;
import java.net.*;
import java.util.ArrayList;

public class Part1 {
  public static void main (String args[]) throws Exception {	
  	SearchEngine searchEngine = new SearchEngine();
	  
	  if (!validArguments(args)) {
		  System.err.println("Incorrect arguments format");
		  return;
	  }
	  
	  int passangers = 1;
	        
	  if (args.length == 5) {
		  passangers = Integer.valueOf(args[4]);
	  }
	  	  
	  URL daveUrl = new URL(constructURL(args, "dave"));
    ApiResponse daveApiResponse = searchEngine.makeApiCall(daveUrl);
      
    if (daveApiResponse != null)
    	searchEngine.getRides(daveApiResponse, passangers);
      
    URL ericUrl = new URL(constructURL(args, "eric"));
    ApiResponse ericApiResponse = searchEngine.makeApiCall(ericUrl);
      
    if (ericApiResponse != null)
    	searchEngine.getRides(ericApiResponse, passangers);

    URL jeffUrl = new URL(constructURL(args, "jeff"));
    ApiResponse jeffApiResponse = searchEngine.makeApiCall(jeffUrl);
      
    if (jeffApiResponse != null)
    	searchEngine.getRides(jeffApiResponse, passangers);
     
    ArrayList<Ride> finalList = new ArrayList<Ride>();
      
    for (String carType : searchEngine.getMap().keySet()) {
    	finalList.add(searchEngine.getMap().get(carType));
    }
      
    finalList.sort(new SortByPrice());
    
    for (int i = 0; i < finalList.size(); i++) {
    	System.out.println(finalList.get(i));
     }
  }
  
  public static String constructURL(String args[], String supplier) {
	  StringBuilder stringBuilder = new StringBuilder("https://techtest.rideways.com/");
	  stringBuilder.append(supplier);
	  stringBuilder.append("/");
	  
	  stringBuilder.append("?pickup=");
    double latitude1 = Double.valueOf(args[0]);
    stringBuilder.append(latitude1);
    stringBuilder.append(",");
    double longitude1 = Double.valueOf(args[1]);
    stringBuilder.append(longitude1);
    stringBuilder.append("&dropoff=");
    double latitude2 = Double.valueOf(args[2]);
    stringBuilder.append(latitude2);
    stringBuilder.append(",");
    double longitude2 = Double.valueOf(args[3]);
    stringBuilder.append(longitude2);
     
    return stringBuilder.toString();
  }
  
  public static boolean validArguments(String[] args) {
	  if (args.length < 4 || args.length > 5)
		  return false;
		  
	  if (args.length == 5) {
		  if (Integer.parseInt(args[4]) <= 0) {
			  return false;
		  }
	  }
	  
	  if (!checkDouble(args[0]) || !checkDouble(args[1]) || 
		    !checkDouble(args[2]) || !checkDouble(args[3]))
	  	return false;
	  
	  return true;
  }
  
  public static boolean checkDouble(String toCheck) {
	  try{
	  	Double.valueOf(toCheck);
	 	  return true;

	   }
	   catch (Exception ex){
	  	 return false;
	   }
  }
}
