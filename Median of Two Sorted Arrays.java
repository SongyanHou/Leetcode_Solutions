/*
There are two sorted arrays A and B of size m and n respectively. 
Find the median of the two sorted arrays. 
The overall run time complexity should be O(log (m+n)).
*/

public class Solution{
	public double findMedianSortedArrays(int A[], int B[]) {
		//first solution:
		//like merge sorted arrays, stop at the (m+n)/2 th element
		//Time complexity: O(m+n), Space: O(1)

		//optimized solution: order statistics
		//get the k=(m+n)/2 th number in two arrays
		//check the k/2 th element in each array
		//if A[k/2]==B[k/2], then this number is the k th number
		//else if A[k/2]>B[k/2], then the first k/2 elements in B does not include the result
		//then we could exclude k/2 elements (and vice versa)
		//keep calculating in this way, until k==1
		//Time: O(log(k))=O(log(m+n))
		//Space: the size of recursion stack(O(log(m+n)))

		if((A.length+B.length)%2==1)
			return helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2+1);
		else
			return (helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2+1)
				+ helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2))/2.0;
	}

	private int helper(int[] A, int[] B, int i, int i2, int j, int j2, int k){
		int m=i2-i+1;
		int n=j2-j+1;

		if(m>n)
			return helper(B,A,j,j2,i,i2,k);
		if(m==0)
			return B[j+k-1];
		if(k==1)
			return Math.min(A[i],B[j]);
		int posA=Math.min(k/2, m);
		int posB=k-posA;
		if(A[i+posA-1]==B[j+posB-1])
			return A[i+posA-1];
		else if(A[i+posA-1]>B[j+posB-1])
			return helper(A,B,i,i+posA-1,j+posB,j2,k-posB);
		else
			return helper(A,B,i+posA,i2,j,j+posB-1,k-posA);
	}
}