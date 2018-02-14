package matrix;

/*
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * For example, Given board =
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]
	word = "ABCCED", -> returns true,
	word = "SEE", -> returns true,
	word = "ABCB", -> returns false.
 */
public class _079_WordSearch {

	public static void main(String[] args) {
		_079_WordSearch obj = new _079_WordSearch();
		char[][] board = new char[][]{
							  			{'A','B','C','E'},
							  			{'S','F','C','S'},
							  			{'A','D','E','E'}
									 };
		String s1 = "ABCCED";
		String s2 = "SEE";
		String s3 = "ABCB";
		System.out.println(obj.exist(board,s1));
		System.out.println(obj.exist(board,s2));
		System.out.println(obj.exist(board,s3));
	}

    public boolean exist(char[][] board, String word) {
        if(word.length()==0) return true;
        int row=board.length;
        int col=board[0].length;
        boolean[][] used = new boolean[row][col];
        //System.out.println(used[0][0]);
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(word.charAt(0)==board[i][j]){
                    //System.out.println(">>" + i + "-" + j);
                    
                    /* reset used matrix */
                    for(int k=0; k<row; k++){
                        for(int l=0; l<col ; l++){
                            used[k][l] = false;
                        }
                    }
                    if(dfs(board, word, used, i, j, 0)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, boolean used[][], int m, int n, int index){
        int row=board.length;
        int col=board[0].length;
        //System.out.println("index:" + index);
        
        if(m>=row || m<0 || n>=col || n<0){
            //System.out.println("[false-over]: " + m  + " " + n);
            return false;
        }
        if(used[m][n]==true){
            //System.out.println("[false-used]: " + m  + " " + n);
            //used[m][n] = false;
            return false;
        }
        
        if(word.charAt(index)!=board[m][n]){
            //System.out.println("[false-diff]: " + m + "-" + n +  " " + word.charAt(index));
            //used[m][n] = false;
            return false;
        }
        //System.out.println("[ok] " + m + "-" + n);
        used[m][n] = true;
        
        if(index==word.length()-1){
            //System.out.println("[done] " + m + "-" + n);
            return true;
        }else{
            if(dfs(board, word, used, m+1, n, index+1)) return true; //down
            if(dfs(board, word, used, m-1, n, index+1)) return true; //up
            if(dfs(board, word, used, m, n+1, index+1)) return true; //right
            if(dfs(board, word, used, m, n-1, index+1)) return true; //left
        }
        used[m][n] = false;
        return false;
    }
}