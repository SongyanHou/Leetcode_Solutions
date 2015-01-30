/*
Given a string S and a string T, 
count the number of distinct subsequences of T in S.

A subsequence of a string is a new string 
which is formed from the original string 
by deleting some (can be none) of the characters 
without disturbing the relative positions of the remaining characters. 
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.*/

public class Solution {
    public int numDistinct(String S, String T) {
    	if(T.length()==0)
    		return 1;
    	if(S.length()==0)
    		return 0;
    	//2 dimensional DP problem
    	//res[i][j]: # of substrings for first i in S and first j in T
    	//if S.charAt(i)==T.charAt(j)
    	//res[i][j]=res[i-1][j-1]+res[i-1][j]
    	//else res[i][j]=res[i-1][j]
    	
    	int[] res=new int[T.length()+1];
    	res[0]=1;
    	for(int i=0; i<S.length(); i++){
    		for(int j=T.length()-1; j>=0; j--){
    			res[j+1]=(S.charAt(i)==T.charAt(j)?res[j]:0)+res[j+1];
    		}
    	}
    	return res[T.length()];
    }

}