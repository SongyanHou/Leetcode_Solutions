/*Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.*/

public class Solution{
	public int maxArea(int[] height){

		//Two pointers start from 1 and n
		//Walking to the middle
		//choose the pointer pointing to the shorter line to move forward/backward
		//since only by this mean could we possibly get a larger area (the shorter line decides the volume)
		if(height==null||height.length==0)
			return 0;
		int l=0;
		int r=height.length-1;
		int max=0;
		while(l<r){
			max=Math.max(max, (r-l)*Math.min(height[l],height[r]));
			if(height[l]<height[r]){
				l++;
			}else{
				r--;
			}
		}
		return max;
	}
}