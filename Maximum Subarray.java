/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.*/

public class Solution{
	public int maxSubArray(int[] A){
		//Dynamic Programming
		//set two variables: local and global
		//local represents the local max containing A[i] when i moves along the array
		//global represents the max of all subarrays
		if(A==null||A.length==0)
			return 0;
		int local=A[0];
		int global=A[0];

		for(int i=1; i<A.length; i++){
			local=Math.max(A[i], local+A[i]);
			global=Matn.max(global, local);
		}
		return global;
	}
}