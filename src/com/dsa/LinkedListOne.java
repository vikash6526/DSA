package com.dsa;

public class LinkedListOne {

	ListNode head;

	public void add(int data) {
		ListNode newNode = new ListNode(data);
		if (head == null) {
			head = newNode;
		} else {
			ListNode temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	public void display() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " - > ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	public ListNode reverseRecursion(ListNode current) {
		if (current == null || current.next == null) {
			return current;
		}

		ListNode newHead = reverseRecursion(current.next);
		current.next.next = current;
		current.next = null;
		return newHead;
	}

	public void reverseRecursiveHelper() {
		head = reverseRecursion(head);
	}

	public static void main(String[] args) {
		LinkedListOne linkedList = new LinkedListOne();
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(30);
		linkedList.add(40);
		linkedList.add(50);

		System.out.println("Linked List:");
		linkedList.display();

		linkedList.reverseRecursiveHelper();
		System.out.println("Reversed (Recursive):");
		linkedList.display();
	}

}
