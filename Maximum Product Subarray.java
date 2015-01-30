/*
Find the contiguous subarray within an array 
(containing at least one number) 
which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.*/

public class Solution{
	public int maxProduct(int[] A){
		//take the negative number into consideration
		//we should set local max and local min
		if(A==null||A.length==0)
			return 0;
		int local_max=A[0];
		int local_min=A[0];
		int global=A[0];

		for(int i=1; i<A.length; i++){
			int temp=local_max;
			local_max=Math.max(Math.max(local_max*A[i], local_min*A[i]), A[i]);
			local_min=Math.min(Math.min(temp*A[i], local_min*A[i]), A[i]);
			global=Math.max(local_max, global);
		}
		return global;

	}
}