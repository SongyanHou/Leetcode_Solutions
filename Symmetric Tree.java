/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetricRec(TreeNode root) {
    	if(root==null)
    		return true;
    	return isSym(root.left, root.right);
    }

    private boolean isSym(TreeNode left, TreeNode right){
    	if(left==null)
    		return right==null;
    	if(right==null)
    		return left==null;
    	if(left.val!=right.val)
    		return false;
    	if(!isSym(left.left, right.right))
    		return false;
    	if(!isSym(left.right, right.left))
    		return false;
    	return true;
    }

    public boolean isSymmetricIter (TreeNode root){
    	if(root==null)
    		return true;
    	LinkedList<TreeNode> lstack=new LinkedList<TreeNode>();
    	LinkedList<TreeNode> rstack=new LinkedList<TreeNode>();

    	lstack.push(root.left);
    	rstack.push(root.right);

    	while(!lstack.isEmpty() && !rstack.isEmpty()){
    		TreeNode lNode=lstack.pop();
    		TreeNode rNode=rstack.pop();

    		if(lNode==null && rNode==null)
    			continue;
    		if(!(lNode!=null && rNode!=null))
    			return false;
    		if(lNode.val!=rNode.val)
    			return false;
    		lstack.push(lNode.left);
    		rstack.push(rNode.right);
    		lstack.push(lNode.right);
    		rstack.push(rNode.left);
    	}
    	if(!lstack.isEmpty())
    		return false;
    	if(!rstack.isEmpty())
    		return false;
    	return true;

    }
}