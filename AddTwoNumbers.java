/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       int carry =0;
 
        ListNode newHead = new ListNode(0);//newHead is an object, used for returning the head node
        ListNode p1 = l1, p2 = l2, p3=newHead;//p3 is a reference to this object
 
        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.val;
                p1 = p1.next;
            }
 
            if(p2 != null){
                carry += p2.val;
                p2 = p2.next;
            }
 
            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10; //if the result is greater than 10, the carry would be 1 and counted into next calculation round
        }
 
        if(carry==1) 
            p3.next=new ListNode(1);//the whole calculation generates a new carry
 
        return newHead.next;//pay attention to return value
    }
}