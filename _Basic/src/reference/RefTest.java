package reference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Test1: modify value of int, Integer, Object in a method
// Only the modification of the Object will be kept outside of the method
// This is because Java uses call-by-value (primitive's value, or , object's reference)
//
// Test2: modify value of String and StringBuilder in a method
// String is immutable but StringBuilder is mutable (changable)
// Therefore, if using StringBuilder, we can just modify it in the method, 
// but if using String, we need to use return to capture the modified value. 
// Btw, StringBuilder uses a dynamic array to hold the characters,
// so it will be certainly faster than String when doing concatenation. 
//
// Test3: modify value of Array and List in a method
// Both of them will be modified outside of method.

public class RefTest {
	
	class Node{
		int id;
		public Node(int i){
			id = i;
		}
	}
	
	public void run(){
		int i1     =  9;
		Integer i2 = 99;
		Node n1    = new Node(999);
		String s1          = "str";
		StringBuilder sb1  = new StringBuilder("sb");
		int[] arr1 = new int[]{1,2,3};
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1,2,3));
		
		System.out.println("=== Original ===");
		System.out.println("Primitive int: " + i1);
		System.out.println("Integer:       " + i2);
		System.out.println("Object, id:    " + n1.id);
		
		System.out.println("String:        " + s1);
		System.out.println("StringBuilder: " + sb1);
		
		System.out.println("Array: " + Arrays.toString(arr1));
		System.out.println("List:  " + list1);
		
		modifyInt(i1);
		modifyInteger(i2);
		modifyNode(n1);           //keep the modification (Object)
		modifyString(s1);
		modifyStringBuilder(sb1); //keep the modification (StringBuilder)
		modifyArray(arr1);        //keep the modification (Array)
		modifyList(list1);        //keep the modification (List)
		
		System.out.println("=== Modified ===");
		System.out.println("Primitive int: " + i1);
		System.out.println("Integer:       " + i2);
		System.out.println("Object, id:    " + n1.id + " <-- keep the modification (Object)");
		
		System.out.println("String:        " + s1);
		System.out.println("StringBuilder: " + sb1 + " <-- keep the modification (StringBuilder)");
		
		System.out.println("Array:         " + Arrays.toString(arr1) + " <-- keep the modification (Array)");
		System.out.println("List:          " + list1 + " <-- keep the modification (List)");
	}
	private void modifyInt(int i){
		i++;
	}
	private void modifyInteger(Integer i){
		i++;
	}
	private void modifyNode(Node n){
		n.id++;
	}
	private void modifyString(String s){
		s += "-inside";
	}
	private void modifyStringBuilder(StringBuilder sb){
		sb.append("-inside");
	}
	private void modifyArray(int[] arr){
		arr[0]=999;
	}
	private void modifyList(List<Integer> list){
		list.add(10);
	}
}
