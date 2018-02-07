package collectionsAdvance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class ListInSet {

	public static void main(String[] args) {
		Set<Integer> setInt = new HashSet<Integer>();
		System.out.println(setInt.add(5));
		System.out.println(setInt.add(6));
		System.out.println(setInt.add(7));
		System.out.println(setInt.add(5));  //exist! 

		System.out.println("=================");
		
		Set<List<Integer>> setList = new HashSet<List<Integer>>();
		System.out.println(setList.add(new ArrayList<Integer>(Arrays.asList(1,2,3))));
		System.out.println(setList.add(new ArrayList<Integer>(Arrays.asList(4,5,6))));
		System.out.println(setList.add(new ArrayList<Integer>(Arrays.asList(4,5,6,7,8,9))));
		System.out.println(setList.add(new ArrayList<Integer>(Arrays.asList(1,2,3)))); //exist!
	}

}
