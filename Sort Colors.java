/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.*/

public class Solution{
	public void sortColors(int A[]){
		//straight forward solution: count the number of 0 1 and 2
		//then rewrite the array with these counts
		//Here is a one-pass solution:
		//set two pointers: 0 pointer and 2 pointer
		//Both of them are pointing to the next position to insert 0/2
		int idx0=0;
		int idx2=A.length-1;
		int i=0;
		while(i<idx2){
			if(A[i]==0){
				int temp=A[i];
				A[i]=A[idx0];
				A[idx0]=temp;
				idx0++;
				i++;
				continue;
			}
			if(A[i]==2){
				//when finding 2, do not increase i in case of duplicated 2
				int temp=A[i];
				A[i]=A[idx2];
				A[idx2]=temp;
				idx2--;
				continue;
			}
			i++;
		}
	}
}