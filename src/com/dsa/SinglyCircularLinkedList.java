package com.dsa;

public class SinglyCircularLinkedList {

	ListNode head, tail;

	public void insertAtEnd(int data) {
		ListNode newNode = new ListNode(data);
		if (head == null) {
			head = tail = newNode;
			newNode.next = head; // Circular link
		} else {
			tail.next = newNode;
			newNode.next = head;
			tail = newNode;
		}
	}

	public void reverse() {
		if (head == null || head.next == head) { // Empty or single node list
			return;
		}

		ListNode prev = null, current = head, nextNode;
		tail = head; // Tail becomes the original head

		do {
			nextNode = current.next;
			current.next = prev; // Reverse link
			prev = current;
			current = nextNode;
		} while (current != head);

		head.next = prev; // The new tail should point to the new head
		head = prev; // Update head to new first node
	}

	public void display() {
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}

		ListNode temp = head;
		do {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		} while (temp != head);
		System.out.println("(back to head)");
	}

	public static void main(String[] args) {

		SinglyCircularLinkedList cll = new SinglyCircularLinkedList();

		cll.insertAtEnd(10);
		cll.insertAtEnd(20);
		cll.insertAtEnd(30);
		cll.insertAtEnd(40);

		System.out.println("Original Circular Linked List:");
		cll.display();

		cll.reverse();
		System.out.println("Reversed Circular Linked List:");
		cll.display();

	}

}
