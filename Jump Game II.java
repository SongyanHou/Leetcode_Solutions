/*Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)*/

public class Solution{
	public int jump(int[] A){
		//greedy algorithm
		//record the position which could be reached after step-1 times jump
		//if exceed, step++
		int step=0;
		int last=0;
		int reach=0;
		if(A==null||A.length==0)
			return 0;
		for(int i=0; i<=reach&&i<A.length; i++){
			if(i>last){
				step++;
				last=reach;
			}
			reach=Math.max(reach, A[i]+i);
		}
		if(reach<A.length-1)
			return 0;
		return step;
	}
}