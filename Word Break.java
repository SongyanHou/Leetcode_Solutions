/*
Given a string s and a dictionary of words dict, 
determine if s can be segmented into a space-separated sequence of 
one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".*/

public class Solution{
	public boolean wordBreak(String s, Set<String> dict){
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
}