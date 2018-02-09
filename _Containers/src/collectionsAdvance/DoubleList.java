package collectionsAdvance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class DoubleList {

	public static void main(String[] args) {
		Set<Integer> setInt = new HashSet<Integer>();
		System.out.println(setInt.add(5));
		System.out.println(setInt.add(6));
		System.out.println(setInt.add(7));
		System.out.println(setInt.add(5));  //exist! 

		System.out.println("======= Use set to check redundant list ==========");
		
		/* Use a Set List, we can check whether the list exists or not */ 
		Set<List<Integer>> setList = new HashSet<>();
		System.out.println(setList.add(new ArrayList<Integer>(Arrays.asList(1,2,3))));
		System.out.println(setList.add(new ArrayList<Integer>(Arrays.asList(4,5,6))));
		System.out.println(setList.add(new ArrayList<Integer>(Arrays.asList(4,5,6,7,8,9))));
		System.out.println(setList.add(new ArrayList<Integer>(Arrays.asList(1,2,3)))); //exist!
		
		System.out.println("======= Make a listlist based on the original listlist ==========");
		/* Assume we have a listlist and we want to add lists according to the original lists inside 
		 * Ex. 
		 * Before: [1], [2,3,4], [5,6] 
		 * After : [1], [2,3,4], [5,6], [1,9], [2,3,4,9], [5,6,9] */ 
		List<List<Integer>> listlist = new ArrayList<>();
		listlist. add(new ArrayList<Integer>(Arrays.asList(1)));
		listlist. add(new ArrayList<Integer>(Arrays.asList(2,3,4)));
		listlist. add(new ArrayList<Integer>(Arrays.asList(5,6)));
		System.out.println(listlist);
		/* Concurrent Modification Exception ! */
//		for(List<Integer> e: listlist) {
//			List<Integer> temp = new ArrayList<Integer>(e);
//			temp.add(9);
//			listlist.add(temp);
//		}
		
		/* Copy the all Method-1 */
		//List<List<Integer>> templl = new ArrayList<>(listlist);
		
		/* Copy the all Method-2 */
		List<List<Integer>> templl = new ArrayList<>();
		templl.addAll(listlist);
		
		/* templl has same lists as listlist */
		System.out.println("templl: " + templl);
		
		/* Add new lists to templl */ 
		for(List<Integer> e: listlist) {
			List<Integer> temp = new ArrayList<Integer>(e);
			temp.add(9);
			templl.add(temp);
		}
		System.out.println("templl: " + templl);
	}
}
