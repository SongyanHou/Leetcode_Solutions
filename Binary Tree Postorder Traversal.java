/*Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?*/
public class Solution{
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res=new ArrayList<Integer>();
		if(root==null)
			return res;
		helper(root, res);
	}

	private void helper(TreeNode root, List<Integer> res){
		if(root==null)
			return;
		helper(root.left, res);
		helper(root.right,res);
		res.add(root.val);
	}

	public List<Integer> postorderTraversalIter(TreeNode root){
		List<Integer> res=new ArrayList<Integer>();
		if(root==null)
			return res;
		LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
		TreeNode pre=null;

		while(root!=null || stack.isEmpty()){
			if(root!=null){
				stack.push(root);
				root=root.left;
			}
			else{
				TreeNode peekNode=stack.peek();
				if(peekNode.right!=null && pre!=peekNode.right){
					root=peekNode.right;
				}else{
					stack.pop();
					res.add(peekNode.val);
					pre=peekNode;
				}
			}
		}
		return res;
	}
}