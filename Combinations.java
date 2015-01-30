/*
Given two integers n and k, 
return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]*/
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    	if(n<k||n<=0||k<0)
    		return res;
    	helper(n,k,1,new ArrayList<Integer>(), res);
    	return res;
    }

    private void helper(int n, int k, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res){
    	if(item.size()==k){
    		res.add(new ArrayList<Integer>(item));
    		return;
    	}
    	for(int i=start; i<=n; i++){
    		item.add(i);
    		helper(n, k, i+1, item, res);
    		item.remove(item.size()-1);
    	}
    }
}
