/*Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.*/

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	//preorder: root, left, right
    	//inorder: left, root, right
    	//the first element of preorder array is the root value
    	//take the root as the partitioning point
    	//the left part of inorder array is left subtree
    	//and the right part of inorder array is right subtree
    	//recursive solution

    	if(preorder==null||inorder==null)
    		return null;
    	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    	for(int i=0; i<inorder.length; i++){
    		map.put(inorder[i], i);
    	}
    	return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }

    private TreeNode helper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, HashMap<Integer,Integer> map){
    	if(preL>preR||inL>inR)
    		return null;
    	TreeNode root=new TreeNode(preorder[preL]);
    	int index=map.get(root.val);
    	root.left=helper(preorder,preL+1,preL+index-inL, inorder,inL,index-1,map);
    	root.right=helper(preorder, preL+index-inL+1, preR, inorder,index+1,inR,map);
    	return root;
    }

}