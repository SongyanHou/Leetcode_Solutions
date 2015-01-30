/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL*/
public class Solution{
	public void connect(TreeLinkNode root) {
		if(root==null)
			return;
		
		TreeLinkNode rootnext=root.next;
		TreeLinkNode next=null;

		while(rootnext!=null){
			if(rootnext.left!=null){
				next=rootnext.left;
				break;
			}else if(rootnext.right!=null){
				next=rootnext.right;
				break;
			}else{
				rootnext=rootnext.next;
			}
		}
		if(root.right!=null){
			root.right.next=next;
		}
		if(root.left!=null){
			if(root.right!=null)
				root.left.next=root.right;
			else
				root.left.next=next;
		}
		connect(root.right);
		connect(root.left);
	}
}