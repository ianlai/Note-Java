package collections;

import java.util.Set;
import java.util.TreeSet;

/* The comparison between TreeSet and PriorityQueue is in _PriorityQueue.java */
public class _TreeSet {
	public static void main(String[] args) {
		Set<String> set = new TreeSet<>();
		set.add("jkl");
		set.add("xy");
		set.add("abcd");
		set.add("a");
		set.add("dzzzzfghijkkk");
		set.add("dz");
		set.add("ddddd");
		System.out.println(set);  //sorted alphabetically
	}
}
