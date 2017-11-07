package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Find min sum of the path in the triangle 
 * It can only go left one step or right one step. */

/* ex. 
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

 Min = 2+3+5+1 = 11 
 
*/

public class _120_Triangle {

	public static void main(String[] args) {
		_120_Triangle obj = new _120_Triangle();
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		ll.add(new ArrayList<>(Arrays.asList(2)));
		ll.add(new ArrayList<>(Arrays.asList(3, 4)));
		ll.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
		ll.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));
		
		System.out.println("min:" + obj.minimumTotal1(ll));
		System.out.println("min:" + obj.minimumTotal2(ll));
		System.out.println("min:" + obj.minimumTotal3(ll));
	}
	
	/* Buttom-Up DP, with O(n) array (beats 96%)*/
	public int minimumTotal1(List<List<Integer>> t) {
		int totalLayer = t.size();
		int[] dp = new int[totalLayer];
		List<Integer> last = t.get(totalLayer-1);
		for(int i=0; i<totalLayer ; i++){
			dp[i] = last.get(i);
		}

		for(int i=totalLayer-2; i>=0; i--){
			for(int j=0; j<=i; j++){
				int min = Math.min(dp[j], dp[j+1]);
				dp[j] = min + t.get(i).get(j);      
			}
		}
		return dp[0];
	}
	
	/* Buttom-Up DP, with O(n) list (beats 29%)*/
	public int minimumTotal2(List<List<Integer>> t) {
		int totalLayer = t.size();
		List<Integer> dp = new ArrayList<Integer>();
		dp.addAll(t.get(totalLayer-1));    //initialize

		for(int i=totalLayer-2; i>=0; i--){
			for(int j=0; j<=i; j++){
				int min = Math.min(dp.get(j), dp.get(j+1));
				
				//dp.add(min + t.get(i).get(j));
				dp.set(j, min + t.get(i).get(j));  //use SET
			}
		}
		return dp.get(0);
	}
	
	/* Buttom-Up DP, with O(n2) list (beats 14%) */
	public int minimumTotal3(List<List<Integer>> t) {
		List<List<Integer>> dp = new ArrayList<List<Integer>>();
		int totalLayer = t.size();
		for(int i=0; i<totalLayer; i++){
			dp.add(new ArrayList<Integer>());  //totally "size" lists
			if(i==totalLayer-1){
				dp.get(i).addAll(t.get(i));    //last layer (initialize)
			}
		}
		for(int i=totalLayer-2; i>=0; i--){
			for(int j=0; j<=i; j++){
				List<Integer> lower = dp.get(i+1); 
				List<Integer> cur  = dp.get(i); 
				
				int min = Math.min(lower.get(j), lower.get(j+1));
				//System.out.println(i+"-"+j + ":" + t.get(i).get(j));
				cur.add(min + t.get(i).get(j));
				//cur.set(j, min + t.get(i).get(j));  //not adding yet, so we should use ADD instead of SET
			}
		}
		return dp.get(0).get(0);
	}
	
	/* DFS: it takes too long the time */
//	public int minimumTotal(List<List<Integer>> t) {
//		int[] record = new int[2];  //current sum, final min
//		record[1] = Integer.MAX_VALUE;
//		helper(t, 0, 0, record);
//		return record[1];
//	}
//	private void helper(List<List<Integer>> t, int lindex, int eindex, int[] record){
//		//System.out.println(lindex + " - " + eindex);
//		if(lindex<t.size()){
//			List<Integer> list = t.get(lindex);
//			if(eindex<list.size()){
//				record[0] += list.get(eindex);
//				//System.out.println("sum:" + record[0] + " min:" + record[1]);
//				if(lindex==t.size()-1){
//					record[1] = Math.min(record[0], record[1]);
//				}else{
//					helper(t, lindex+1, eindex, record);
//					helper(t, lindex+1, eindex+1, record);
//				}
//				record[0] -= list.get(eindex);  //remove the last (important) 
//			}
//		}
//	}
}
