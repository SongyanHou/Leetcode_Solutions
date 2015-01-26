/*Given a 2D board and a word, 
find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.*/


public class Solution {
    boolean visited[][];
    //global variable to record whether a cell has been visited
    public boolean exist(char[][] board, String word) {
        if(word==null)
        	return true;
        int m=board.length;
        int n=board[0].length;
        for(int i=0; i<m; i++){
        	for(int j=0; j<n; j++){
        		if(search(board,word,0,i,j))
        			return true;
        	}
        }
        return false;
    }
    
    public boolean search(char[][] board, String word, int n, int i, int j){
        if(n==word.length())
        	return true;
        if(i<0||i>=board.length||j<0||j>=board[0].length)
        	return false;
        if(visited[i][j])
        	return false;
        if(word.charAt(n)!=board[i][j])
        	return false;
        visited[i][j]=true;
        boolean res=search(board, word, n+1, i-1, j)||
        			search(board, word, n+1, i+1, j)||
        			search(board, word, n+1, i, j-1)||
        			search(board, word, n+1, i, j+1);
        visited[i][j]=false;
        return res;
    }
}