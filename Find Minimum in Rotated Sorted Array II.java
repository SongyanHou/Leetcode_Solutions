/*
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.*/

public class Solution{
	public int findMin(int[] num){
		if(num==null||num.length==0)
			return 0;
		int l=0;
		int r=num.length-1;
		int min=num[0];

		while(l<r-1)//in case getting stuck into infinite loop
		{
			int m=(l+r)/2;
			if(num[l]<num[m]){
				min=Math.min(min, num[l]);
				l=m;
			}else if(num[l]>num[m]){
				min=Math.min(min, num[m]);
				r=m;
			}else{
				l++;
			}
		}
		min=Math.min(Math.min(min, num[l]), num[r]);
		return min;
	}
}