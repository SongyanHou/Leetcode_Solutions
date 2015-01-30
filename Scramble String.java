/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.*/

public class Solution{
	//naive solution: recursion+BF
	public boolean isScramble(String s1, String s2){
		if(s1==null||s2==null||s1.length()!=s2.length())
			return false;
		if(s1.length()==0)
			return true;

		//optimization
		char[]c1=s1.toCharArray(), c2=s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(!(new String(c1)).equals(new String(c2))) return false;
        else if(s1.length()==1)return true;


		for(int i=0; i<s1.length()-1; i++){
			if(isScramble(s1.substring(0,i+1),s2.substring(s2.length()-i-1))
				&& isScramble(s1.substring(i+1),s2.substring(0,s2.length()-i-1))
			|| isScramble(s1.substring(0,i+1),s2.substring(0,i+1)) 
                && isScramble(s1.substring(i+1),s2.substring(i+1)))
				return true;
		}
		return false;
	}
	//3 dimensional DP
	//res[i][j][n]: s1 start from i, s2 start from j, length=n
	//whether these two substrings are scramble to each other
		if(s1==null||s2==null||s1.length()!=s2.length())
			return false;
		if(s1.length()==0)
			return true;
		boolean[][][] res=new boolean[s1.length()][s2.length()][s1.length()+1];
		for(int i=0; i<s1.length(); i++){
			for(int j=0; j<s2.length(); j++){
				res[i][j][1]=s1.charAt(i)==s2.charAt(j);
			}
		}

		for(int len=2; len<=s1.length(); len++){
			for(int i=0; i<s1.length(); i++){
				for(int j=0; j<s2.length(); j++){
					for(int k=1; k<len; k++){
						res[i][j][len] |= res[i][j][k]&&res[i+k][j+k][len-k]
										||res[i+k][j][len-k]&&res[i][j+len-k][k]
					}
				}
			}
		}

		return res[0][0][s1.length()];
}