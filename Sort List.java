/*Sort a linked list in O(n log n) time using constant space complexity.*/

public class Solution{
	public ListNode sortList(ListNode head){
		return mergeSort(head);
	}
	private ListNode mergeSort(ListNode head){
		if(head==null||head.next==null)
			return head;
		ListNode fast=head;
		ListNode slow=head;
		//trick: to split a list into two half, 
		//move the slow pointer to the node before the second list
		//then let this node point to null
		//so the fast pointer should move one node faster
		while(fast.next!=null&&fast.next.next!=null)
		{
			fast=fast.next.next;
			slow=slow.next;
		}
		ListNode head2=slow.next;
		slow.next=null;
		ListNode head1=head;
		mergeSort(head1);
		mergeSort(head2);
		return merge(head1, head2);
	}

	private ListNode merge(ListNode head1, ListNode head2){
		//dummy node to keep the head
		ListNode helper=new ListNode(0);
		helper.next=head1;
		ListNode pre=helper;

		while(head1!=null && head2!=null){
			if(head1.val<head2.val)
				head1=head1.next;
			else{
				ListNode temp=head2.next;
				head2.next=pre.next;
				pre.next=head2;
				head2=temp;
			}
			pre=pre.next;
		}
		while(head2!=null){
			pre.next=head2;
		}
		return helper.next;
	}
}