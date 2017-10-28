package collections;

import java.util.ArrayList;
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
	}
	public static void set(List<Integer> l){
		l.set(0,999);  
	}
	public static void print(List<Integer> l){
		Iterator it = l.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println();
	}
}
