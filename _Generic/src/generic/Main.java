package generic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// http://tutorials.jenkov.com/java-generics/wildcards.html

public class Main {

	public static void main(String[] args) {

		// =============== Generic Type (function)
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

		System.out.println("Array integerArray contains:");
		printArray(intArray); // pass an Integer array

		System.out.println("\nArray doubleArray contains:");
		printArray(doubleArray); // pass a Double array

		System.out.println("\nArray characterArray contains:");
		printArray(charArray); // pass a Character array

		System.out.println();
		
		// =============== Wildcards (assign collection) 
		
		// ----- Object only
		A a = new B();
		B b = new B();
		a = b; // B is-a A 

		// B a = new A();  //No, of course, because A is not a B
		
		// ----- Collections
		// List<A > listA = new ArrayList<A>();
		// List<B> listB = new ArrayList<B>();
		// listA = listB;   //No, listB is NOT a listA, even though B is-a A
		
		List<? extends A> listA = new ArrayList<A>();
		List<B> listB = new ArrayList<B>();
		listA = listB;      //OK, because listA is a list contains object "extends A (including A)", so listB can be assigned to
		
		
		// =============== Wildcards (assign collection when calling functions)
		Integer i = 5;
		System.out.println(me(i)); // OK, Integer is-a Number, so even the argument type is Number, we can pass a Integer too  

		List<Number> listn = new ArrayList<>(Arrays.asList(5,6,7,8,9));
		List<Integer> listi = new ArrayList<>(Arrays.asList(5,6,7,8,9));

		System.out.println(sum(listn));   //OK, the type is matched
		//System.out.println(sum(listi)); //No, List<Integer> is NOT a List<Number>, even though Integer is a Number
		System.out.println(sumWildcard(listn)); // OK
		System.out.println(sumWildcard(listi)); // OK
	}

	public static <T> void printArray(T[] inputArray) {
		// Display array elements
		for (T element : inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public static double sum(List<Number> list) {
		double sum = 0;
		for (Number n : list) {
			sum += n.doubleValue();
		}
		return sum;
	}

	public static double sumWildcard(List<? extends Number> list) {
		double sum = 0;
		for (Number n : list) {
			sum += n.doubleValue();
		}
		return sum;
	}

	public static double me(Number n) {
		return n.doubleValue();
	}
}
