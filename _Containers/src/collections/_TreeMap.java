package collections;
import java.util.Map;
import java.util.TreeMap;

public class _TreeMap {

	public static void main(String[] args) {
		//Map<Integer, Integer> tm = new TreeMap<>();  //pollLastEntry() is defined in TreeMap
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		tm.put(5, 50);
		tm.put(3, 700);
		tm.put(2, 2);
		tm.put(7, 10);
		tm.put(1, 150);
		tm.pollLastEntry(); 
		System.out.println(tm);  //sorted by key
	}
}
