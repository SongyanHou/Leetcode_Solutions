/*Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.*/

public class Solution{
	public int lengthOfLongestSubstring(String s) {
		if(s==null||s.length()==0)
			return 0;
		int left=0;
		int right=0;
		int max=0;

		HashSet<Character> set=new HashSet<Character>();

		while(right<s.length()){
			if(set.contains(s.charAt(right))){
				if(max<right-left){
					max=right-left;
				}
				while(s.charAt(left)!=s.charAt(right)){
					left++;
					set.remove(s.charAt(left));
				}
				left++;
			}else{
				set.add(s.charAt(right));
			}
			right++;
		}
		max=Math.max(max, right-left);
		return max;
	}
}