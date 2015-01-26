/*Write an efficient algorithm that searches for a value in an m x n matrix. 
This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.*/

public class Solution{
	public boolean searchMatrix(int[][] matrix, int target){
		if(matrix==null||matrix.length==0||matrix[0].length==0)
			return false;
		int rowNum=matrix.length;
		int colNum=matrix[0].length;
		//two times binary search
		//find the target row first, then search the target row
		int lRow=0;
		int rRow=matrix.length-1;
		while(lRow<=rRow){
			int mRow=(lRow+rRow)/2;
			if(target<matrix[mRow][0])
				rRow=mRow-1;
			else if(target>matrix[mRow][colNum-1])
				lRow=mRow+1
			else
				return binarySearch(matrix[mRow],target);
		}
	}

	private boolean binarySearch(int[] array, int target){
		int l=0;
		int r=array.length-1;
		while(l<=r){
			int m=(l+r)/2;
			if(array[m]==target)
				return true;
			else if(array[m]>target)
				r=m-1;
			else
				l=m+1;
		}
		return false;
	}
}