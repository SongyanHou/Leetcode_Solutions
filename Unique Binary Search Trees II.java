/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3*/

public class Solution{
	public ArrayList<TreeNode> generateTrees(int n){
		return generate(1, n);
	}

	private ArrayList<TreeNode> generate(int l, int r){
		ArrayList<TreeNode> res=new ArrayList<TreeNode>();
		if(l>r){
			res.add(null);
			return res;
		}
		for(int i=l; i<=r; i++){
			ArrayList<TreeNode> lList=generate(l, i-1);
			ArrayList<TreeNode> rList=generate(i+1, r);
			for(int j=0; j<lList.size(); j++){
				for(int k=0; k<rList.size(); k++){
					TreeNode root=new TreeNode(i);
					root.left=lList.get(j);
					root.right=rList.get(k);
					res.add(root);
				}
			}
		}
		return res;
	}
}