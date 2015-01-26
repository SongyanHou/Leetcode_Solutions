/*Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right 
which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.*/

public class Solution{
	public int minPathSum(int[][] grid){
		//DP problem
		//set a one dimensional array to store intermediate result
		if(grid==null||grid.length==0||grid[0].length==0)
			return 0;
		int[] res=new int[grid[0].length];
		res[0]=grid[0][0];
		for(int i=1;i<grid[0].length;i++)
			res[i]=res[i-1]+grid[0][i];
		for(int i=1; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				if(j==0)
					res[j]=res[j]+grid[i][j];
				else
					res[j]=Math.min(res[j-1],res[j])+grid[i][j];
			}
		}
		return res[grid[0].length-1];
	}
}