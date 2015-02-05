/*
Question:
Given a sorted integer array where the range of elements are [0, 99] inclusive, return its
missing ranges.
For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]*/

public class Solution{
	public List<String> findMissingRanges(int[] vals, int start, int end){
		List<String> ranges=new ArrayList<String>();
		//add two artifical points: start-1 in the start and end+1 in the end
		int pre=start-1;
		for(int i=0; i<=vals.length; i++){
			int cur=(i==vals.length?end+1:vals[i]);
			if(cur-pre>=2)
				ranges.add(getRanges(pre+1,cur-1));
			pre=cur;
		}
		return ranges;
	}

	private String getRanges(int from, int to){
		//String res=new String();
		return (from==to)?String.valueOf(from):from+"->"+to;
	}
}