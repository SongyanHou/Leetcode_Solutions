/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]*/

public class Solution{
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		if(root==null)
			return res;
		ArrayList<Integer> item=new ArrayList<Integer>();
		item.add(root.val);
		res.add(item);
		int level=1;
		LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
		stack.push(root);
		//use two stack, one for each level
		//pat attention to the order (level)
		while(!stack.isEmpty()){
			LinkedList<Integer> newStack=new LinkedList<Integer>();
			ArrayList<Integer> item=new ArrayList<Integer>();
			while(!stack.isEmpty()){
				TreeNode node=stack.pop();
				if(level%2==0){
					if(node.left!=null){
						newStack.push(node.left);
						item.add(node.left.val);
					}
					if(node.right!=null){
						newStack.push(node.right);
						item.add(node.right.val);
					}
				}else{
					if(node.right!=null){
						newStack.add(node.right);
						item.add(node.right.val);
					}
					if(node.left!=null){
						newStack.add(node.left);
						item.add(node.left.val);
					}
				}
			}
			if(item.size()>0)
				res.add(item);
			stack=newStack;
			level++;
		}
		return res;
	}
}