/*Given s1, s2, s3, 
find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.*/

public class Solution{
	public boolean isInterleave(String s1,String s2,String s3){
		//DP: res[i][j] -- the first i+j chars of s3 could be interleaved by
		//the first i chars of s1 and the first j chars of s2
		//res[i][j] = res[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1)
		//			||res[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1)
		//T=O(m*n)

		if(s1.length()+s2.length()!=s3.length())
			return false;
		String minWord=s1.length()>s2.length()?s2:s1;
		String maxWord=s1.length()>s2.length()?s1:s2;
		boolean[] res=new boolean[minWord.length()+1];
		res[0]=true;
		for(int i=1; i<res.length; i++)
			res[i]=res[i-1] && minWord.charAt(i-1)==s3.charAt(i-1);
		for(int i=0; i<maxWord.length(); i++){
			res[0]=res[0]&&maxWord.charAt(i)==s3.charAt(i);
			for(int j=0; j<minWord.length(); j++){
				res[j+1]=res[j+1]&&maxWord.charAt(i)==s3.charAt(i+j+1)
						||res[j]&&minWord.charAt(j)==s3.charAt(i+j+1);
			}
		}
		return res[minWord.length()];
	}
}