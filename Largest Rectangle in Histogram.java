/*
Given n non-negative integers representing the histogram's bar height 
where the width of each bar is 1, 
find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, 
given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, 
which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.*/

public class Solution{
	public int largestRectangleArea(int[] height){
		if(height==null||height.length==0)
			return 0;
		int max=0;
		LinkedList<Integer> stack=new LinkedList<Integer>();
		//the stack store the index of heights that are in ascending order
		//when meet a new height that is smaller than the top
		//pop this height up and calculate the area
		for(int i=0; i<height.length; i++){
			while(!stack.isEmpty() && height[i]<=height[stack.peek()]){
				int index=stack.pop();
				int curArea=stack.isEmpty()?height[index]*i:height[index]*(i-stack.peek()-1);
				max=Math.max(max,curArea);
			}
			stack.push(i);
		}

		while(!stack.isEmpty()){
			int index=stack.pop();
			int curArea=stack.isEmpty()?height[index]*(height.length):height[index]*(height.length-stack.peek()-1);
			max=Math.max(max, curArea);
		}

		return max;
	}
}