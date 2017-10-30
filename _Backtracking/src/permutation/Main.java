package permutation;

import java.util.List;

import powerset._90_Subsets2;

public class Main {

	public static void main(String[] args) {
		
		int[] arr = new int[] { 1, 2, 3 };
		int[] arrRepeat = new int[] { 1, 2, 2, 3 };
		testPermutation1(arr);
		testPermutation2(arrRepeat);
		testSubset1(arr);
		testSubset2(arrRepeat);

	}
	public static void testPermutation1(int arr[]){
		_46_Permutations  p1 = new _46_Permutations();
		_47_Permutations2 p2 = new _47_Permutations2();
		List<List<Integer>> result1 = p1.permute1(arr);
		//List<List<Integer>> result2 = p1.permute2(arr);
		//List<List<Integer>> result3 = p2.permuteUnique(arr);
		printList(result1); // correct
		//printList(result2); // correct
		//printList(result3); // correct
	}
	public static void testPermutation2(int arrRepeat[]){
		_46_Permutations  p1 = new _46_Permutations();
		_47_Permutations2 p2 = new _47_Permutations2();
		//List<List<Integer>> resultRepeat1 = p1.permute1(arrRepeat);
		//List<List<Integer>> resultRepeat2 = p1.permute2(arrRepeat);
		List<List<Integer>> resultRepeat3 = p2.permuteUnique(arrRepeat);

		//printList(resultRepeat1); // wrong (redundant is also shown)
		//printList(resultRepeat2); // wrong (no result because the element will
							      //        never be enough to be added in)
		printList(resultRepeat3); // correct
	}
	public static void testSubset1(int arr[]){
		_90_Subsets2 s2 = new _90_Subsets2();
		List<List<Integer>> result = s2.subsets2(arr);
		printList(result);
	}
	public static void testSubset2(int arr[]){
		_90_Subsets2 s2 = new _90_Subsets2();
		List<List<Integer>> result = s2.subsetsWithDup2(arr);
		printList(result);
	}
	
	
	
	public static void printList(List<List<Integer>> ll) {
		for (int i = 0; i < ll.size(); ++i) {
			System.out.println(i + 1 + ": " + ll.get(i));
		}
		System.out.println("------------------------");
	}
}
