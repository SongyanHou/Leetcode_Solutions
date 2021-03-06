/*Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
public class Solution{
	public int searchInsert(int[] A, int target){
		//since it is sorted, we could use binary search
		if(A==null||A.length==0) return 0;
		int l=0;
		int r=A.length-1;
		while(l<=r){
			int m=(l+r)/2;
			if(target<A[l])
				return l;
			if(target>A[r])
				return r+1;
			if(A[m]==target)
				return m;
			else if(A[m]<target)
				l=m+1;
			else
				r=m-1;
		}
	}
}