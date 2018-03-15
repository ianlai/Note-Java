package dp;

import java.util.Random;

/*
 * You are playing the following Nim Game with your friend: 
 * There is a heap of stones on the table, each time one of you 
 * take turns to remove 1 to 3 stones. 
 * The one who removes the last stone will be the winner. 
 * You will take the first turn to remove the stones.
 * Both of you are very clever and have optimal strategies for the game. 
 * Write a function to determine whether you can win the game given the number of stones in the heap.
 * For example, if there are 4 stones in the heap, 
 * then you will never win the game: no matter 1, 2, or 3 stones you remove, 
 * the last stone will always be removed by your friend.
 */
public class _292_NimGame {

	public static void main(String[] args) {
		_292_NimGame obj = new _292_NimGame();
		
		/* Simple Test */
		int n1 = 7721; 
		int n2 = 88888;
		System.out.println(n1 + ":");
		System.out.println(obj.canWinNimMath(n1));
		System.out.println(obj.canWinNimDP(n1));
		System.out.println(obj.canWinNimDP_MuchMemory(n1));
		System.out.println();
		
		System.out.println(n2+ ":");
		System.out.println(obj.canWinNimMath(n2));
		System.out.println(obj.canWinNimDP(n2));
		System.out.println(obj.canWinNimDP_MuchMemory(n2));
		System.out.println();
		
		/* Random Test */
		test();
	}
	public static void test(){
		_292_NimGame obj = new _292_NimGame();
		int number = 100; //test for 100 numbers 
		Random rand = new Random();
		for(int i=0; i<number; i++) {
			int r = rand.nextInt(100000);
			boolean result = true;
			result = result && obj.canWinNimDP(r)==obj.canWinNimMath(r);
			result = result && obj.canWinNimDP_MuchMemory(r)==obj.canWinNimMath(r);
			System.out.println(result + ":" + r);
		}
	}

	/* Sol1: Math, time: O(1) [BEST] */
	public boolean canWinNimMath(int n) {
		return n % 4 != 0;
	}

	/* Sol2: DP Buttom-up, time: O(n), memory: O(1) */
	public boolean canWinNimDP(int n) {
		if (n <= 3)
			return true;
		boolean[] dp = new boolean[4];
		dp[0] = true;
		dp[1] = true;
		dp[2] = true;

		for (int i = 3; i < n; i++) {
			dp[3] = !(dp[2] && dp[1] && dp[0]);
			dp[0] = dp[1];
			dp[1] = dp[2];
			dp[2] = dp[3];
		}
		return dp[3];
	}

	/* Sol3: DP Buttom-up, time: O(n), memory: O(n) */
	public boolean canWinNimDP_MuchMemory(int n) {
		if (n <= 3)
			return true;
		boolean[] dp = new boolean[n];
		dp[0] = true;
		dp[1] = true;
		dp[2] = true;

		for (int i = 3; i < n; i++) {
			dp[i] = !(dp[i - 1] && dp[i - 2] && dp[i - 3]);
		}
		return dp[n - 1];
	}
}