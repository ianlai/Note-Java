package java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaTest {

	public static void main(String[] args) {
		interface7();
		interface8();
		traverse();
	}
	
	public static void interface7(){
		
		/* We can not create an obj by interface */
		//LambdaInterface op = new LambdaInterface();
		
		/* We can create an obj by interface if we implement the unimplement methods */
		LambdaInterface add = new LambdaInterface(){
			@Override
			public int operation(int a, int b) {
				return a+b;
			}
		};
		
		/* We can create different operation instances */
		LambdaInterface sub = new LambdaInterface(){
			@Override
			public int operation(int a, int b) {
				return a-b;
			}
		};
		
		System.out.println("[Java 7]");
		
		int p1 = 15;
		int p2 =  3;
		System.out.println(">> add: " + p1 + " , " + p2);
		System.out.println(add.operation(p1, p2));
		System.out.println(">> sub: " + p1 + " , " + p2);
		System.out.println(sub.operation(p1, p2));
	}
	
	public static void interface8(){
		LambdaInterface add = (a,b) -> a+b;
		LambdaInterface sub = (a,b) -> a-b;
		
		System.out.println("[Java 8]");
		
		int p1 = 15;
		int p2 =  3;
		System.out.println(">> add: " + p1 + " , " + p2);
		System.out.println(add.operation(p1, p2));
		System.out.println(">> sub: " + p1 + " , " + p2);
		System.out.println(sub.operation(p1, p2));
		
		System.out.println();
		System.out.println();		
	}
	public static void traverse(){
		List<Integer> list = new ArrayList<>();
		Map<Integer, String> map = new HashMap<>();
		list.add(10);
		list.add(20);
		list.add(30);
		map.put(11, "aaa");
		map.put(22, "bbb");
		map.put(33, "ccc");
		
		System.out.println(">>>> Enhanced Loop");
		for(int i: list){
			System.out.println(i);
		}
		for(Map.Entry<Integer, String> e: map.entrySet()){
			System.out.println(e.getKey() + " - " + e.getValue());
		}
		
		System.out.println(">>>> Foreach");
		list.forEach(i->{
			System.out.println(i);
		});
		map.forEach((k,v)->{
			System.out.println(k + " - " + v);  //not need the type 
		});
	}
	
}
