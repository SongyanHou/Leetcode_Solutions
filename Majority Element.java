/*Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.*/

public class Solution {
    public int majorityElement(int[] num) {
    	//each element votes for himself
    	//count the vote
        int candidate=0;
        int times=0;
        for(int i=0; i<num.length; i++){
            if(times==0){
                candidate=num[i];
                times++;
            }else{
                if(candidate==num[i]){
                    times++;
                }else{
                    times--;
                }
            }
        }
        return candidate;

        /*
        Naive method: sort the array first 
        and return the element in the middle position
        but that could work only if the majority element is guranteed to exist
        Arrays.sort(num);
        int len=num.length;
        return num[len/2];*/
    }
}