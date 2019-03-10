package Search;
import java.util.*;

public class ApiResponse {
  private String supplier_id;
  private String pickup;
  private String dropoff;

  private ArrayList<RideOption> options = null;
  
  public void setSupplierId(String supplier_id) {
	  this.supplier_id = supplier_id;
  }
  
  public void setPickUp(String pickup) {
	  this.pickup = pickup;
  }
  
  public void setDropOff(String dropoff) {
	  this.dropoff = dropoff;
  }
  
  public void setOptions(ArrayList<RideOption> options) {
    this.options = options;
  }
  
  public String getSupplierId() {
    return supplier_id;
  }
  
  public String getPickup() {
    return pickup;
  }
  
  public String getDropoff() {
    return dropoff;
  }
  
  public ArrayList<RideOption> getRideOptions() {
    return options;
  }
  
  @Override
  public String toString() {
	  return supplier_id + "  " + pickup + "  " + dropoff + "  " + options; 
  }
}
