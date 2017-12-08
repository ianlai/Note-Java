package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _073_SetMatrixZeroes {

	public static void main(String[] args) {
		_073_SetMatrixZeroes obj = new _073_SetMatrixZeroes();
		int[][] m1 = new int[][]{{1,1,1,2},{1,0,1,1},{1,1,1,9}};
		
		/* original */
		for(int[] row: m1){
			System.out.println(Arrays.toString(row));
		}
		
		System.out.println("------------------");
		
		/* after set zeroes */
		obj.setZeroes(m1);
		for(int[] row: m1){
			System.out.println(Arrays.toString(row));
		}
	}
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        List<List<Integer>> pairs = new ArrayList<List<Integer>>();
            
        for(int i=0; i<m; i++){
            for(int j=0;j<n; j++){
                if(matrix[i][j]==0){
                    List<Integer> t = new ArrayList<>();
                    t.add(i);
                    t.add(j);
                    pairs.add(t); 
                }
            }
        }
        for(List<Integer> p: pairs){
            int row = p.get(0);
            int col = p.get(1);
            for(int i=0; i<m; i++){
                matrix[i][col] = 0;
            }
            for(int j=0; j<n; j++){
                matrix[row][j] = 0;
            }
        }
    }
}