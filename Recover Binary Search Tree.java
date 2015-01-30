/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. 
Could you devise a constant space solution?*/

public class Solution{
	public void recoverTree(TreeNode root) {
		//similar idea as check valid BST
		//once found node that does not match the requirements
		//store in the list
		//then swap these two nodes in the end

		if(root==null)
			return;
		ArrayList<TreeNode> pre=new ArrayList<TreeNode>();
		ArrayList<TreeNode> res=new ArrayList<TreeNode>();
		pre.add(null);
		helper(root, pre, res);
		if(res.size()>0){
			int temp=res.get(0).val;
			res.get(0).val=res.get(1).val;
			res.get(1).val=temp;
		}
	}

	private void helper(TreeNode root, ArrayList<TreeNode> pre, ArrayList<TreeNode> res){
		if(root==null)
			return;
		helper(root.left, pre, res);
		if(pre.get(0)!=null && pre.get(0).val>root.val){
			if(res.size()==0){
				res.add(pre.get(0));
				res.add(root);
			}else{
				res.set(1,root);
			}
		}
		pre.set(0,root);
		helper(root.right, pre,res);
	}

}