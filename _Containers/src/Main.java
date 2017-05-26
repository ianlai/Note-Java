

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		showArray();
		showCollection();  //1-9 are List, 10 is Set
	}
	public static void showArray(){

		//========== 1.Initialize ==========
		System.out.println("========== 1.Initialize ==========");
		int[] arr1 = new int[]{3,4,5,6,7,8,9,0,1,2};
		int[] arr2 = new int[10];
		//int[] arr3 = new int[10]{3,4,5,6,7,8,9,0,1,2};  //Error
		
		
		//========== 2.Operation ==========
		System.out.println("========== 2.Operation ==========");
		arr1[0] = 99;
		arr1[arr1.length-1] = 999;
		
		
		//========== 3.Traverse ==========
		System.out.println("========== 3.Traverse ==========");
		for(int i=0; i<arr1.length; i++){
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for(int e: arr1){
			System.out.print(e + " ");
		}
		System.out.println();
		
		
		//========== 4.Contains (no cool method) ==========
		System.out.println("========== 4.Contains ==========");
		int targetY = 9;
		int targetN = 15;
		int indexY = -1;
		int indexN = -1;
		for(int i=0; i<arr1.length; i++){
			if(targetY == arr1[i]){
				indexY = i; 
			}
			if(targetN == arr1[i]){
				indexN = i; 
			}
		}
		System.out.println("Found " + targetY + " at " + indexY);
		System.out.println("Found " + targetN + " at " + indexN);
		
		
		//========== 5.Copy ==========
		System.out.println("========== 5.Copy ==========");
		int[] dst = new int[arr1.length];
		System.arraycopy(arr1, 0, dst, 0, arr1.length);
		
		
		//========== 6.Print ==========
		System.out.println("========== 6.Print ==========");
		System.out.println(Arrays.toString(dst));  
		
		//========== 7.Sorting ==========
		System.out.println("========== 7.Sorting ==========");
		Arrays.sort(dst); //in-place
		System.out.println(Arrays.toString(dst));  		
		
		//========== 8.Convert to List ==========
		System.out.println("========== 8.Convert ==========");
		List<Integer> list1 = new ArrayList<Integer>();
		//list1 = Arrays.asList(arr1);  //No, because arr1 is a primitive type 
		
		List<Integer> list2 = new ArrayList<Integer>();
		Integer[] integerArr = new Integer[]{7,8,9,10,11};
		list2 = Arrays.asList(integerArr);  //Yes, because integerArr is an Integer type
		
		List<Integer> list3 = new ArrayList<Integer>();
		for(int e: arr1){
			list3.add(e);                   //Use loop to convert int[] to ArrayList<Integer>
		}
		
		List<Integer> list4 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));  //pass elements also ok
		
		System.out.println(list2);          //list can be printed directly 
		System.out.println(list3);
		System.out.println(list4);
		
		System.out.println();
		System.out.println();
	}
	public static void showCollection(){
		
		//========== 1.Initialize ==========
		System.out.println("========== 1.Initialize ==========");
		//List<Integer> list = new List<Integer>();     //No, List is an interface 
		List<Integer> list = new ArrayList<Integer>();
		
		
		//========== 2.Operation ==========
		System.out.println("========== 2.Operation ==========");
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);  //element 
		list.add(6);
		list.add(7);
		list.add(8);
		System.out.println(list);
		System.out.println("Size of list: " + list.size());
		
		System.out.println("Index 1:" + list.get(1)); //like arr[1]
		System.out.println("Index 2:" + list.get(2)); //like arr[2]
		
		list.remove(2);  //index
		list.remove(3);  //index
		list.remove(4);  //index
		list.set(1, 10);  //index, element
		list.set(2, 20);  //index, element 
		System.out.println(list);
		System.out.println("Size of list: " + list.size());
		
		
		//========== 3.Traverse ==========
		System.out.println("========== 3.Traverse ==========");
		for(int i=0; i<list.size(); i++){
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		for(Integer e: list){
			System.out.print(e + " ");
		}
		System.out.println();
		
		
		//========== 4.Contains (easier than Array) ==========
		System.out.println("========== 4.Contains ==========");
		int targetY = 20;  //inside
		int targetN = 50;  //not inside
		
		System.out.println("Found " + targetY + " at " + list.indexOf(targetY));
		System.out.println("Found " + targetN + " at " + list.indexOf(targetN)); //if no, return -1
		
		System.out.println("Check " + targetY + " in the list? " + list.contains(targetY));
		System.out.println("Found " + targetN + " in the list? " + list.contains(targetN)); //if no, return false
		
		//========== 5.Copy ==========
		System.out.println("========== 5.Copy ==========");
		List<Integer> dst1 = new ArrayList<Integer>(list); //copy when initializing
		System.out.println(dst1);

		List<Integer> dst2 = new ArrayList<Integer>();     //addAll()
		dst2.addAll(list);
		System.out.println(dst2);
		
		List<Integer> dst3;
		dst3 = (ArrayList<Integer>) ((ArrayList<Integer>) list).clone();  //clone()
		System.out.println(dst3);
		
		//Make sure each copy created a new list, instead of only copying the reference 
		System.out.println("Sort dst1:");
		Collections.sort(dst1);
		System.out.println(dst1);
		System.out.println(list);
		
		System.out.println("Sort dst2:");
		Collections.sort(dst2);
		System.out.println(dst2);
		System.out.println(list);
		
		System.out.println("Sort dst3:");
		Collections.sort(dst3);
		System.out.println(dst3);
		System.out.println(list);
		
		//========== 6.Print ==========
		System.out.println("========== 6.Print ==========");
		System.out.println(list); 
		
		//========== 7.Sorting ==========
		System.out.println("========== 7.Sorting ==========");
		Collections.sort(list); //in-place
		System.out.println(list);  		
		
		//========== 8.Convert to Array ==========   
		System.out.println("========== 8.Convert ==========");
		Integer[] arrInteger = list.toArray(new Integer[list.size()]);  //to Integer Array
		
		int[] arrInt = new int[list.size()];   //to int Array
		for(int i=0; i<list.size(); i++){
			arrInt[i] = list.get(i);
		}
		System.out.println(Arrays.toString(arrInteger));
		System.out.println(Arrays.toString(arrInt));
		
		//========== 9.Two Dimension ==========
		System.out.println("========== 9.Two Dimension ==========");
		
		int[] a1 = new int[]{1,5,7};
		int[] a2 = new int[]{2,6,9};
		int[] a3 = new int[]{15,22,56};
		List<List<Integer>> llist = new ArrayList<List<Integer>>();
		
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		List<Integer> l3 = new ArrayList<>();
		for(int e: a1){
			l1.add(e);
		}
		llist.add(l1);
		
		for(int e: a2){
			l2.add(e);
		}
		llist.add(l2);
		
		for(int e: a3){
			l3.add(e);
		}
		llist.add(l3);
		System.out.println(llist);
		
		//========== 10.Different Collections (Set) ==========
		System.out.println("========== 10.Different Collections (Set) ==========");
		Integer[] varArr = new Integer[]{70, 50, 30, 80, 100};
		Set<Integer> hs = new HashSet<>();  //normal set (no order guarantee)
		Set<Integer> ts = new TreeSet<>();  //sorted 
		Set<Integer> ls = new LinkedHashSet<>(); //insertion order 
		
		for(Integer e: varArr){
			hs.add(e);
			ts.add(e);
			ls.add(e);
		}
		System.out.println("HashSet:");
		System.out.println(hs);
		System.out.println("TreeSet:");
		System.out.println(ts);
		System.out.println("LinkedHashSet:");
		System.out.println(ls);
  	}
	
}
