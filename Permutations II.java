/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	if(num==null||num.length==0)
    		return res;
    	List<Integer> item=new ArrayList<Integer>();
    	Arrays.sort(num);
    	helper(num, new boolean[num.length], item, res);
    	return res;
    }
    private void helper(int[] num, boolean[] used, List<Integer> item, List<List<Integer>> res){
    	if(item.size()==num.length)
    	{
    		List<Integer> newItem=new ArrayList<Integer>(item);
    		res.add(newItem);
    		return;
    	}
    	for(int i=0; i<num.length; i++){
    		if(i>0 && !used[i-1] && num[i-1]==num[i]){
    			continue;
    		}
    		if(!used[i]){
    			item.add(num[i]);
    			used[i]=true;
    			helper(num, used, item, res);
    			used[i]=false;
    			item.remove(item.size()-1);
    		}
    	}
    }
}