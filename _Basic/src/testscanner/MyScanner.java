package testscanner;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

/*
 5     <-- number
 1 1   <-- manager, value
 0 2
-1 6
 2 3
 2 5 
 3 4 
 
Stdin: 

9
6 9
0 6
6 3
2 2
2 5
2 4 
-1 8
1 7 
1 3 

Store in a list of list:  
[index, manager, value] 
0 6 9
1 0 6
2 6 3
3 2 2
4 2 5
5 2 4 
6 -1 8
7 1 7 
8 1 3 

*/

public class MyScanner {

	public static void main(String[] args) {
		System.out.println("Test scanner");
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		
		List<Integer> node = new ArrayList<Integer>();
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		Queue<List<Integer>> queue = new ArrayDeque<List<Integer>>();
		
		String line="";
		int count = 0; 
		System.out.println(in.nextLine());  //empty

		while(!(line=in.nextLine()).isEmpty()){
			//System.out.println("a");
			//String s = in.nextLine();
			List<Integer> temp = new ArrayList<Integer>();   //[index, manager, value]
			int manager = Integer.valueOf(line.split(" ")[0]);
			int value = Integer.valueOf(line.split(" ")[1]);
			temp.add(count);
			temp.add(manager);
			temp.add(value);
			count++;
			
			ll.add(temp);
		}
		
		System.out.println("Number:" + number);
		System.out.println("LL    :" + ll);
		
		List<Integer> root = new ArrayList<Integer>();		
		int target = -9;
		for(List<Integer> l : ll){
			if(l.get(1)==-1){
				root = l; 
				target = root.get(0);
				//ll.remove(l);
			}
		}
		for(List<Integer> l : ll){
			if(l.get(1)==target){
				queue.add(l); 
			}
		}
		//System.out.println(root);
	}
}


