/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

/*if use binary search just one time, 
we might have to go through the array to find the bound
Instead, we could use binary search twice 
to find the left bound and the right bound respectively*/

public class Solution{
	public int[] searchRange(int[] A, int target){
		//for left bound, set the condition of moving left looser than moving right
		//and vice versa
		int[] res={-1,-1};
		if(A==null||A.length==0)
			return res;
		int ll=0;
		int lr=A.length-1;
		while(ll<=lr){
			int m=(ll+lr)/2;
			if(A[m]<target)
				ll=m+1;
			else
				lr=m-1;
		}
		int rl=0;
		int rr=A.length-1;
		while(rl<=rr){
			int m=(rl+rr)/2;
			if(A[m]>target)
				rr=m-1;
			else
				rl=m+1;
		}
		if(ll<=rr){
			res[0]=ll;
			res[1]=rr;
		}
		return res;
	}
}
