package powerset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
	
		Comparator<List> sizeComp = (a1, a2) -> a1.size() - a2.size();
						
//		Comparator<List> sizeComp = new Comparator<List>(){
//			@Override
//			public int compare(List a1, List a2) {
//				return a1.size() - a2.size();
//			}
//		};
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		List<List<Integer>> powerset = new ArrayList<List<Integer>>();
		powerset = getPowerset(list);
		
		/* sorting the result */
		Collections.sort(powerset, sizeComp);
		
		System.out.println(powerset);
		System.out.println(powerset.size());
	}
	public static List<List<Integer>> getPowerset(List<Integer> set){
		return getPowerset(set, set.size()-1);
	}
	
	private static List<List<Integer>> getPowerset(List<Integer> set, int index){
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		
		if(index == 0){  
			List<Integer> empty = new ArrayList<Integer>();
			List<Integer> first = new ArrayList<Integer>();
			first.add(set.get(index));  
			answer.add(empty);   //[]
			answer.add(first);   //[a1]
		}else if(index > 0){
			List<List<Integer>> newSuperset = getPowerset(set, index-1);
			int item = set.get(index);
			//answer.addAll(newSuperset);  //create new sets based on old sets
			for(List<Integer> subset: newSuperset){
				answer.add(new ArrayList<Integer>(subset));   //copy by own definition (very important)
				subset.add(item);        //finish creating the new sets
				answer.add(subset);      //add the new sets to powerset
			}
		}
		return answer;
	}
}
