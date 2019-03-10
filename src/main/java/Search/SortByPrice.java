package Search;
import java.util.Comparator;

public class SortByPrice implements Comparator<Ride> {
	public int compare(Ride r1, Ride r2) {
		return r1.getPrice() - r2.getPrice();
	}
}