/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]*/
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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    	if(root==null)
    		return res;
    	ArrayList<Integer> item=new ArrayList<Integer>();
    	item.add(root.val);
    	helper(root, item, res, sum-root.val);
    	return res;
    }

    private void helper(TreeNode root, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res, int sum){
    	if(root==null)
    		return;
    	if(root.left==null && root.right==null && sum==0){
    		res.add(new ArrayList<Integer>(item));
    		return;
    	}
    	if(root.left!=null){
    		item.add(root.left.val);
    		helper(root.left, item, res, sum-root.left.val);
    		item.remove(item.size()-1);
    	}
    	if(root.right!=null){
    		item.add(root.right.val);
    		helper(root.right, item, res, sum-root.right.val);
    		item.remove(item.size()-1);
    	}
    }