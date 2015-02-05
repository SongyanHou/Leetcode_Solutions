/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.*/

public class Solution{
	public ListNode rotateRight(ListNode head, int n){
		if(head==null||head.next==null)
			return head;
		int i=0;

		ListNode fast=head;
		ListNode slow=head;

		while(fast!=null && i<n){
			fast=fast.next;
			i++;
		}
		//in case n>list length
		if(fast==null){
			n%=i;
			fast=head;
			i=0;
			while(i<n){
				fast=fast.next;
				i++;
			}
		}
		while(fast.next!=null){
			fast=fast.next;
			slow=slow.next;
		}
		ListNode newHead=slow.next;
		slow.next=null;
		fast.next=head;
		return newHead;
	}
}