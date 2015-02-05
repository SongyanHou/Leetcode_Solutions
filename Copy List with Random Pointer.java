/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
    	//deep copy: construct a new list with copies of each node of original
    	if(head==null)
    		return null;
    	HashMap<RandomListNode, RandomListNode> map=new HashMap<RandomListNode, RandomListNode>();
    	RandomListNode newHead=new RandomListNode(head.label);
    	map.put(head, newHead);
    	RandomListNode pre=newHead;
    	RandomListNode node=head.next;
    	while(node!=null){
    		RandomListNode newNode=new RandomListNode(node.label);
    		map.put(node, newNode);
    		pre.next=newNode;
    		pre=newNode;
    		node=node.next;
    	}
    	node=head;
    	RandomListNode copy=newHead;
    	while(node!=null){
    		copy.random=map.get(node.random);
    		copy=copy.next;
    		node=node.next;
    	}
    	return newHead;
    }

    public RandomListNode copyRandomListNoHashMap(RandomListNode head) {
    	if(head==null)
    		return;
    	RandomListNode node=head;
    	while(node!=null){
    		RandomListNode newNode=new RandomListNode(node.label);
    		newNode.next=node.next;
    		node.next=newNode;
    		node=newNode.next;
    	}
    	RandomListNode node=head;
    	while(node!=null){
    		if(node.random!=null)
	    		node.next.random=node.random.next;
    		node=node.next.next;
    	}
    	//split
    	RandomListNode newHead=head.next;
    	node=head;
    	while(node!=null){
    		RandomListNode newNode=node.next;
    		node.next=newNode.next;
    		if(newNode.next!=null)
    			newNode.next=newNode.next.next;
    		node=node.next;
    	}
    	return newHead;
    }
}