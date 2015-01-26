/*Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].*/

public class Solution{
	public int removeDuplicates(int[] A){
		if(A==null||A.length==0)
			return 0;
		int pre=1;
		int cur=1;
		int dup=0; //record the number of duplicates
		while(cur<A.length){
			if(A[cur]==A[cur-1])
			{
				dup++;
				if(dup>=2){
					cur++;
					continue;
				}
			}
			else{
				dup=0;
			}
			A[pre]=A[cur];
			pre++;
			cur++;
		}
		return pre;
	}
}