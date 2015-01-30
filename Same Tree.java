/*Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.*/
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if(p==null)
    		return q==null;
    	if(q==null)
    		return p==null;
    	if(p.val!=q.val)
    		return null;
    	if(!isSameTree(p.left,q.left))
    		return false;
    	if(!isSameTree(p.right, q.right))
    		return false;
    	return true;
    }

    public boolean isSameTreeIter(TreeNode p, TreeNode q){
    	if(p==null)
    		return q==null;
    	if(q==null)
    		return p==null;

    	LinkedList<TreeNode> pstack=new LinkedList<TreeNode>();
    	LinkedList<TreeNode> qstack=new LinkedList<TreeNode>();

    	pstack.push(p);
    	qstack.push(q);

    	while(!pstack.isEmpty() && !qstack.isEmpty()){
    		TreeNode pNode=pstack.pop();
    		TreeNode qNode=qstack.pop();

    		if(pNode==null && qNode==null)
    			continue;
    		if(!(pNode!=null && qNode!=null))
    			return false;
    		if(pNode.val!=qNode.val)
    			return false;
    		pstack.push(pNode.left);
    		pstack.push(pNode.right);
    		qstack.push(qNode.left);
    		qstack.push(qNode.right);
    	}
    	if(!pstack.isEmpty())
    		return false;
    	if(!qstack.isEmpty())
    		return false;
    	return true;
    }
}