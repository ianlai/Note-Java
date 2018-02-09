package collectionsAdvance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.TreeMap;

public class SortMapByKey {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("aaa", 720);
		map.put("akk", 190);
		map.put("bnn", 360);
		map.put("bbb", 910);
		map.put("zzz", 450);
		map.put("yzz", 820);
		map.put("ddf", 550);

		System.out.println("=== Sorted by key, ascending");
		Map<String, Integer> sortedMap1 = sortByKey(map, true);
		System.out.println(sortedMap1);
		System.out.println();
		
		System.out.println("=== Sorted by key, descending");
		Map<String, Integer> sortedMap2 = sortByKey(map, false);
		System.out.println(sortedMap2);
		System.out.println();
		
		System.out.println("=== Sorted by value, ascending");
		Map<String, Integer> sortedMap3 = sortByValue(map, true);
		System.out.println(sortedMap3);
		System.out.println();
		
		System.out.println("=== Sorted by value, descending");
		Map<String, Integer> sortedMap4 = sortByValue(map, false);
		System.out.println(sortedMap4);
		System.out.println();
	}

	private static Map<String, Integer> sortByKey(Map<String, Integer> map, boolean ascending) {
		TreeMap<String, Integer> treeMap = null;
		if (ascending)
			treeMap = new TreeMap<String, Integer>(map);
		else {
			Comparator<String> decendingComp = new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					return s2.compareTo(s1);
				}
			};
			treeMap = new TreeMap<String, Integer>(decendingComp);
			treeMap.putAll(map);
		}
		return treeMap;
	}

	private static Map<String, Integer> sortByValue(Map<String, Integer> map, boolean ascending) {
		Comparator<Map.Entry<String, Integer>> comp = null;
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		/* To maintain the insertion order */
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>(); 
		
		if (ascending) {
			comp = new Comparator<Map.Entry<String, Integer>>() {
				@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					return o1.getValue() - o2.getValue();
				}
			};
			Collections.sort(list, comp);
			for (Map.Entry<String, Integer> e : list) {
				sortedMap.put(e.getKey(), e.getValue());
			}
		} else {
			Collections.sort(list,
					(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) 
						-> e2.getValue() - e1.getValue());
			for(Entry<String, Integer> e : list) {
				sortedMap.put(e.getKey(), e.getValue());
			}
		}
		return sortedMap;
	}
}
