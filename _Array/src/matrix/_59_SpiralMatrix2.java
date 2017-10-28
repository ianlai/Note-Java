package matrix;

public class _59_SpiralMatrix2 {

	enum Mode {
		R, D, L, U
	}

	public static void main(String[] args) {
		_59_SpiralMatrix2 obj = new _59_SpiralMatrix2();
		int[][] ans = obj.generateMatrix(8);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(String.format("%4s", ans[i][j]) + " ");
			}
			System.out.println();
		}
	}

	public int[][] generateMatrix(int n) {
		int square = n * n;
		int[][] ans = new int[n][n];
		Mode mode = Mode.R;

		int leftBound = -1;
		int rightBound = n;
		int topBound = -1;
		int buttomBound = n;
		int i = 0;
		int j = 0;
		boolean over = false;
		for (int x = 1; x <= square; x++) {
			//System.out.println(x + ": " + j + "-" + i + "  " + mode);
			
			/* hit the bound, revise */ 
			if (mode == Mode.R || mode == Mode.L) {
				if (i == rightBound) {
					mode = Mode.D;
					i--;
					j++;
					topBound++;
				} else if (i == leftBound) {
					mode = Mode.U;
					i++;
					j--;
					buttomBound--;
				}
			}
			if (mode == Mode.D || mode == Mode.U) {
				if (j == topBound) {
					mode = Mode.R;
					i++;
					j++;
					leftBound++;	
				} else if (j == buttomBound) {
					mode = Mode.L;
					i--;
					j--;
					rightBound--;
				}
			}

			/* assign */ 
			ans[j][i] = x;
			
			/* normal process for set the index */ 
			switch (mode) {
			case R:
				i++;
				break;
			case D:
				j++;
				break;
			case L:
				i--;
				break;
			case U:
				j--;
				break;
			}

		}
		return ans;
	}

}
