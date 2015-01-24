/*Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.*/

public class Solution{
	public int[] plusOne(int[] digits){
		//start from the LSB
		//if there is a carry, keep moving left
		//notice: there might be one more bit than the original number
		if(digits==null||digits.length==0)
			return null;
		int len=digits.length;
		while(len>=0){
			if(digits[len]+1>9){
				digits[len]=0;
				carry=1;
				len--;
			}else{
				digits[len]+=1;
				return digits;
			}
		}
		//there is one more bits in the result
		//999+1=1000
		if(carry==1){
			int[] res=new int[digits.length+1];
			res[0]=1;
			for(int i=1; i<res.length; i++){
				res[i]=digits[i-1];
			}
			return res;
		}
		return digits;
	}
}