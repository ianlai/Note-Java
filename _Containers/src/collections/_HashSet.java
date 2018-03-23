package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetUse {

	public static void main(String[] args) {
		SetUse obj = new SetUse();
		obj.testSetString();

	}
	private void testSetString(){
		/* Prevent redundant */
		Set<String> set = new HashSet<>();
		String s1 = "abc";
		String s2 = "hello";
		set.add(s1);
		set.add(s2);
		
		set.add(s1);               //redundant String var
		System.out.println(set);   //ok
		
		set.add("hello");          //redundant String 
		System.out.println(set);   //ok
	
		set.add(new String("abc"));
		System.out.println(set);  	
		
		/* Switch Set to List */
		List<String> list = new ArrayList<>(set);
		System.out.println(list); 
		
	}

}
