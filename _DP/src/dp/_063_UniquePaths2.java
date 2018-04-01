package dp;

import java.util.Arrays;

/* 1: obstacle 
 * 0: empty space
 */
public class _063_UniquePaths2 {

	public static void main(String[] args) {
		_063_UniquePaths2 obj = new _063_UniquePaths2();
		int[][] obs1 = new int[][]{
			{0,0,1,0},
			{0,0,0,0},
			{1,0,1,0}
		};
		int[][] obs2 = new int[][]{
			{0,0,0,0,1,0},
			{0,1,0,0,0,0},
			{0,0,0,0,1,0},
			{0,0,0,0,0,0},
			{0,0,1,0,0,0}
		};
		System.out.println(obj.uniquePathsWithObstacles(obs1));
		System.out.println(obj.uniquePathsWithObstacles(obs2));
	}
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] g = obstacleGrid;
        int m = g.length;
        int n = g[0].length;
        int[][] mat = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(mat[i], -1);
        }
        if(m==0 && n==0) return 0;                       
        return p(g, mat, m-1, n-1);                      //m, n mean maximum here 
    }
    public int p(int[][] g, int[][] mat, int m, int n){  //m, n mean current index 
        
        /* first column or first row */
        if(m==0 && n==0){
            mat[m][n] = (g[m][n]==0) ? 1                 : 0;
        }else if(m==0){
            mat[m][n] = (g[m][n]==0) ? p(g, mat, m, n-1) : 0;
        }else if(n==0){
            mat[m][n] = (g[m][n]==0) ? p(g, mat, m-1, n) : 0;
        }
        
        /* normal column and normal row ; determine whether we have the result or not first*/
        if(mat[m][n]==-1){
            if(g[m][n]==1) mat[m][n] = 0;
            else{
                if(g[m-1][n]==1 && g[m][n-1]==1) mat[m][n] =  0;
                if(g[m-1][n]==0 && g[m][n-1]==1) mat[m][n] =  p(g, mat, m-1, n);
                if(g[m-1][n]==1 && g[m][n-1]==0) mat[m][n] =  p(g, mat, m, n-1);
                if(g[m-1][n]==0 && g[m][n-1]==0) mat[m][n] =  p(g, mat, m-1, n) + p(g, mat, m, n-1);
            }
        }
        return mat[m][n];
    }
}