/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)*/

public class Solution{
	public List<List<Integer>> threeSum(int[] num){
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if(num==null||num.length<=2)
			return res;
		Arrays.sort(num);
		//since the result triplets should be in non-descending order
		//it's convenient to start from the right of the array
		//after calculating the two sum, add the element in the end

		for(int i=num.length-1; i>=2; i--){
			if(i<num.length-1 && num[i]==num[i+1])
				continue;
			List<List<Integer>> cur=twoSum(num,i-1,-num[i]);
			for(int j=0; j<cur.size(); j++)
				cur.get(j).add(num[i]);
			res.addAll(cur);
		}
		return res;
	}

	private List<List<Integer>> twoSum(int[] num, int end, int target){
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if(num==null||num.length<=1)
			return res;
		int l=0;
		int r=end;

		while(l<r){
			if(num[l]+num[r]==target){
				List<Integer> temp=new ArrayList<Integer>();
				temp.add(num[l]);
				temp.add(num[r]);
				res.add(temp);
				l++;
				r--;
				while(l<r && num[l]==num[l-1])
					l++;
				while(l<r && num[r]==num[r+1])
					r--;
			}
			else if(num[l]+num[r]<target)
				l++;
			else
				r--;
		}
		return res;
	}
}