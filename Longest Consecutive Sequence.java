/*
Given an unsorted array of integers, 
find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is 
[1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.*/

public class Solution{
	public int longestConsecutive(int[] num) {
		//build a set to store all elements
		//for each element, search in both directions
		//once a consecutive element is found, remove it from the set
		//Time: O(N)
		if(num==null||num.length==0)
			return 0;
		int res=1;
		HashSet<Integer> set=new HashSet<Integer>();
		for(int i=0; i<num.length; i++)
			set.add(num[i]);
		while(!set.isEmpty()){
			Iterator iter=set.iterator();
			int item=(Integer)iter.next();
			set.remove(item);
			int len=1;
			//to smaller side
			int i=item-1;
			while(set.contains(i)){
				len++;
				set.remove(i);
				i--;
			}
			//to bigger side
			i=item+1;
			while(set.contains(i)){
				len++;
				set.remove(i);
				i++;
			}
			if(len>res)
				res=len;
		}
		return res;
	}
}