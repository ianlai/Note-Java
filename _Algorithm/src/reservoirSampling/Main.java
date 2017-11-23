package reservoirSampling;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(10);
		ListNode l2 = new ListNode(20);
		ListNode l3 = new ListNode(30);
		ListNode l4 = new ListNode(40);
		l1.next = null;
		//l1.next = l2;
		//l2.next = l3;
		//l3.next = l4;
		//l4.next = null;
		
		Solution s = new Solution(l1); //head

		for(int i=0; i<10; ++i){
			int r = s.getRandom();
			System.out.println(">> " + r);
		}
		
		//Statistics - Normal Random 
		System.out.println("--------------- Normal Random ---------------");
		Random rand = new Random();
		int max = 1000;
		Map<Integer, Integer> map1 = new HashMap<Integer,Integer>();
		map1.put(1, 0);
		map1.put(2, 0);
		map1.put(3, 0);
		map1.put(4, 0);
		for(int i=0; i<max; ++i){
			int r = rand.nextInt(4) + 1 ;  //[1,4]
			map1.replace(r, map1.get(r) + 1);
		}
		for(Map.Entry<Integer, Integer> p: map1.entrySet()){
			System.out.println(p.getKey() + ":"+ p.getValue());
		}
		
		//Statistics - Reservoir Sampling
		System.out.println();
		System.out.println("--------------- Reservoir Sampling ---------------");
		Map<Integer, Integer> map2 = new HashMap<Integer,Integer>();
		map2.put(1, 0);
		map2.put(2, 0);
		map2.put(3, 0);
		map2.put(4, 0);
		for(int i=0; i<max; ++i){
			int r = s.getRandom(); //[1,4]
			map2.replace(r, map2.get(r) + 1);
		}
		for(Map.Entry<Integer, Integer> p: map2.entrySet()){
			System.out.println(p.getKey() + ":"+ p.getValue());
		}

	}

}
