/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?*/

public class Solution{
	public int uniquePaths(int m, int n){
		//Dynamic Programming
		//for each grid, the result is the sum of result of upper grid and left grid
		if(m==0||n==0) 
			return 0;
		int [][] res=new int[m][n];
		//set the bound value
		for(int i=0; i<m; i++){
			res[i][0]=1;
		}
		for(int j=0; j<n; j++){
			res[0][j]=1;
		}
		for(int p=1; p<m; p++){
			for(int q=1; q<n; q++){
				res[p][q]=res[p-1][q]+res[q-1][p];
			}
		}
		return res[m-1][n-1];
	}
}