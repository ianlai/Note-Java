package coinChange;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		int target = 15;
		int[] coins = new int[] { 1, 2, 8, 10 };
		
		//int target = 75212;
		//int[] coins = new int[]{5, 7, 1, 2, 9, 16, 4, 8, 17};
		
		System.out.println("[Input]");
		System.out.println("  Target = " + target);
		System.out.println("  Coins  = " + Arrays.toString(coins));
		
		System.out.println("------------");
		
		(new MinCoinChange(target, coins)).run();
		
		System.out.println("------------");
		
		(new TotalCoinChange(target, coins)).run();
	}

}
