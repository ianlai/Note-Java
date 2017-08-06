package coinChange;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TotalCoinChange {
	int target = 10;
	int[] coins = new int[] { 2, 5, 3, 6 };

	TotalCoinChange(int t, int[] c){
		target = t;
		coins = c;
	}
	public void run() {
		
		System.out.println("[Total Methods]");

		long startTime1, endTime1, elapsedTime1;
		long startTime2, endTime2, elapsedTime2;

		startTime1 = System.nanoTime();
		System.out.println("Top-Down:  " + changeTop(target, coins));
		endTime1 = System.nanoTime();
		elapsedTime1 = TimeUnit.NANOSECONDS.toMillis(endTime1 - startTime1);
		System.out.println("Top-Down Cost Time: " + elapsedTime1);

		startTime2 = System.nanoTime();
		System.out.println("Bottom-Up: " + changeButtom(target, coins));
		endTime2 = System.nanoTime();
		elapsedTime2 = TimeUnit.NANOSECONDS.toMillis(endTime2 - startTime2);
		System.out.println("Bottom-Up Cost Time: " + elapsedTime2);

	}

	public int changeTop(int amount, int[] coins) {
		int[][] table = new int[amount + 1][coins.length];
		for (int[] row : table)
			Arrays.fill(row, -1);
		int lastIndex = coins.length - 1;
		return _change(amount, coins, lastIndex, table);
		// return change(amount, coins, table); //Wrong!
	}

	/* Buttom-Up */
	public int changeButtom(int amount, int[] coins) {
		int[] f = new int[amount + 1];
		f[0] = 1;
		// Arrays.sort(coins);
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				f[i] += f[i - coin];
			}
		}
		return f[amount];
	}

	/* Top-Down */
	public int _change(int target, int[] coins, int index, int[][] table) {
		// System.out.println(target + "," + index);
		if (target == 0)
			return 1;
		if (target < 0 || index < 0)
			return 0;

		if (target - coins[index] < 0) {
			return _change(target - coins[index], coins, index, table) // including
					+ _change(target, coins, index - 1, table); // not including
																// coins[index]
		}
		int temp = table[target - coins[index]][index];
		if (temp == -1) {
			table[target - coins[index]][index] = _change(target - coins[index], coins, index, table) // including
					+ _change(target, coins, index - 1, table); // not including
																// coins[index]
		}
		return table[target - coins[index]][index];
	}
	// --- Wrong! ---
	// public int change(int amount, int[] coins, int[] table) {
	// if (amount == 0)
	// return 1;
	// else if (amount < 0)
	// return 0;
	// else{
	// int sum=0;
	// for (int i = 0; i < coins.length; i++) {
	// sum += change(amount - coins[i], coins, table);
	// }
	// return sum;
	// }
	// }
}
