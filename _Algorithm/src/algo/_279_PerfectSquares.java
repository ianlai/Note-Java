package algo;

import java.util.Arrays;

public class _279_PerfectSquares {

	public static void main(String[] args) {
		System.out.println(numSquares(1000));
	}

    /* Bottom-Up */
    public static int numSquares(int n) {
        if(n<=0) return 0;
     
        int maxPSN = (int)Math.pow(Integer.MAX_VALUE,0.5);
        int[] PSN = new int[maxPSN];  //1, 4, 9, ..., maxElement^2
        int[] ans = new int[n+1];
         
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        
        for(int i=1; i<=maxPSN; ++i){
            PSN[i-1]=i*i;
        }
        
        for(int i=1; i<=n; ++i){
            for(int e: PSN){
            	//System.out.println(i + " : " + e  + " : " + ans[i]);
                if(e>i) break;
                ans[i] = Math.min(ans[i], ans[i-e]+1);
                int temp = ans[i-e]+1 ;
            }
            System.out.println(i + " : " + ans[i]);
        }
 
        return ans[n];
    }
}