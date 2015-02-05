/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.*/

public class Solution{
	public boolean isValidSudoku(char[][] board){
		if(board==null||board.length!=9||board[0].length!=9)
			return false;
		//scan each row
		for(int i=0; i<board.length; i++){
			HashSet<Character> set=new HashSet<Character>();
			for(int j=0; j<board[0].length; j++){
				if(board[i][j]!='.' && set.contains(board[i][j]))
					return false;
				set.add(board[i][j]);
			}
		}

		for(int j=0; j<board[0].length; j++){
			HashSet<Character> set=new HashSet<Character>();
			for(int i=0; i<board.length; i++){
				if(board[i][j]!='.' && set.contains(board[i][j]))
					return false;
				set.add(board[i][j]);
			}
		}

		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				HashSet<Character> set=new HashSet<Character>();
				for(int m=3*i; m<3*i+3; m++){
					for(int n=3*j; n<3*j+3; n++){
						if(board[m][n]!='.' && set.contains(board[m][n]))
							return false;
						set.add(board[m][n]);
					}
				}
			}
		}
		return true;
	}
}