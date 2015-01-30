/*Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.*/

public class Solution{
	public int totalNQueens(int n){
		//similar solution as N-Queen
		//notes: the result could not just be simply set an int
		//because Java pass by value
		//for a parameter in the function, it just pass a copy of value to it
		//We need an object to store this value
		ArrayList<Integer> res=new ArrayList<Integer>();
		res.add(0);
		if(n<=0)
			return res;
		helper(n,0,new int[],res);
		return res;
	}

	private void helper(int n, int row, int[] columnForRow, ArrayList<Integer> res){
		if(row==n){
			res.set(0, res.get(0)+1);
			return;
		}
		for(int i=0; i<n; i++){
			columnForRow[row]=i;
			if(isValid(row, columnForRow)){
				helper(n,row+1,columnForRow,res);
			}
		}
	}

	private boolean isValid(int[] columnForRow, int row){
		for(int i=0; i<row; i++){
			if(columnForRow[i]==columnForRow[row]||Math.abs(columnForRow[i]-columnForRow[row])==row-i){
				return false;
			}
		}
		return true;
	}
}