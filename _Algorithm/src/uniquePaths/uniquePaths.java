package uniquePaths;

import java.util.concurrent.TimeUnit;

public class uniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePaths(5,14));
		
		long startTime1 = System.nanoTime();
		System.out.println(uniquePaths(32,14));
		long endTime1 = System.nanoTime();
		
		long startTime2 = System.nanoTime();
		System.out.println(uniquePaths2(32,14));
		long endTime2 = System.nanoTime();
		
		long elapsedTime1 = TimeUnit.NANOSECONDS.toMillis(endTime1 - startTime1);
		long elapsedTime2 = TimeUnit.NANOSECONDS.toMillis(endTime2 - startTime2);
		
		System.out.println("Method1(ms):" + elapsedTime1);
		System.out.println("Method2(ms):" + elapsedTime2);
	}
    public static int uniquePaths(int m, int n) {
        int[][] mat = new int[m+1][n+1];
        for(int i=0; i<m+1; ++i){
            for(int j=0; j<n+1; ++j){
                mat[i][j]=-1;
            }
        }
        return p(mat, m, n);
    }
    private static int p(int[][] mat, int m, int n){
        //System.out.println(m + " -- " + n);
        if(m==1 || n==1) return 1;
        if(mat[m][n]==-1){
            mat[m][n] = p(mat, m-1, n) + p(mat, m, n-1);
        }
        //System.out.println(m + " " + n + " " + mat[m][n]);
        return mat[m][n];
    }
    
    public static int uniquePaths2(int m, int n)
    {
        int[][] r = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0 ; j < n ; j++)
            {
                if (i==0 || j==0)
                    r[i][j] = 1;
                else
                    r[i][j] = r[i-1][j] + r[i][j-1];
            }
        }
        return r[m-1][n-1];
    }
}