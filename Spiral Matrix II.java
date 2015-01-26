/*
Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class Solution{
	public int[][] generateMatrix(int n){
		if(n<0)//when n=0, return[]
			return null;
		int level=n/2;
		int num=1;
		int [][] res=new int[n][n];
		for(int l=0; l<level; l++){
			for(int i=l; i<n-l-1; i++){
				res[l][i]=num++;
			}
			for(int i=l; i<n-l-1; i++){
				res[i][n-l-1]=num++;
			}
			for(int i=n-l-1; i>l; i--){
				res[n-l-1][i]=num++;
			}
			for(int i=n-l-1; i>l; i--){
				res[i][l]=num++;
			}
		}
		if(n%2==1){
			res[level][level]=num;
		}
		return res;
	}
}