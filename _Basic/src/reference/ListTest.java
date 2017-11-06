package reference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListTest {
	public void run(){
		System.out.println("=================== Single List =================== ");  
		
		System.out.println(">> Old List:");
		List<Integer> oldList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		System.out.println(oldList);
		System.out.println();
		
		System.out.println(">> New List, addAll(oldList):");
		List<Integer> newList = new ArrayList<>();
		newList.addAll(oldList);
		System.out.println(newList);
		System.out.println();
		
		System.out.println(">> Modify old list");
		for(int i=0; i<oldList.size();i++){
			int n = oldList.get(i) + 10;
			oldList.set(i, n);
		}
		System.out.println();
		
		System.out.println(">> New list will not changed with old list:");
		System.out.println("Old list: " + oldList);
		System.out.println("New list: " + newList  + "<- will NOT be changed (good)");  //not changed 
		System.out.println();
		
		System.out.println("=================== Double List =================== ");   
		
		List<List<Integer>> oo = new ArrayList<List<Integer>>();
		List<Integer> a0 = new ArrayList<Integer>();
		List<Integer> a1 = new ArrayList<Integer>(Arrays.asList(1));
		oo.add(a0);
		oo.add(a1);
		System.out.println(">> Old double List:");
		System.out.println(oo);
		System.out.println();
		
		List<List<Integer>> nn = new ArrayList<List<Integer>>();
		List<List<Integer>> nn2 = new ArrayList<List<Integer>>();
		List<List<Integer>> nn3 = new ArrayList<List<Integer>>();
		
		//1, bad, because two lists will be connected
		nn.addAll(oo);  //Dont use the default one!!!

		//2, worse, because two lists will be connected, and destination list should be allocated spaces already
		nn2.add(new ArrayList<Integer>());
		nn2.add(new ArrayList<Integer>());
		Collections.copy(nn2, oo);
		
		//3, good, copy it element by element 
		for(List<Integer> l: oo){   
			nn3.add(new ArrayList<Integer>(l));  //Copy by yourself!!!
		}
		
		System.out.println(">> New double List - 1, addAll():");	 //NO!
		System.out.println(nn);
		System.out.println(">> New double List - 2, Collections.copy():");	 //NO!
		System.out.println(nn2);
		System.out.println(">> New double List - 3, add one by one :");	 //OK
		System.out.println(nn3);
		System.out.println();
		
		System.out.println(">> Modify old doulbe list");
		for(List<Integer> l: oo){
			l.add(33);
		}
		System.out.println();
		
		System.out.println(">> New list WILL changed with old list:");
		System.out.println("Old double list:  " + oo);
		System.out.println("New double list1: " + nn  + " <- changed (bad)");
		System.out.println("New double list2: " + nn2 + " <- changed (bad)");
		System.out.println("New double list3: " + nn3 + " <- will NOT be changed (good)");
	}
}
