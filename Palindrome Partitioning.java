/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]*/

public class Solution{
	public ArrayList<ArrayList<String>> partition(String s) {
		//similar method as combination
		ArrayList<ArrayList<String>> res=new ArrayList<ArrayList<String>>();
		if(s==null||s.length()==0)
			return res;
		helper(res, new ArrayList<String>(), s);
		return res;
	}

	private void helper(ArrayList<ArrayList<String>> res, ArrayList<String> list, String s){
		if(s.length()==0)
			res.add(new ArrayList<String>(list));
		for(int i=1; i<s.length(); i++){
			String temp=s.substring(0,i);
			if(isPalindrome(temp)){
				list.add(temp);
				String rest=s.substring(i);
				helper(res, list, rest);
				list.remove(list.size()-1);
			}
		}
	}

	private boolean isPalindrome(String s){
		if(s==null||s.length()==0)
			return false;
		int i=0;
		int j=s.length()-1;
		while(i<=j){
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}