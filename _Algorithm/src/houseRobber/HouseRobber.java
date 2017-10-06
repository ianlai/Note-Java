package houseRobber;

public class HouseRobber {

	public static void main(String[] args) {
		HouseRobber hr = new HouseRobber();
		int[] arr = new int[]{3,2,4,5,2,9,7,4};
		
		//line  
		System.out.println("Line:  " + hr.rob1(arr));
		System.out.println("Line:  " + hr.rob2(arr, 0, arr.length-1));
		
		//cycle
		System.out.println("Cycle: " + hr.robCycle(arr));
	}

	/* Correct, but this cannot be extended to variable index */
	public int rob1(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; ++i) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[nums.length - 1];
	}

	//--------------
	//Cycle 
	public int robCycle(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		return Math.max(rob2(nums, 0, nums.length - 2), rob2(nums, 1, nums.length - 1));
	}
	//Generalize for rob1 
	public int rob2(int[] nums, int l, int h) {
		if (l == h)
			return nums[l];
		int size = h - l + 1;
		int[] dp = new int[size];
		dp[0] = nums[l];
		dp[1] = Math.max(nums[l], nums[l + 1]);
		for (int i = 2; i < size; ++i) {
			dp[i] = Math.max(dp[i - 2] + nums[l + i], dp[i - 1]); // nums[l+i],
																	// not
																	// nums[i]
		}
//		for (int i = 0; i < dp.length; ++i) {
//			System.out.println(i + " : " + dp[i]);
//		}
		return dp[size - 1];
	}
}