/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].*/

public class Solution{
	public List<String> wordBreak(String s, Set<String> dict){
		List<String> res=new ArrayList<String>();
		boolean flag=isPossible(s,dict);
		if(s==null||s.length()==0||!flag)
			return res;
		helper(s,dict,0,"",res);
		return res;
	}

	public boolean isPossible(String s, Set<String> dict){
		if(s==null||s.length()==0)
			return false;
		int[] res=new int[s.length()+1];
		res[0]=true;
		for(int i=0; i<s.length(); i++){
			StringBuilder sb=new StringBuilder(s.substring(0,i+1));
			for(j=0; j<=i; j++){
				if(res[j]&&dict.contains(sb.toString())){
					res[i+1]=true;
					break;
				}
				sb.deleteCharAt(0);
			}
		}
		return res[s.length()];
	}

	private void helper(String s, Set<String> dict, int start, String item, List<String> res){
		if(start>=s.length())
		{
			res.add(item);
			return;
		}
		StringBuilder sb=new StringBuilder();
		for(int i=start; i<s.length(); i++){
			sb.append(s.charAt(i));
			if(dict.contains(sb.toString())){
				String newItem;
				if(item.length()>0){
					newItem=item+" "+sb.toString();
				}else{
					newItem=sb.toString();
				}
				helper(s,dict,i+1,newItem,res);
			}
		}
	}
}