package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _078_Subsets {

	public static void main(String[] args) {
		_078_Subsets obj = new _078_Subsets();
		
		/* Comparator by size */
		//Java8
		Comparator<List> sizeComp = (a1, a2) -> a1.size() - a2.size();
		
		//Java7
//		Comparator<List> sizeComp = new Comparator<List>(){
//			@Override
//			public int compare(List a1, List a2) {
//				return a1.size() - a2.size();
//			}
//		};
		
		/* Comparator by numbers inside */
		//Java7
		Comparator<List<Integer>> numComp = new Comparator<List<Integer>>(){
			@Override
			public int compare(List<Integer> a1, List<Integer> a2) {
				if(a1.size()==a2.size()) {
					StringBuilder sb1 = new StringBuilder();
					for(int e: a1) {
						sb1.append(e);
					}
					StringBuilder sb2 = new StringBuilder();
					for(int e: a2) {
						sb2.append(e);
					}
					return Integer.parseInt(sb1.toString()) - Integer.parseInt(sb2.toString());
				}else {
					return a1.size() - a2.size();
				}
			}
		};
		
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4));

		
		List<List<Integer>> powerset1 = new ArrayList<List<Integer>>();
		powerset1 = obj.getPowerset(list);
		
		List<List<Integer>> powerset2 = new ArrayList<List<Integer>>();
		powerset2 = obj.getPowersetIterative(list);
		
		/* sorting the result */
		//Collections.sort(powerset1, sizeComp);
		Collections.sort(powerset1, numComp);
		
		System.out.println("===== Recursive =====");
		System.out.println(powerset1);
		System.out.println(powerset1.size());
		
		System.out.println("===== Iterative =====");
		System.out.println(powerset2);
		System.out.println(powerset2.size());
	}
	//----------------------------------------------------
	/* Iterative */
	public List<List<Integer>> getPowersetIterative(List<Integer> set) {
		if (set == null || set.size() == 0)
			return null;
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		for (int i = 0; i < set.size(); i++) {
			/* (1) answer has original elements (last round) ex. [1] [1,2] [2]*/
			
			/* (2) add new elements with (1) listlist ex. [1,3] [1,2,3] [2,3] */
			List<List<Integer>> temp = new ArrayList<List<Integer>>();
			for (List<Integer> l : answer) {
				List<Integer> lwithNew = new ArrayList<Integer>(l);
				lwithNew.add(set.get(i));
				temp.add(lwithNew);
			}
			/* (3) add new single element ex. [3]*/
			List<Integer> single = new ArrayList<Integer>();
			single.add(set.get(i));
			temp.add(single);
	 
			answer.addAll(temp);
		}
		/* (4) add empty list ex. [] */
		answer.add(new ArrayList<Integer>());
		return answer; 
	}
	//----------------------------------------------------
	/* Recursive */
	public List<List<Integer>> getPowerset(List<Integer> set) {
		return getPowerset(set, set.size() - 1);
	}
	
	private List<List<Integer>> getPowerset(List<Integer> set, int index){
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
				/* without new item */ 
				answer.add(new ArrayList<Integer>(subset));   //copy by own definition (very important)
				
				/* with new items */
				subset.add(item);        //finish creating the new sets
				answer.add(subset);      //add the new sets to powerset
			}
		}
		return answer;
	}
	
	//----------------------------------------------------
}
