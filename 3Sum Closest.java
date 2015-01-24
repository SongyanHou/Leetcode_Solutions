/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/

public class Solution{
	public int threeSumClosest(int[] num, int target) {
		//divide it into two sums problem
		if(num==null||num.length<=2){
			return 0;
		}
		Arrays.sort(num);
		int closest=num[0]+num[1]+num[2]-target;
		for(int i=0; i<num.length-2; i++){
			int cur=twoSum(num,i+1,target-num[i]);
			if(Math.abs(cur)<Math.abs(closest)){
				closest=cur;
			}
		}
		return target+closest;
	}

	private int twoSum(int[] num, int start, int target){
		int closest=num[start]+num[start+1]-target;
		int l=start;
		int r=num.length-1;
		//For sorted array, set two pointers moving towards the middle
		//Find the smallest difference for two numbers' sum
		while(l<r){
			if(num[l]+num[r]==target)
				return 0;
			int diff=num[l]+num[r]-target;
			if(Math.abs(diff)<Math.abs(closest)){
				closest=diff;
			}
			if(num[l]+num[r]>target)
				r--;
			else
				l++;
		}
		return closest;
	}
}