package syntax;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import syntax.StringToInt.A;

public class Note {

	public static void main(_String[] args) {

		
		//=======================================================================

		//Interger - String 
		String sg= Integer.toString(12345);
		Integer ir = Integer.parseInt("34567");
		
		//=======================================================================
		// Container
		int[] a1 = new int[10];
		int[] a2 = new int[]{1,2,3,4,5};
		Integer[] b1 = new Integer[10];
		Integer[] b2 = new Integer[]{10,20,30,40,50};
		ArrayList<Integer> c1 = new ArrayList<>();
		
		a1[1] = 9;
		
		c1.add(3);
		c1.add(4);
		c1.add(5);
		c1.set(1, 10);
		c1.add(6);
		
		//====== Print out (content & size) 
		System.out.println(a1);  //ref
		System.out.println(a1.toString());  //ref
		System.out.println(b1);  //ref
		System.out.println(b1.toString());  //ref
		System.out.println(c1.toString());  //content (with bracket)
		
		System.out.println("==============");
		
		//====== Iterate
		for(int i=0;i<a2.length;i++){
			System.out.print(a2[i] + ", ");  //content
		}
		System.out.println();
		
		for(int i=0;i<b2.length;i++){
			System.out.print(b2[i] + ", ");  //content
		}
		System.out.println();
		
		for(int i=0;i<c1.size();i++){
			System.out.print(c1.get(i) + ", "); //content 
		}
		System.out.println();
		System.out.println("==============");
		
		//====== Conversion 
		
		//(1) int[] -> Integer[]
		Integer[] b3 = new Integer[a2.length];
		for (int i=0;i<a2.length;i++) {
		    b3[i] = Integer.valueOf(a2[i]); //int -> Integer
		}
		
		for(int i=0;i<b3.length;i++){
			System.out.print(b3[i] + ", ");  //content
		}
		
		System.out.println();
		
		//(2) int[] -> list
		ArrayList<Integer> c2 = new ArrayList<>();
		for (int v : a2) {
		    c2.add(v);
		}
		System.out.println(c2);
		
		//(3) interger -> list
		Integer[] IntegerArray = {11, 22, 33, 44}; // cannot use int[] here
		List<Integer> IntergerList = Arrays.asList(IntegerArray); //import Arrays
		System.out.println(IntergerList);
		
		//====== Copy
		int src[] = new int[]{1,2,3,4,5};
		int dst[] = new int[]{6,7,8,9,10};
		System.arraycopy(src, 0, dst, 3, 2);  //src, src-index, dst, dst-index, length
	}

}
