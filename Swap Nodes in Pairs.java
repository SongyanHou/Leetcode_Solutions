/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.*/
public class Solution{
	public ListNode swapPairs(ListNode head){
		if(head==null)
			return head;
		ListNode dummy=new ListNode(-1);
		dummy.next=head;
		//to swap a pair, 
		//we must keep the info of 
		//forward node and backward node
		//p1 is always the node before the pair
		//p2 is always the first node of the pair
		ListNode p1=dummy;
		ListNode p2=head;

		while(p2!=null && p2.next!=null){
			ListNode temp=p2.next.next;
			p1.next=p2.next;
			p2.next.next=p2;
			p2.next=temp;
			p1=p2;
			p2=p2.next;
		}
		return dummy.next;
	}
}