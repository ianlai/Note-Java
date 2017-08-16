package numOfIslands;

public class numOfIslands {

	public static void main(String[] args) {
		char[][] grid = new char[][]
			   {{'1','1','0','1','1','1','0','1'},
				{'1','1','0','1','0','1','0','1'},
				{'0','1','0','0','1','0','0','0'},
				{'1','0','1','1','1','1','0','1'},
				{'1','1','0','1','0','1','0','1'},
				};
		System.out.println("Num of islands: " + numIslands(grid));

	}

	public static int numIslands(char[][] grid) {
		int m = grid.length;
		if (m == 0)
			return 0;
		int n = grid[0].length;
		if (n == 0)
			return 0;

		int count = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] == '1') {
					++count;
					dfs(grid, i, j);
				}
			}
		}
		return count;
	}

	private static void dfs(char[][] g, int i, int j) {
		int m = g.length;
		int n = g[0].length;
		if (i < 0 || j < 0 || i >= m || j >= n)
			return;
		if (g[i][j] == '1') {
			g[i][j] = '0';
			dfs(g, i + 1, j);
			dfs(g, i - 1, j);
			dfs(g, i, j + 1);
			dfs(g, i, j - 1);
		}
		return;
	}
}