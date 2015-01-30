/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.*/

public class Solution{
	public void flatten(TreeNode root){
		//similar as preorder traversal
		//use a list to store each temp node (in place)
		if(root==null)
			return;
		ArrayList<TreeNode> pre=new ArrayList<TreeNode>();
		pre.add(null);
		helper(root, pre);
	}
	private void helper(TreeNode root, ArrayList<TreeNode> pre){
		if(root==null)
			return;
		//store the right child
		TreeNode right=root.right;
		if(pre.get(0)!=null){
			pre.get(0).left=null;
			pre.get(0).right=root;
		}
		pre.set(0, root);
		helper(root.left, pre);
		helper(right,pre);
	}
}