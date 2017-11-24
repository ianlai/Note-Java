package island;

public class _463_IslandPerimeter {

	public static void main(String[] args) {
		_463_IslandPerimeter obj = new _463_IslandPerimeter();
		int[][] map = new int[][]{{0,0,1,0},
								  {1,0,1,1},
								  {1,1,1,0},
								  {1,0,1,1}};
		int res = obj.islandPerimeter(map);
		System.out.println("Perimeter: " + res);

	}
    public int islandPerimeter(int[][] grid) {
        
        int m = grid.length;
        if(m==0) return 0;
        int n = grid[0].length;
        if(n==0) return 0;
        
        int cell = 0;
        int peri = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    cell++;
                    int right = 0; 
                    int down  = 0;
                    if(j+1<n && grid[i][j+1]==1)
                        right = 1;
                    if(i+1<m && grid[i+1][j]==1)
                        down = 1;
                    peri += (4 - right*2 - down*2);
                }
            }
        }
        return peri;
    }
}
