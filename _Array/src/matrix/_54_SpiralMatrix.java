package matrix;

import java.util.ArrayList;
import java.util.List;

public class _54_SpiralMatrix {

	public static void main(String[] args) {
		_54_SpiralMatrix obj = new _54_SpiralMatrix();
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List<Integer> ans = obj.spiralOrder(matrix);
		System.out.println(ans);
	}

    public enum Mode {
		R, D, L, U
	};
    public List<Integer> spiralOrder(int[][] matrix) {
    
        List<Integer> list = new ArrayList<Integer>();
        if(matrix==null) return list;
        int m = matrix.length;
        if(m==0) return list;
        int n = matrix[0].length;
        if(n==0) return list;
        
        //System.out.print("m:" + m + " n:" + n);
        int t = m*n;
        
        if(m==1 || n==1){
            if(m==1){
                for (int i = 0; i < t; ++i) {
                    list.add(matrix[0][i]);
                }
            }
            if(n==1 & m!=1){
                for (int i = 0; i < t; ++i) {
                    list.add(matrix[i][0]);
                }
            }
            return list;
        }
        
		int countr = 0;
		int countc = 0;
		int r = 0, c = 0;
		Mode md = Mode.R;
		for (int i = 0; i < t; ++i) {
			//System.out.println(r + " " + c + " - " + countr + " " + countc + " - " + md);
			list.add(matrix[r][c]);
			switch (md) {
			case R:
				++c;
				++countc;
				break;
			case D:
				++r;
				++countr;
				break;
			case L:
				--c;
				++countc;
				break;
			case U:
				--r;
				++countr;
				break;
			}

			if (countc == n - 1 && md == Mode.R) {
				//System.out.println("--");
				md = Mode.D;
				countc = 0;
			}
			if (countr == m - 1 && md == Mode.D) {
				//System.out.println("--");
				md = Mode.L;
				countr = 0;
			}
			if (countc == n - 1 && md == Mode.L) {
				//System.out.println("--");
				md = Mode.U;
				countc = 0;
			}
			if (countr == m - 1 && md == Mode.U) {
				//System.out.println("--");
				md = Mode.R;
				countr = 0;
				m -= 2;
				n -= 2;
				++c;
				++r;
				if (countc == n - 1 && md == Mode.R) {
					//System.out.println("--");
					md = Mode.D;
					countc = 0;
				}
			}
		}
		//System.out.println(list);
        return list;
    }
}