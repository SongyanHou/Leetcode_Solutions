/*Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
	//NP problem: for each position, there are two possible situations
	//Time Complexity: 2^n

	//non-recursive solution:
    public List<List<Integer>> subsets_NR(int[] S) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	List<Integer> empty=new ArrayList<Integer>();
    	res.add(empty);
    	if(S==null||S.length==0)
    		return res;
    	Arrays.sort(S);

    	for(int i=0; i<S.length; i++){
    		int size=res.size();
    		for(j=0; j<size; j++){
    			List temp=new ArrayList<Integer>(res.get(j));
    			temp.add(S[i]);
    			res.add(temp);
    		}
    	}
    	return res;
    }

    //Recursive solution:
    public List<List<Integer>> subsets_R(int[] S) {
    	if(S==null)
    		return null;
    	Arrays.sort(S);
    	return helper(S, S.length-1);
    }

    private List<List<Integer>> helper(int[] S, int index){
    	if(index==-1){
    		List<List<Integer>> res=new ArrayList<List<Integer>>();
    		List<Integer> elem=new ArrayList<Integer>();
    		res.add(elem);
    		return res;
    	}
    	List<List<Integer>> res=helper(S, index-1);
    	int size=res.size-1;
    	for(int i=0; i<size; i++){
    		List<Integer> elem=new ArrayList<Integer>(res.get(i));
    		elem.add(S[index]);
    		res.add(elem);
    	}
    	return res;
    }
}

