/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.*/

public class Solution {
    public String getPermutation(int n, int k) {
    	if(n<=0)
    		return "";
    	k--;
    	StringBuilder sb=new StringBuilder();
    	ArrayList<Integer> num=new ArrayList<Integer>();
    	int fact=1;
    	for(int i=2; i<n; i++){
    		fact*=i;
    	}
    	for(int i=1; i<=n; i++)
    		num.add(i);
    	int round=n-1;
    	while(round>=0){
    		int index=k/fact;
    		sb.append(num.get(index));
    		num.remove(index);
    		k%=fact;
    		if(round>0)
    			fact/=round;
    		round--;
    	}
    	return sb.toString();
    }
}