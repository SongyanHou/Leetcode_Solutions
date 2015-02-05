/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.*/

public class Solution{
	public List<String> anagrams(String[] strs){
		//same characters, silent--listen
		List<String> res=new ArrayList<String> ();
		if(strs.length==0||strs==null)
			return res;
		HashMap<String, List<String>> map=new HashMap<String, List<String>>();
		for(int i=0; i<strs.length; i++){
			char[] arr=strs[i].toCharArray();
			Arrays.sort(arr);
			String temp=new String(arr);

			if(map.containsKey(temp)){
				map.get(temp).add(strs[i]);
			}else{
				List<String> item=new ArrayList<String>();
				item.add(strs[i]);
				map.put(temp, item);
			}
		}

		Iterator iter= map.values.iterator();
		while(iter.hasNext()){
			ArrayList<String> temp=(ArrayList<String>) iter.next();
			if(temp.size()>1)
				res.addAll(temp);
		}
		return res;
	}
}