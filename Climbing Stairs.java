/*
You are climbing a stair case. 
It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top?*/

public class Solution{
	public int climbStairs(int n){
		//f(i)=f(i-1)+f(i-2)
		
		if(n==1)
			return 1;
		if(n==2)
			return 2;

		int f1=1;
		int f2=2;

		for(int i=3; i<=n; i++){
			int f3=f1+f2;
			f1=f2;
			f2=f3;
		}
		return f2;
	}
}