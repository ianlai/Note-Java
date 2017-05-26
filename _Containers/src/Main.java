

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		showArray();
	}
	public static void showArray(){

		//========== 1.Initialize ==========
		int[] arr1 = new int[]{3,4,5,6,7,8,9,0,1,2};
		int[] arr2 = new int[10];
		//int[] arr3 = new int[10]{3,4,5,6,7,8,9,0,1,2};  //Error
		
		
		//========== 2.Operation ==========
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
		
		
		//========== 7.Convert to List ==========
		System.out.println("========== 7.Convert ==========");
		List<Integer> list1 = new ArrayList<Integer>();
		//list1 = Arrays.asList(arr1);  //No, because arr1 is a primitive type 
		
		List<Integer> list2 = new ArrayList<Integer>();
		Integer[] integerArr = new Integer[]{7,8,9,10,11};
		list2 = Arrays.asList(integerArr);  //Yes, because integerArr is an Integer type
		
		List<Integer> list3 = new ArrayList<Integer>();
		for(int e: arr1){
			list3.add(e);                   //Use loop to convert int[] to ArrayList<Integer>
		}
		System.out.println(list2);          //list can be printed directly 
		System.out.println(list3);
		
	}
}
