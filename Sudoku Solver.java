/*Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.*/

public class Solution{
	public void solveSudoku(char[][] board){
		if(board==null||board.length!=9||board[0].length!=9)
			return;
		helper(board,0,0);
	}

	public boolean helper(char[][] board, int i, int j){
		if(j>=9)
			return helper(board, i+1, 0);
		if(i==9)
			return true;
		if(board[i][j]=='.'){
			for(int k=1; k<=9; k++){
				char temp=(char)(k+'0');
				board[i][j]=temp;
				if(isValid(board,i,j)){
					if(isValid(board,i,j+1))
						return true;
				}
				board[i][j]='.';
			}
		}else{
			return helper(board, i, j+1);
		}
		return false;
	}

	private boolean isValid(char[][] board, int i, int j){
		for(int k=0; k<9; k++){
			if(board[k][j]==board[i][j] && k!=i)
				return false;
		}
		for(int k=0; k<9; k++){
			if(board[i][k]==board[i][j] && k!=j)
				return false;
		}

		for(int m=i/3*3; m<i/3*3+3; m++){
			for(int n=j/3*3; n<j/3*3+3; n++){
				if(m==i && n==j)
					continue;
				if(board[m][n]==board[i][j])
					return false;
			}
		}
		return true;
	}
}