package com.dsa.fastandslowpointer;

import java.util.ArrayList;
import java.util.List;

import com.dsa.LinkedList;
import com.dsa.ListNode;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		List<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}

		int left = 0;
		int right = list.size() - 1;
		while (left < right && list.get(left) == list.get(right)) {
			left++;
			right--;
		}

		return left >= right;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 1 };
		LinkedList linkedList = new LinkedList();
		ListNode listNode = linkedList.createLinkedList(nums);

		PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
		palindromeLinkedList.isPalindrome(listNode);

	}

}
