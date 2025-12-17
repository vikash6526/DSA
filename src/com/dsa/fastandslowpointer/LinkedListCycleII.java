package com.dsa.fastandslowpointer;

import com.dsa.ListNode;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break;
			}
		}

		if (fast == null || fast.next == null) {
			return null;
		}

		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;

	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(3);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(0);
		listNode.next.next.next = listNode.next;

		LinkedListCycleII linkedListCycleII = new LinkedListCycleII();
		linkedListCycleII.detectCycle(listNode);

	}

}
