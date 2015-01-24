/*A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.
*/

public class Solution{
	public int findPeakElement(int[] num){
		//O(lgN) time complexity: binary search
		int l=0;
		int r=num.length-1;
		while(l<=r){
			if(l==r) return l;
			int m=(l+r)/2;
			if(num[m]>num[m+1]){
				r=m;
			}else{
				l=m+1;
			}
		}
		return -1;
	}
}