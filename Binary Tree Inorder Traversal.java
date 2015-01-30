/*Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?*/

public class Solution{
	public List<Integer> inorderTraversalRec(TreeNode root){
		List<Integer> res=new ArrayList<Integer>();
		if(root==null)
			return res;
		helper(root, res);
		return res;
	}
	private void helper(TreeNode root, List<Integer> res){
		if(root==null)
			return;
		helper(root.left, res);
		res.add(root.val);
		helper(root.right,res);
	}

	public List<Integer> inorderTraversalIter(TreeNode root){
		List<Integer> res=new ArrayList<Integer>();
		LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
		while(root!=null||!stack.isEmpty()){
			if(root!=null){
				stack.push(root);
				root=root.left;
			}else{
				root=stack.pop();
				res.add(root.val);
				root=root.right;
			}
		}
		return res;
	}
}