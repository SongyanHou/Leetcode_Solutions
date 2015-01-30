/*Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].*/
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num){
    	ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    	if(num==null||num.length==0)
    		return res;
    	helper(num, new boolean[num.length], new ArrayList<Integer>(), res);
    	return res;
    }

    private void helper(int[] num, boolean[] used, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res){
    	if(item.size()==num.length){
    		res.add(new ArrayList<Integer>(item));
    		return;
    	}

    	for(int i=0; i<num.length; i++){
    		if(!used[i]){
    			item.add(num[i]);
    			used[i]=true;
    			helper(num,used,item,res);
    			item.remove(item.size()-1);
    			used[i]=false;
    		}
    	}
    }
}