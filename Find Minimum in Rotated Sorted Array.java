/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int findMin(int[] num) {
        if(num==null||num.length==0)
        	return 0;
        int min=num[0];
        int l=0;
        int r=num.length-1;

        while(l<r-1){
        	int m=(l+r)/2;
        	if(num[l]<num[m]){
        		min=Math.min(min,num[l]);
        		l=m;
        	}else{
        		min=Math.min(min,num[m]);
        		r=m;
        	}
        }
        return min;
    }
}