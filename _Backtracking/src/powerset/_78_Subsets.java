package powerset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _78_Subsets {

	public static void main(String[] args) {
		_78_Subsets obj = new _78_Subsets();
		
		//Java8
		Comparator<List> sizeComp = (a1, a2) -> a1.size() - a2.size();
		
		//Java7
//		Comparator<List> sizeComp = new Comparator<List>(){
//			@Override
//			public int compare(List a1, List a2) {
//				return a1.size() - a2.size();
//			}
//		};
		
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4));

		
		List<List<Integer>> powerset1 = new ArrayList<List<Integer>>();
		powerset1 = obj.getPowerset(list);
		
		List<List<Integer>> powerset2 = new ArrayList<List<Integer>>();
		powerset2 = obj.getPowersetIterative(list);
		
		/* sorting the result */
		Collections.sort(powerset1, sizeComp);
		
		System.out.println("===== Recursive =====");
		System.out.println(powerset1);
		System.out.println(powerset1.size());
		
		System.out.println("===== Iterative =====");
		System.out.println(powerset2);
		System.out.println(powerset2.size());
		
		obj.testCopyList();
		obj.testCopyList2();
	}
	
	public void testCopyList(){
		List<List<Integer>> ll1 = new ArrayList<List<Integer>>();
		List<List<Integer>> ll2 = new ArrayList<List<Integer>>();
		ll1.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
		ll1.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
		ll1.add(new ArrayList<Integer>(Arrays.asList(7,8,9)));
		ll2.addAll(ll1); 
		ll1.clear();
		System.out.println(ll1);
		System.out.println(ll2);  //ll2 can show the list correctly even using addAll()	
	}
	public void testCopyList2(){
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<>();
		l.add(9);
		ll.add(l);
		System.out.println(ll);
		l.add(999);
		System.out.println(ll);  //l add 999 will reflect in ll even l is inserted into ll before
	}
	/* Iterative */
	public List<List<Integer>> getPowersetIterative(List<Integer> set) {
		if (set == null || set.size() == 0)
			return null;
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		for (int i = 0; i < set.size(); i++) {

			List<List<Integer>> temp = new ArrayList<List<Integer>>();
			for (List<Integer> l : answer) {
				List<Integer> lwithNew = new ArrayList<Integer>(l);
				lwithNew.add(set.get(i));
				temp.add(lwithNew);
			}
			
			List<Integer> single = new ArrayList<Integer>();
			single.add(set.get(i));
			temp.add(single);
	 
			answer.addAll(temp);
		}
		/* Add empty list */
		answer.add(new ArrayList<Integer>());
		return answer; 
	}

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
				answer.add(new ArrayList<Integer>(subset));   //copy by own definition (very important)
				subset.add(item);        //finish creating the new sets
				answer.add(subset);      //add the new sets to powerset
			}
		}
		return answer;
	}
	
	//----------------------------------------------------
}
