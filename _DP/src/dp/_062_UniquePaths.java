package dp;

import java.util.concurrent.TimeUnit;

public class _062_UniquePaths {

	public static void main(String[] args) {
		
		System.out.println(uniquePaths1(5,14));
		
		/* Test the time difference between top-down and buttom-up approaches (both of them overflow) */
		long startTime1 = System.nanoTime();
		System.out.println(uniquePaths1(7000,144));  //overflow 
		long endTime1 = System.nanoTime();
		
		long startTime2 = System.nanoTime();
		System.out.println(uniquePaths2(7000,144));  //overflow 
		long endTime2 = System.nanoTime();
		
		long elapsedTime1 = TimeUnit.NANOSECONDS.toMillis(endTime1 - startTime1);
		long elapsedTime2 = TimeUnit.NANOSECONDS.toMillis(endTime2 - startTime2);
		
		System.out.println("Method1(ms):" + elapsedTime1);
		System.out.println("Method2(ms):" + elapsedTime2);
	}
	
	/* Top-down (Memoization) */
    public static long uniquePaths1(int m, int n) {
    	long[][] mat = new long[m][n];
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                mat[i][j]=-1;
            }
        }
        return p(mat, m-1, n-1);
    }
    private static long p(long[][] mat, int i, int j){
        if(i==0 || j==0) return 1;
        if(mat[i][j]==-1){
            mat[i][j] = p(mat, i-1, j) + p(mat, i, j-1);
        }
        return mat[i][j];
    }
    
    /* Buttom-Up (Tabulation) */
    public static long uniquePaths2(int m, int n)
    {
    	long[][] r = new long[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0 ; j < n ; j++){
                if (i==0 || j==0)
                    r[i][j] = 1;
                else
                    r[i][j] = r[i-1][j] + r[i][j-1];
            }
        }
        return r[m-1][n-1];
    }
}