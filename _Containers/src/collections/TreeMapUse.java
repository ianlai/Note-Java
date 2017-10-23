package collections;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapUse {

	public static void main(String[] args) {
		//Map<Integer, Integer> tm = new TreeMap<>();  //pollLastEntry() is defined in TreeMap
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		tm.put(5, 500);
		tm.put(3, 300);
		tm.put(2, 200);
		tm.put(7, 700);
		tm.put(1, 100);
		tm.pollLastEntry(); 
	}

}
