package coinChange;

import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		
		//int target = 15;
		//int[] coins = new int[] { 1, 2, 8, 10 };
		
		int target = 10;
		int[] coins = new int[] {2,3,5,6 };
		
		//int target = 75212;
		//int[] coins = new int[]{5, 7, 1, 2, 9, 16, 4, 8, 17};
		
		System.out.println("[Input]");
		System.out.println("  Target = " + target);
		System.out.println("  Coins  = " + Arrays.toString(coins));
		
		System.out.println("------------");
		
		(new _322_CoinChange_Min(target, coins)).run();
		
		System.out.println("------------");
		
		(new TotalCoinChange(target, coins)).run();
	}

}
