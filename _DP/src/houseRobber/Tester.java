package houseRobber;

public class Tester {

	public static void main(String[] args) {
		_198_HouseRobber  hr1 = new _198_HouseRobber();
		_213_HouseRobber2 hr2 = new _213_HouseRobber2();
		
		int[] arr = new int[]{3,2,4,5,2,9,7,4};
		
		//line  
		System.out.println("Line:  " + hr1.rob1(arr));
		System.out.println("Line:  " + hr1.rob2(arr, 0, arr.length-1));
		
		//cycle
		System.out.println("Cycle: " + hr2.robCycle(arr));
	}
}