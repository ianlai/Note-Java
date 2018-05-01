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
		tm.put(9, 65);
		tm.put(4, 15);
		System.out.println(tm);  //sorted by key
		
		
		System.out.println("===== Sorted by key =====");
		while(!tm.isEmpty()){
			Map.Entry<Integer, Integer> pair = tm.pollLastEntry();
			System.out.println(pair.getKey() + "--" + pair.getValue());
		}
	}
}
