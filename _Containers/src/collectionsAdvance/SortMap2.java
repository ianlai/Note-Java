package collectionsAdvance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class SortMap2 {

	public static void main(String[] args) {
		Map<Integer, String> m = new HashMap<>();
		m.put(3,"piano");
		m.put(8, "apple");
		m.put(7, "boo");
		m.put(1, "luwa");
		m.put(4, "zip");
		m.put(9, "cat");
		m.put(5, "catie");
		
		/* Sort by key */
		System.out.println("Sort by key:");
		Map<Integer, String> keyMap = new TreeMap<>(m);
		for(Map.Entry<Integer, String> e: m.entrySet()){
			System.out.println(e.getKey() + " -- " + e.getValue());
		}
		
		/* Sort by value */
		System.out.println("Sort by value:");
		List<Map.Entry<Integer,String>> l = new ArrayList<>(m.entrySet());
		Collections.sort(l, 
				(Map.Entry<Integer, String> e1, Map.Entry<Integer, String> e2) 
				-> e1.getValue().compareTo(e2.getValue()));
		for(Map.Entry<Integer, String> e: l){
			System.out.println(e.getKey() + " -- " + e.getValue());
		}
	}
}
