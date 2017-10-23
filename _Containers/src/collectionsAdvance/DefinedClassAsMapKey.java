package collectionsAdvance;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DefinedClassAsMapKey {

	public static void main(String[] args) {
		TreeMapTest();
		HashMapTest();
	}

	public static void HashMapTest() {
		System.out.println("HashMap: Should NOT have duplicated items");
		testImpl(new HashMap<Person, Integer>());
	}

	public static void TreeMapTest() {
		System.out.println("TreeMap: Should be sorted (no duplicated items either)");
		testImpl(new TreeMap<Person, Integer>());
	}

	private static void testImpl(Map<Person, Integer> map) {
		/* For example: Person-Score */
		map.put(new Person(1, "Ann"), 80);
		map.put(new Person(3, "Bob"), 50);
		map.put(new Person(6, "Ken"), 20);
		map.put(new Person(5, "Lot"), 90);
		map.put(new Person(2, "Stark"), 30);
		map.put(new Person(4, "Robb"), 40);

		/* Duplicated person, and different score, this should not be allowed */
		map.put(new Person(1, "Ann"), 1);
		map.put(new Person(1, "Ann"), 2);
		map.put(new Person(1, "Ann"), 3);
		map.put(new Person(1, "Ann"), 4);

		for (Map.Entry<Person, Integer> e : map.entrySet()) {
			System.out.println("Person: " + String.format("%-8s", e.getKey()) + " | Score: " + e.getValue());
		}
		System.out.println("===============================");
	}
}
