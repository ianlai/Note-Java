package reservoirSampling;

import java.util.Random;

public class _398_RandomPickIndex {

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,3,3,3,3,4,4};
		Solution obj = new Solution(arr);
		for(int i=0;i<20;i++){
			System.out.println(i + ": " + obj.pick(3));
		}
	}
	
	static class Solution {
	    Random mRand;
	    int[] A;
	    public Solution(int[] nums) {
	        mRand = new Random();   
	        A = nums; 
	    }
	    
	    public int pick(int target) {
	        int round = 0; //MUST starts at 0 
	        int res = 0;
	        for(int i=0; i<A.length; i++){
	            int r = mRand.nextInt(round+1);
	            if(A[i]==target){
	                if(r==round){
	                    //System.out.println("r==round: " + r);
	                    res=i;
	                }
	                round++;
	            }
	        }
	        return res;
	    }
	}

	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(nums);
	 * int param_1 = obj.pick(target);
	 */
}
