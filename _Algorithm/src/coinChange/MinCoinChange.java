package coinChange;

import java.util.Arrays;

public class MinCoinChange {
	public void run(){
		int[] coins = new int[]{1,2,5};
		int target = 6;
		int result = coinChange(coins, target);
		System.out.println(result);
	}
    public int coinChange(int[] coins, int amount) {        
        int[] table = new int[amount];
        Arrays.fill(table, Integer.MAX_VALUE);
        return coinChange(coins, amount, table);
    }
    public int coinChange(int[] coins, int amount, int[] table){
        if(amount==0){
            return 0;
        }else if(amount <0){
            return -1;
        }else{
            int min = Integer.MAX_VALUE;
            for(int e: coins){
                int r;
                if(amount-e < 0) continue;
                if(table[amount-e] == Integer.MAX_VALUE){
                    table[amount-e] = coinChange(coins, amount-e, table);
                }
                r = table[amount-e];
                if(r!=-1){
                    //list.add(r+1);           //add to list and find the min later (slower)
                    min = Math.min(r+1, min);  //only keep the unique min (faster)
                }
            }
            return min==Integer.MAX_VALUE ? -1 : min;
        }
    }
    
//    ------ Greedy algorithm, wrong result ------
//    public int coinChange(int[] coins, int amount) {
//        Arrays.sort(coins);
//        return coinChange(coins, amount, 0);
//    }    
//     public int coinChange(int[] coins, int amount, int layer){
//         System.out.println("coinChange(coins," + amount + "," + layer);
//         if(amount==0) return layer;
//         else if(amount <0) return -1;
//         else{
//             for(int i=coins.length-1; i>=0; i--){
//                 int r = coinChange(coins, amount-coins[i], layer+1);
//                 if(r>=0) return r;
//             }
//             return -1;
//         }
//     }
}