/*Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].*/

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
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> res=new ArrayList<Integer>();
    	if(root==null)
    		return res;
    	LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
    	stack.push(root);
    	while(!stack.isEmpty()){
    		TreeNode node=stack.pop();
    		res.add(node.val);
    		if(node.right!=null)
    			stack.push(node.right);
    		if(node.left!=null)
    			stack.push(node.left);
    	}
    	return res;
    }

    public List<Integer> preorderTraversalRec(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res){
    	if(root==null)
    		return;
    	res.add(root.val);
    	helper(root.left, res);
    	helper(root.right, res);
    }

}