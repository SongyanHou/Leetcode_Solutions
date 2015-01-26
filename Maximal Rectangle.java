/*Given a 2D binary matrix filled with 0's and 1's, 
find the largest rectangle containing all ones and return its area.*/

public class Solution{
	public int maximalRectangle(char[][] matrix){
		//use the largest rectangle in histogram as subroutine
		//take each row of matrix as the x-axis and calcualte the max area
		//choose the max area from all these max values
		if(matrix==null||matrix.length==0||matrix[0].length==0)
			return 0;
		int max=0;
		int[] height=new int[matrix[0].length];
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				height[j]=matrix[i][j]=='0'?0:height[j]+1;
			}
			max=Math.max(max,largestRecArea(height));
		}
		return max;
	}

	public int largestRecArea(int[] height){
		int max=0;
		LinkedList<Integer> stack=new LinkedList<Integer>();
		for(int i=0; i<height.length; i++){
			while(!stack.isEmpty() && height[i]<=height[stack.peek()]){
				int index=stack.pop();
				int curArea=stack.isEmpty()?height[index]*i:height[index]*(i-stack.peek()-1);
				max=Math.max(max, curArea);
			}
			stack.push(i);
		}
		while(!stack.isEmpty()){
			int index=stack.pop();
			int curArea=stack.isEmpty()?height.length*height[index]:(height.length-stack.peek()-1)*height[index];
			max=Math.max(max,curArea);
		}
		return max;
	}
}