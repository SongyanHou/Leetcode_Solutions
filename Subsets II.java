/*Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]*/
public class Solution{
	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		List<Integer> empty=new ArrayList<Integer>();
		res.add(empty);
		if(num==null||num.length==0)
			return res;
		Arrays.sort(num);
		int start=0;

		for(int i=0; i<num.length; i++){
			int size=res.size();
			for(int j=start; j<size; j++){
				List<Integer> elem=new ArrayList<Integer>(res.get(j));
				elem.add(num[i]);
				res.add(elem);
			}
			if(i<num.length-1 && num[i]==num[i+1]){
				start=size;
			}else{
				start=0;
			}
		}
		return res;
	}
}