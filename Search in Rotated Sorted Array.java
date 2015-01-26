/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.*/

public class Solution{
	public int search(int[] A, int target){
		//since it's rotated sorted
		//we could use binary search
		if(A==null||A.length==0)
			return -1;
		int left=0;
		int right=A.length-1;

		while(left<=right){
			int mid=(left+right)/2;
			if(A[mid]==target)
				return mid;
			if(A[left]<=A[mid]){
				if(target<=A[mid] && target>=A[left])
					right=mid-1;
				else
					left=mid+1;
			}
			else{
				if(target>=A[mid] && target<=A[right])
					left=mid+1;
				else
					right=mid-1;
			}
		}
		return -1;
	}
}