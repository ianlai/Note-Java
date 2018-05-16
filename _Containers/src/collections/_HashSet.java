package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _HashSet {

	public static void main(String[] args) {
		_HashSet obj = new _HashSet();
		obj.testSetString();

	}
	private void testSetString(){
		
		Set<String> set = new HashSet<>();
		String s1 = "abc";
		String s2 = "hello";
		String s3 = new String("abc"); 
		
		set.add(s1);
		set.add(s2);
		
		/* String comparison */ 
		if(s1=="abc") 
			System.out.println("same1");  //same
		if(s1.equals("abc")) 
			System.out.println("same2");  //same
		if(s1==s3) 
			System.out.println("same3");  //not the same (two objects) 
		if(s1.equals(s3))                
			System.out.println("same4");  //same
		
		/* Prevent redundant */
		set.add(s1);               //added string var
		System.out.println(set);   //ok, not added
		
		set.add("hello");          //added string literal 
		System.out.println(set);   //ok
	
		set.add(s3);               //new String obj with the same content 
		System.out.println(set);   //ok, not added 
		
		/* Switch Set to List */
		List<String> list = new ArrayList<>(set);
		System.out.println("Set -> List :");
		System.out.println(list); 	
	}
}
