/*Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/

public class Solution{
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		//set two variables to record the number of elements in each level
		//when add elements into the queue, increase by 1
		//when poll out of queue, decrease by 1
		ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		if(root==null)
			return res;
		int curCount=1;
		int nextCount=0;
		LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
		ArrayList<Integer> levelRes=new ArrayList<Integer>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode temp=queue.poll();
			curCount--;
			levelRes.add(temp.val);

			if(temp.left!=null){
				queue.add(temp.left);
				nextCount++;
			}
			if(temp.right!=null){
				queue.add(temp.right);
				nextCount++;
			}
			if(curCount==0){
				res.add(levelRes);
				curCount=nextCount;
				nextCount=0;
				levelRes=new ArrayList<Integer>();
			}
		}
		Collections.reverse(res);
		return res;
	}
		//solve as I does, just reverse the whole list in the end
}