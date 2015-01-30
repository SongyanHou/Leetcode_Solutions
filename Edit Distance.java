/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character*/
public class Solution{
	public int minDistance(String s1,String s2){
		//2-dimensional DP problem
		//res[i][j]:# of steps needed to convert s1 (0--i) to s2 (0--j)
		//s1.charAt(i)==s2.charAt(j): res[i][j]=res[i-1][j-1]
		//if not
		//1. add a char to s1 =res[i-1][j]+1
		//2. add a char to s2 =res[i][j-1]+1
		//3. replace a char =res[i-1][j-1]+1
		//take the min of these three values

		
		String minWord=s1.length()>s2.length()?s2:s1;
		String maxWord=s1.length()>s2.length()?s1:s2;

		int[] res=new int[minWord.length()+1];
		for(int i=0; i<minWord.length(); i++){
			res[i]=i;
		}

		for(int i=0; i<maxWord.length(); i++){
			int[] newRes=new int[minWord.length()+1];
			newRes[0]=i+1;
			for(int j=0; j<minWord.length(); j++){
				if(minWord.charAt(j)==maxWord.charAt(i)){
					newRes[j+1]=res[j];
				}else{
					newRes[j+1]=Math.min(res[j+1], Math.min(newRes[j], res[j]))+1;
				}
			}
			res=newRes;
		}
		return res[minWord.length()];
	}
}