package com.dsa.fastandslowpointer;

import com.dsa.LinkedList;
import com.dsa.ListNode;

public class RemoveNthNodeFromEndofList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode res = new ListNode(0, head);
		ListNode dummy = res;

		for (int i = 0; i < n; i++) {
			head = head.next;
		}

		while (head != null) {
			head = head.next;
			dummy = dummy.next;
		}

		dummy.next = dummy.next.next;

		return res.next;

	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		int[] nums = { 1, 2, 3, 4, 5 };
		ListNode listNode = linkedList.createLinkedList(nums);

		RemoveNthNodeFromEndofList endofList = new RemoveNthNodeFromEndofList();
		endofList.removeNthFromEnd(listNode, 2);

	}

}
