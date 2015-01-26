/*Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped. 
Thanks Marcos for contributing this image!*/

public class Solution{
	public int trap(int[] A){
		//First: scan from left to right, find the max in the left of each element
		//Second: scan from right to left, find the max in the right of each element
		//Take the min of these two max value, which is the bottleneck of volume
		//Then keep accumulating the positive volume
		if(A==null||A.length==0)
			return 0;
		int max=0;
		int[] container=new int[A.length];
		int res=0;
		for(int i=0; i<container.length; i++){
			container[i]=max;
			max=Math.max(max, A[i]);
		}
		max=0;
		for(int i=container.length-1; i>=0; i--){
			container[i]=Math.min(max,container[i]);
			max=Math.max(max, A[i]);
			res+=container[i]-A[i]>0?container[i]-A[i]:0;
		}
		return res;
	}
}