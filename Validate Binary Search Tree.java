/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/

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
    public boolean isValidBST(TreeNode root) {
    	ArrayList<Integer> pre=new ArrayList<Integer>();
    	pre.add(null);
    	return helper(root, pre);
    }

    private boolean helper(TreeNode root, ArrayList<Integer> pre){
    	if(root==null)
    		return true;
    	boolean left=helper(root.left, pre);
    	if(pre.get(0)!=null && root.val<=pre.get(0))
    		return false;
    	pre.set(0, root.val);
    	return helper(root.right,pre)&&left;
    }
