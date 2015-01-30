/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. 
You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).*/

public class Solution {
    public int maxProfit(int[] prices) {

    	//local max and global max
    	//local[i][j]: the max profit at ith day, after j transactions
    	//and the last transaction is on the ith day
    	//global[i][j]: the max profit at ith day, after j transactions
    	//global[i][j]=max(global[i-1][j], local[i][j])
    	//local[i][j]=max(global[i-1][j-1]+diff>0?diff:0, local[i-1][j]+diff)
    	//the result is global[i][k]
    	if(prices==null||prices.length==0)
    		return 0;
    	int[] local=new int[3];
    	int[] global=new int[3];
    	for(int i=0; i<prices.length-1; i++){
    		int diff=prices[i+1]-prices[i];
    		for(int j=2; j>=1; j--){
    			local[j]=Math.max(local[j]+diff, global[j-1]+(diff>0?diff:0));
    			global[j]=Math.max(global[j],local[j]);
    		}
    	}
    	return global[2];
    }
}