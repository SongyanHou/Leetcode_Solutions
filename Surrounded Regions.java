/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/
public class Solution{
	public void solve(char[][] board) {
		//search from the edge
		//'O' start from edge will not be filpped
		if(board==null||board.length==0||board[0].length==0)
			return;
		for(int i=0; i<board[0].length; i++){
			fillBoard(board,0,i);
			fillBoard(board,board.length-1,i);
		}
		for(int i=0; i<board.length; i++){
			fillBoard(board, i, 0);
			fillBoard(board, i, board[0].length-1);
		}

		for(int m=0; m<board.length; m++){
			for(int n=0; n<board[0].length; n++){
				if(board[m][n]=='O')
					board[m][n]='X';
				else if(board[m][n]=='#')
					board[m][n]='O';
			}
		}
	}

	private void fillBoard(char[][] board, int i, int j){
		//BFS
		if(board[i][j]=='X')
			return;
		board[i][j]='#';
		int code=i*board[0].length+j;
		LinkedList<Integer> queue=new LinkedList<Integer>();
		queue.offer(code);
		while(!queue.isEmpty()){
			code=queue.poll();
			int row=code/board[0].length;
			int col=code%board[0].length;
			if(row>0 && board[row-1][col]=='O'){
				queue.offer((row-1)*board[0].length+col);
				board[row-1][col]='#';				
			}
			if(row<board.length-1 && board[row+1][col]=='O'){
				queue.offer((row+1)*board[0].length+col);
				board[row+1][col]='#';
			}
			if(col>0 && board[row][col-1]=='O'){
				queue.offer(row*board[0].length+col-1);
				board[row][col-1]='#';
			}
			if(col<board[0].length-1 && board[row][col+1]=='O'){
				queue.offer(row*board[0].length+col+1);
				board[row][col+1]='#';
			}
		}
	}
}