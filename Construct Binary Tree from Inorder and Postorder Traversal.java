/*Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	//same solution as building tree from preorder and inorder

    	if(inorder==null||preorder==null)
    		return null;
    	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    	for(int i=0; i<inorder.length; i++){
    		map.put(inorder[i],i);
    	}
    	return helper(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
    }

    private TreeNode helper(int[] postorder, int postL, int postR, int[] inorder, int inL, int inR, HashMap<Integer,Integer> map){
    	if(postL>postR||inL>inR)
    		return null;
    	TreeNode root=new TreeNode(postorder[postR]);
    	int index=map.get(root.val);
    	root.left=helper(postorder,postL,postL+index-inL-1, inorder,inL,index-1, map);
    	root.right=helper(postorder,postL+index-inL,postR-1,inorder,index+1,inR+1,map);

    	return root;
    }