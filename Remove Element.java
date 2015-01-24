/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.*/

public class Solution{
	public int removeElement(int A[], int elem){
		if(A==null||A.length==0)
			return 0;
		int index_old=0;
		int index_new=0;
		//two pointers
		//skip the element to be removed
		//once we find the elements that should be kept
		//we add it in the new position in the left
		//Space: O(1), Time: O(N)
		while(index_old<A.length){
			if(A[index_old]!=elem){
				A[index_new]=A[index_old];
				index_new++;
			}
			index_old++;
		}
		return index_new;
	}
}