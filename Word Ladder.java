/*Given two words (start and end), 
and a dictionary, find the length of shortest transformation sequence 
from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.*/

public class Solution{
	public int ladderLength(String start, String end,
            	HashSet<String> dict) {
		if(dict==null)
			return 0;
		dict.add(start);
		dict.add(end);
		int res=BFS(start, end, dict);
		return res;
	}

	private int BFS(String start, String end,
            	HashSet<String> dict){
		Queue<String> queue=new Queue<String>();
		Queue<Integer> lenque=new Queue<Integer>();
		queue.add(start);
		lenque.add(1);

		while(!queue.empty()){
			String item=queue.poll();
			int len=lenque.poll();

			if(item.equals(end))
				return len;
			for(int i=0; i<item.length(); i++){
				char[] arr=item.toCharArray();
				for(char c='a'; c<='z'; c++){
					if(c==arr[i])
						continue;
					arr[i]=c;
					String str=String.valueOf(arr);
					if(dict.contains(str)){
						queue.add(str);
						lenque.add(len+1);
						dict.remove(str);
					}
				}
			}
		}
		return 0;
	}
}