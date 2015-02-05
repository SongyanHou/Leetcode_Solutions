/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
Credits:
Special thanks to @Shangrila for adding this problem and creating all test cases.*/

public class Solution{
	public String fractionToDecimal(int numerator, int denominator) {
		if(numerator==0)
			return "0";
		if(denominator==0)
			return "";

		String res="";
		if((numerator<0)^(denominator<0))
			res+="-";
		
		//in case of overflow (MIN_VALUE)
		long num=numerator;
		long den=denominator;

		num=Math.abs(num);
		den=Math.abs(den);

		long temp=num/den;
		res+=String.valueOf(temp);
		long rem=(num%den)*10;
		if(rem==0)
			return res;
		res+=".";
		HashMap<Long, Integer> map=new HashMap<Long, Integer>();
		while(rem!=0){
			if(map.containsKey(rem)){
				int begin=map.get(rem);
				String s1=res.substring(0,begin);
				String s2=res.substring(begin, res.length());
				res=s1+"("+s2+")";
				return res;
			}

			map.put(rem, res.length());
			temp=rem/den;
			res+=String.valueOf(temp);
			rem=(rem%den)*10;
		}

		return res;
	}

}