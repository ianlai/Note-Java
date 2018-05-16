package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class _List {

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();  //resizable array (fastest)
 		List<Integer> l2 = new LinkedList<>(); //double linked list (depends on operation) 
		List<Integer> l3 = new Vector<>();     //resiable array with synchronized (slower)
		test(l1);
		test(l2);
		test(l3);
	}
	
	public static void test(List<Integer> l){
		System.out.println("---------" + l.getClass().getSimpleName() + "---------");
		addTail(l);
		addIndex(l);
		print(l);	
		
		removeIndex(l);
		print(l);
		
		removeElement(l);
		print(l);
		
		set(l);
		print(l);
		System.out.println(l.contains(999));
		
		testCopyList();
		testCopyList2();
	}
	public static void addTail(List<Integer> l){
		l.add(1);
		l.add(2);
		l.add(3);
	}
	public static void addIndex(List<Integer> l){
		l.add(0,10);  //insert 10 at index=0
		l.add(2,20);
	}
	public static void removeIndex(List<Integer> l){
		l.remove(2);
	}
	public static void removeElement(List<Integer> l){
		//l.remove(10);                  //won't work, becasue it calls remove(index)
		l.remove(Integer.valueOf(10));   //works, because it calls remove(object)
		l.remove(new Integer(3));        //works, because it calls remove(object)
	}
	public static void set(List<Integer> l){
		l.set(0,999);  
	}
	public static void testCopyList(){
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
	public static void testCopyList2(){
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<>();
		l.add(9);
		ll.add(l);
		System.out.println(ll);
		l.add(999);
		System.out.println(ll);  //l add 999 will reflect in ll even l is inserted into ll before
	}
	public static void print(List<Integer> l){
		Iterator it = l.iterator();
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}
}
